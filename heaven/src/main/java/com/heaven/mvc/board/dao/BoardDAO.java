package com.heaven.mvc.board.dao;

import java.util.List;

import com.heaven.mvc.board.domain.BoardVO;

public interface BoardDAO {
	public abstract List<BoardVO> list();
	public abstract BoardVO select(int seq);
	public abstract int deleteAll();
	public abstract int update(BoardVO boardVO);
	public abstract void insert(BoardVO boardVO);
	public abstract int delete(BoardVO boardVO);
	public abstract int updateReadCount(int seq);
}
