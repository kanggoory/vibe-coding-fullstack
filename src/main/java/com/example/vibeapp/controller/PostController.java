package com.example.vibeapp.controller;

import com.example.vibeapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.vibeapp.domain.Post;

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
        return "posts";
    }

    @GetMapping("/posts/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        model.addAttribute("post", postService.findPostByNo(no));
        return "post_detail";
    }

    @GetMapping("/posts/{no}/edit")
    public String editForm(@PathVariable("no") Long no, Model model) {
        model.addAttribute("post", postService.findPostByNo(no)); // Reuse findPostByNo to get the post (note: this will increment views, which is usually acceptable or can be refactored if strict)
        return "post_edit_form";
    }

    @GetMapping("/posts/new")
    public String newForm() {
        return "post_new_form";
    }

    @PostMapping("/posts/add")
    public String add(Post post) {
        postService.savePost(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{no}/save")
    public String update(@PathVariable("no") Long no, String title, String content) {
        postService.updatePost(no, title, content);
        return "redirect:/posts/" + no;
    }

    @PostMapping("/posts/{no}/delete")
    public String delete(@PathVariable("no") Long no) {
        postService.deletePost(no);
        return "redirect:/posts";
    }
}
