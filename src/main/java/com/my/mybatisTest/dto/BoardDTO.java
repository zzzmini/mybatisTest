package com.my.mybatisTest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
    private Long id;
    private String board_writer;
    private String board_pass;
    private String board_title;
    private String board_contents;
    private int board_hits;
    private String create_date;
}
