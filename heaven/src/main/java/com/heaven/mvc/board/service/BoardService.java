package com.heaven.mvc.board.service;

import java.util.List;
import com.heaven.mvc.board.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> list();
	public BoardVO read(int seq);
}