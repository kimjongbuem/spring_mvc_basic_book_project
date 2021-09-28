package com.heaven.mvc.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heaven.mvc.board.domain.BoardVO;

@Repository
public class BoardDAOMyBatis implements BoardDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public BoardVO select(int seq) {
		
		return (BoardVO) sqlSessionTemplate.selectOne("select", seq);
		
	}

}
