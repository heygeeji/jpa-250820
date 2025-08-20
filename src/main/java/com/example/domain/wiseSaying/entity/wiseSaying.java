package com.example.domain.wiseSaying.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class wiseSaying {
    @Id //jpa는 식별자가 반드시!! 필요
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) //autoincrement
    private int id; //Int
    private String saying; //varchar(255)
    private String author; //varchar(255)
}


//class article { } -> jpa -> create table article()