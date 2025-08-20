package com.example.global.initData;

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
//            System.out.println("초기 데이터를 로딩합니다.");

//            Post post1 = new Post();
//            post1.setTitle("첫 번째 게시글");
//            post1.setContent("첫 번째 게시글 내용입니다.");
//
//            postRepository.save(post1);

            postRepository.count(); // select count(*) from post;
        };
    }
}
