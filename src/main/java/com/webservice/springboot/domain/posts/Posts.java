package com.webservice.springboot.domain.posts;

import com.webservice.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//lombok annotation
//get Getter Method
@Getter
//기본 생성자 자동 추가
//==public Posts(){}
@NoArgsConstructor

//JPA annotation
//table과 실제 링크될 class임을 표현
@Entity
public class Posts extends BaseTimeEntity {
    //Primary Key field
    @Id
    //Primary Key 생성 규칙
    //GenerationType.IDENTITY를 지정해주어야 id가 auto increment됨
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //feild column 옵션 설정시 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
