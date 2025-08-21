package com.example.global.initData;

import com.example.domain.wiseSaying.entity.Post;
import com.example.domain.wiseSaying.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner initDataRunner() { //application 실행될 때 딱 한번 실행
        return args -> {
            work1();
            work2();
        };
    }

    void work1() { // 등록

        if(postRepository.count() > 0) {
            return;
        }

        Post post1 = new Post("제목1", "내용1");
        postRepository.save(post1);

        Post post2 = new Post("제목2", "내용2");
        postRepository.save(post2);
    }

    void work2() { //조회
        postRepository.findById(1);
    }
}


