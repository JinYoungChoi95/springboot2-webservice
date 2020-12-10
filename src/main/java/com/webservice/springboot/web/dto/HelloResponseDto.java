package com.webservice.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//Get Method generate
@Getter
//Constructor generate
@RequiredArgsConstructor
public class HelloResponseDto {

    public final String name;
    public final int amount;
}
