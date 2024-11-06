package com.my.mybatisTest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardFileDTO {
    private Long id;
    private Long boardid;
    private String originalfilename;
    private String storedfilename;
}
