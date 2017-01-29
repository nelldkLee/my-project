package com.portfolio.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portfolio.board.domain.BoardVO;
import com.portfolio.board.domain.Criteria;
import com.portfolio.board.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> listPage(Criteria cri) {
			
		return boardDao.listPage(cri);
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

	@Override
	public void removePage(int bno) {
		boardDao.removePage(bno);
	}

	@Override
	public int listTotalCount() {
		return boardDao.listTotalCount();
	}

}
