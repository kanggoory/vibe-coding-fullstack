package com.example.vibeapp.post;

import com.example.vibeapp.post.dto.PostCreateDto;
import com.example.vibeapp.post.dto.PostUpdateDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        Map<String, Object> pagedData = postService.getPagedPosts(page, 5);
        model.addAllAttributes(pagedData);
        return "post/posts";
    }

    @GetMapping("/posts/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post/post_detail";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post/post_edit_form";
    }

    @GetMapping("/posts/new")
    public String newForm(Model model) {
        model.addAttribute("postCreateDto", new PostCreateDto(null, null));
        return "post/post_new_form";
    }

    @PostMapping("/posts/add")
    public String add(@Valid @ModelAttribute("postCreateDto") PostCreateDto postCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "post/post_new_form";
        }
        postService.createPost(postCreateDto);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/save")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("post") PostUpdateDto postUpdateDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("postId", id); // For cancel link or other needs
            return "post/post_edit_form";
        }
        postService.updatePost(id, postUpdateDto);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        postService.deletePostById(id);
        return "redirect:/posts";
    }
}
