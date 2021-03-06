package com.heaven.mvc.board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heaven.mvc.board.domain.BoardVO;
import com.heaven.mvc.board.service.BoardService;


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
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write() {
	
		return "/board/write";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) return "/board/write";
		
		boardService.write(boardVO);
		return "redirect:/board/list";
		//return "/board/list";
	}

	@RequestMapping(value="/board/edit/{seq}" , method= RequestMethod.GET)
	public String edit(Model model, @PathVariable("seq") int seq) {
		BoardVO boardVO = boardService.read(seq);
		model.addAttribute("boardVO", boardVO);
		return "/board/edit";
	}
	
	@RequestMapping(value="/board/edit/{seq}" , method= RequestMethod.POST)
	public String edit(@Valid BoardVO boardVO, HttpServletRequest request, BindingResult bindingResult,  @PathVariable("seq") int seq, Model model) {
		
		int pwd = Integer.parseInt(request.getParameter("pwd"));

		if(bindingResult.hasErrors()) return "/board/edit";
		else if(boardService.read(seq).getPassword() != pwd) {
			model.addAttribute("msg", "??????????????? ???????????? ????????????.");
			return "/board/edit";
		}
		
		boardVO.setPassword(pwd);
		boardService.edit(boardVO);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/delete/{seq}", method = RequestMethod.GET)
	public String delete(@PathVariable int seq, Model model) {
		model.addAttribute("seq", seq);
		return "/board/delete";
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String delete(int seq, int pwd, Model model) {
		int rowCount;
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(seq);
		boardVO.setPassword(pwd);

		rowCount = boardService.delete(boardVO);

		if (rowCount == 0) {
			model.addAttribute("seq", seq);
			model.addAttribute("msg", "??????????????? ???????????? ????????????.");
			return "/board/delete";
		} else {
			return "redirect:/board/list";
		}
	}
	
}
