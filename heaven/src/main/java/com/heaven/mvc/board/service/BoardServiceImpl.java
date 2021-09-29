package com.heaven.mvc.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heaven.mvc.board.domain.BoardVO;
import com.heaven.mvc.board.dao.BoardDAO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Service
public class BoardServiceImpl implements BoardService{

	@Resource
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return boardDAO.list();
	}

	@Override
	public BoardVO read(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.select(seq);
	}

	@Override
	public void write(BoardVO boardVO) {
		boardDAO.insert(boardVO);
	}

	@Override
	public void edit(BoardVO boardVO) {
		boardDAO.update(boardVO);
	}

	@Override
	public int delete(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardDAO.delete(boardVO);
	}

}
