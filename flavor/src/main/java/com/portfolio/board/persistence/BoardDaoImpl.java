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
		//System.out.println(session.getConfiguration().getMappedStatementNames());
		return session.selectList(namespace + ".listPage");
				
	}


	@Override
	public BoardVO readPage(int bno) {

		return session.selectOne(namespace + ".readPage",bno);

	}

	@Override
	public void modify(BoardVO boardVO) {
		session.update(namespace + ".modifyPage",boardVO);
	}


	@Override
	public void register(BoardVO boardVO) {
		session.insert(namespace + ".register", boardVO);
		
		boardVO.setBno(session.selectOne(namespace + ".searchBno", boardVO));
	}
}
