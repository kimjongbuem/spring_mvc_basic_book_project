package com.heaven.mvc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heaven.mvc.board.service.BoardService;
import com.heaven.mvc.board.service.BoardServiceImpl;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board/list")
	public String list(Model model) {
		
		model.addAttribute("boardList", boardService.list());
		
		return "/board/list";
	}
	
	@RequestMapping(value ="/board/read/{seq}")
	public String read(Model model, @PathVariable("seq") int seq) {
		
		model.addAttribute("boardVO", boardService.read(seq));
		
		return "/board/read";
		
	}
	
	
}
