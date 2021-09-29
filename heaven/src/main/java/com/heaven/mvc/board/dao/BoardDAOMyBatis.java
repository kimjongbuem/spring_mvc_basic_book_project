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

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("deleteAll");
	}

	@Override
	public int update(BoardVO boardVO) {
		return sqlSessionTemplate.update("update", boardVO);
	}

	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("insert", boardVO);
	}

	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("updateCount", seq);
	}

	@Override
	public int delete(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("delete", boardVO);
	}


}
