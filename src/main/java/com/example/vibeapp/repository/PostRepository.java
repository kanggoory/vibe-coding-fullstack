package com.example.vibeapp.repository;

import com.example.vibeapp.domain.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private static final List<Post> posts = new ArrayList<>();

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
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }
}
