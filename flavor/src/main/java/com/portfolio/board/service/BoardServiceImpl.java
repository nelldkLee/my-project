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

}
