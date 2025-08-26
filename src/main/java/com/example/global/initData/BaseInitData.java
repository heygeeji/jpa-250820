package com.example.global.initData;

import com.example.domain.post.entity.Post;
import com.example.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    @Autowired
    @Lazy
    private BaseInitData self;
    private final PostService postService; // 재사용 가능하기 때문에 final

//    public BaseInitData(PostService postService) {
//        this.postService = postService;
//    }

    @Bean
//    @Transactional
    ApplicationRunner initDataRunner() { //application 실행될 때 딱 한번 실행
        return args -> {
            self.work1();
            self.work2();
//            new Thread(() -> {
//                self.work3();
//            }).start(); // springboot가 안꺼지게 해줌.
            self.work4();
        };
    }

    // 생성
    @Transactional(readOnly=true)
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

    // 삭제
    @Transactional
    void work3() {

        Post post1 = postService.getPost(1).get();
        Post post2 = postService.getPost(2).get();

        postService.delete(post1); //jpa가 젛해놓은 트랜잭션

        if(true) throw new RuntimeException("테스트용 예외 발생");

        postService.delete(post2); //트랜잭션
    }

    @Transactional
    void work4() {
        Post post1 = postService.getPost(1).get();
        postService.modify(post1, "제목1-수정","내용1-수정");
    }
}


