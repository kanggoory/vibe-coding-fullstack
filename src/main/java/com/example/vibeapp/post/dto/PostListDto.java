package com.example.vibeapp.post.dto;

import com.example.vibeapp.post.Post;
import java.time.LocalDateTime;

public class PostListDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private Integer views;

    public PostListDto() {}

    private PostListDto(Long id, String title, LocalDateTime createdAt, Integer views) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.views = views;
    }

    public static PostListDto from(Post post) {
        return new PostListDto(
                post.getId(),
                post.getTitle(),
                post.getCreatedAt(),
                post.getViews()
        );
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Integer getViews() { return views; }
}
