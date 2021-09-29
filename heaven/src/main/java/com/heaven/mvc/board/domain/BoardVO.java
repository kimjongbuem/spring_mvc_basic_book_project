package com.heaven.mvc.board.domain;


import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Alias("boardVO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private int password;
	private int cnt;
	private String content;
	private Timestamp regDate;
}
