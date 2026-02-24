package com.example.vibeapp.post;

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

    public Optional<Post> findById(Long id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
    }

    public List<Post> findList(int offset, int limit) {
        return posts.stream()
                .sorted((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()))
                .skip(offset)
                .limit(limit)
                .toList();
    }

    public long count() {
        return posts.size();
    }

    public Post save(Post post) {
        post.setId(++sequence);
        posts.add(post);
        return post;
    }

    public void deleteById(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
}
