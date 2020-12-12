package com.webservice.springboot.web.domain.posts;

import com.webservice.springboot.domain.posts.Posts;
import com.webservice.springboot.domain.posts.PostsRepository;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //junit에서 단위 테스트가 끝날때마다 수행되는 method
    //배포 전 전체 테스트를 진행할 때 테스트간의 데이터 침범을 막기위한 용도
    //테스트용 데이터베이스인 H2에 데이터가 남아 다음 테스트에서 에러가 날 수도 있음
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void textsave_load(){
        //given
        String title = "테스트 게시물";
        String content = "테스트 본문";

        //Posts table에 insert, update 쿼리 실행
        //Id가 있으면 update 없으면 insert
        postsRepository.save(Posts.builder()
                            .title(title)
                            .content(content)
                            .author("jinyoungchoi95@gmail.com")
                            .build());

        //when
        //Posts table에 모든 데이터 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
