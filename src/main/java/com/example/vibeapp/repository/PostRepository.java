package com.example.vibeapp.repository;

import com.example.vibeapp.domain.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private static final List<Post> posts = new ArrayList<>();
    private static long sequence = 0;

    static {
        for (long i = 1; i <= 10; i++) {
            posts.add(new Post(
                i,
                "테스트 게시글 제목 " + i,
                "테스트 게시글 내용입니다. " + i,
                LocalDateTime.now().minusDays(10 - i),
                LocalDateTime.now().minusDays(10 - i),
                (int) (Math.random() * 100)
            ));
        }
        sequence = 10;
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }

    public Optional<Post> findByNo(Long no) {
        return posts.stream()
                .filter(post -> post.getNo().equals(no))
                .findFirst();
    }

    public Post save(Post post) {
        post.setNo(++sequence);
        posts.add(post);
        return post;
    }

    public void deleteByNo(Long no) {
        posts.removeIf(post -> post.getNo().equals(no));
    }
}
