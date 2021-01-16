package com.webservice.springboot.domain.posts;

//JpaRepository > DB Layer 접근자
//Interface로 생성됨
//@Repositroy를 생성할 필요는 없지만 기본 Entity class와 같은 위치에 있어야함
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Entity, id types
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}