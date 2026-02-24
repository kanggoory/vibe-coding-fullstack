package com.example.vibeapp.post;

import com.example.vibeapp.post.dto.PostCreateDto;
import com.example.vibeapp.post.dto.PostListDto;
import com.example.vibeapp.post.dto.PostResponseDto;
import com.example.vibeapp.post.dto.PostUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Map<String, Object> getPagedPosts(int page, int size) {
        long totalItems = postRepository.count();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        int offset = (page - 1) * size;

        List<PostListDto> posts = postRepository.findList(offset, size).stream()
                .map(PostListDto::from)
                .toList();

        Map<String, Object> result = new HashMap<>();
        result.put("posts", posts);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);
        result.put("totalItems", totalItems);
        result.put("hasNext", page < totalPages);
        result.put("hasPrev", page > 1);

        return result;
    }

    public PostResponseDto getPostById(Long id) {
        postRepository.incrementViews(id);
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post id: " + id));
        return PostResponseDto.from(post);
    }

    public void createPost(PostCreateDto createDto) {
        Post post = createDto.toEntity();
        post.setCreatedAt(java.time.LocalDateTime.now());
        post.setUpdatedAt(null);
        post.setViews(0);
        post.setNo(null); // Repository will set this
        postRepository.save(post);
    }

    public void updatePost(Long id, PostUpdateDto updateDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post id: " + id));
        post.setTitle(updateDto.title());
        post.setContent(updateDto.content());
        post.setUpdatedAt(java.time.LocalDateTime.now());
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
