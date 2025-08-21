package com.example.domain.post.service;

import com.example.domain.post.entity.Post;
import com.example.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void write(String title, String content) {
        //비즈니스 로직(검증) if

        Post post = new Post(title, content);
        postRepository.save(post);
    }


    public Optional<Post> getPost(int id) {
        return postRepository.findById(id);
    }

    public long getTotalCount() {
        return postRepository.count();
    }
}
