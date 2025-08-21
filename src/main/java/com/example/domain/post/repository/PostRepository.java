package com.example.domain.post.repository;

import com.example.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//자동 bean등록 됨
public interface PostRepository extends JpaRepository<Post, Integer> {//Post객체를 다루겠다, id의 타입이 int여서 Integer
 //   void save(); //라는 추상메서드 있을 때 jpa가 구현해줌, save안적어도 존재
    // jpa가 구현해주므로 그냥 사용하면 됨.
}
