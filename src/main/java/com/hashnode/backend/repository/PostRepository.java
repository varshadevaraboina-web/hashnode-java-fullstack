package com.hashnode.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashnode.backend.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}