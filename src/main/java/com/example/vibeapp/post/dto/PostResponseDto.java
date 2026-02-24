package com.example.vibeapp.post.dto;

import com.example.vibeapp.post.Post;
import java.time.LocalDateTime;

public record PostResponseDto(
    Long id,
    String title,
    String content,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    Integer views
) {
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public Integer getViews() { return views; }

    public static PostResponseDto from(Post post) {
        return new PostResponseDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getViews()
        );
    }
}
