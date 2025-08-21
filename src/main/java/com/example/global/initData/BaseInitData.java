package com.example.global.initData;

import com.example.domain.post.entity.Post;
import com.example.domain.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class BaseInitData {

    @Autowired
    private PostService postService;

    @Bean
    ApplicationRunner initDataRunner() { //application 실행될 때 딱 한번 실행
        return args -> {
            work1();
            work2();
        };
    }

    void work1() { // 등록

        if(postService.getTotalCount() > 0) {
            return;
        }

        // Service를 도입해서 비즈니스 로직을 재사용
        postService.write("제목1", "내용1");
        postService.write("제목2", "내용2");
    }

    void work2() { //조회

        Optional<Post> opPost = postService.getPost(1);
    }
}


