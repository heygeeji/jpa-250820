package com.example.global.initData;

import com.example.domain.post.entity.Post;
import com.example.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService; // 재사용 가능하기 때문에 final

//    public BaseInitData(PostService postService) {
//        this.postService = postService;
//    }

    @Bean
    @Transactional
    ApplicationRunner initDataRunner() { //application 실행될 때 딱 한번 실행
        return args -> {
            work1();
            work2();
        };
    }

    // 생성
    @Transactional
    void work1() {

        if(postService.getTotalCount() > 0) {
            return;
        }

        // Service를 도입해서 비즈니스 로직을 재사용
        postService.write("제목1", "내용1");
        postService.write("제목2", "내용2");
    }

    // 조회
    @Transactional
    void work2() { //조회

        Optional<Post> opPost = postService.getPost(1);
    }
}


