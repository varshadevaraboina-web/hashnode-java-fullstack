package com.hashnode.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hashnode.backend.entity.Post;
import com.hashnode.backend.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // CREATE
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // READ
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // UPDATE
    public Post updatePost(Long id, Post post) {

        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());

        return postRepository.save(existingPost);
    }

    // DELETE
    public void deletePost(Long id) {

        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post not found");
        }

        postRepository.deleteById(id);
    }
}