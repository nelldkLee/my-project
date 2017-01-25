package com.portfolio.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portfolio.board.domain.BoardVO;
import com.portfolio.board.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> listPage() {
			
		return boardDao.listPage();
	}

	@Override
	public BoardVO readPage(int bno) {
		
		return boardDao.readPage(bno);
	}

	@Override
	public void modifyPage(BoardVO boardVO) {
		boardDao.modify(boardVO);
	}

	@Override
	public void register(BoardVO boardVO) {
		boardDao.register(boardVO);
	}

}
