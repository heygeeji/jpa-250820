package com.example.domain.wiseSaying.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id //jpa는 식별자가 반드시!! 필요
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) //autoincrement
    private int id;
    private String saying; //varchar(255)

    @Column(columnDefinition = "TEXT") //안하면 default varchar(255)
    private String author;


}

//class article { } -> jpa -> create table article()
