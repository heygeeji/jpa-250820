package com.example.domain.wiseSaying.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Post {
    @Id //jpa는 식별자가 반드시!! 필요
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) //autoincrement
    private int id;
    private final String title; //varchar(255)

    @Column(columnDefinition = "TEXT") //안하면 default varchar(255)
    private final String content;
    //제목, 내용은 수정 가능성이 있기 때문에 final은 안쓰는게 맞음.

    public Post(){
        this.title="";
        this.content = "";
    } //기본 생성자 ->Post 빨간 줄 사라짐
//    //Jpa에서는 기본생성자 요구
//
//    public Post(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }


}

//class article { } -> jpa -> create table article()
