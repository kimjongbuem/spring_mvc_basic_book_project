package com.heaven.mvc.board.domain;


import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

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
	
	@Length(min=2, max=5, message="제목은 2자 이상 5자 미만~!")
	private String title;
	@NotEmpty(message="이름을 입력하세요.")
	private String writer;
	private int password;
	private int cnt;
	@NotEmpty(message="내용을 입력하세요.")
	private String content;
	private Timestamp regDate;
}
