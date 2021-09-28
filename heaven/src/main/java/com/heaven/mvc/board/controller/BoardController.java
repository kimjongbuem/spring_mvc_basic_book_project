package com.heaven.mvc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heaven.mvc.board.service.BoardServiceImpl;


@Controller
public class BoardController {
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping(value = "/board/list")
	@ResponseBody
	public String list() {
		System.out.println("list!");
		return boardService.list().toString();
	}
}
