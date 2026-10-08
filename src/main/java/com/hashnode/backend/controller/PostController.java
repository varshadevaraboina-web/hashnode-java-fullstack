package com.hashnode.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashnode.backend.entity.Post;
import com.hashnode.backend.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // CREATE
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // READ
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Post updatePost(
            @PathVariable Long id,
            @RequestBody Post post) {

        return postService.updatePost(id, post);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {

        postService.deletePost(id);

        return "Post deleted successfully";
    }
}