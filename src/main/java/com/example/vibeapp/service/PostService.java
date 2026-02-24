package com.example.vibeapp.service;

import com.example.vibeapp.domain.Post;
import com.example.vibeapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Map<String, Object> getPagedPosts(int page, int size) {
        long totalItems = postRepository.count();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        int offset = (page - 1) * size;

        List<Post> posts = postRepository.findList(offset, size);

        Map<String, Object> result = new HashMap<>();
        result.put("posts", posts);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);
        result.put("totalItems", totalItems);
        result.put("hasNext", page < totalPages);
        result.put("hasPrev", page > 1);

        return result;
    }

    public Post findPostByNo(Long no) {
        Post post = postRepository.findByNo(no)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post number: " + no));
        post.setViews(post.getViews() + 1);
        return post;
    }

    public void savePost(Post post) {
        post.setCreatedAt(java.time.LocalDateTime.now());
        post.setUpdatedAt(null);
        post.setViews(0);
        post.setNo(null); // Repository will set this
        postRepository.save(post);
    }

    public void updatePost(Long no, String title, String content) {
        Post post = postRepository.findByNo(no)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post number: " + no));
        post.setTitle(title);
        post.setContent(content);
        post.setUpdatedAt(java.time.LocalDateTime.now());
    }

    public void deletePost(Long no) {
        postRepository.deleteByNo(no);
    }
}
