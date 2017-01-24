package com.portfolio.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.portfolio.board.domain.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.portfolio.mapper.BoardMapper";
	
	
	@Override
	public List<BoardVO> listPage() {
		System.out.println(session.getConfiguration().getMappedStatementNames());
		return session.selectList(namespace + ".listPage");
				
	}

}
