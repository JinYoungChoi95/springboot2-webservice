package com.webservice.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//springboot test와 JUnit 사이의 연결자
@RunWith(SpringRunner.class)
//Web(Spring MVC)에 집중할 수 있는 annotation
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    //Spring이 관리하는 Bean 주입받음
    @Autowired
    //웹 API test에 사용
    //Spring MVC test 시작점
    private MockMvc mvc;

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        //MockMvc를 통해 /hello 주소로 HTTP GET요청
        mvc.perform(get("/hello"))
                //mvc.perform 결과 검증
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
