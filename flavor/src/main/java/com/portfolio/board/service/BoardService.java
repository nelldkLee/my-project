package com.portfolio.board.service;

import java.util.List;

import com.portfolio.board.domain.BoardVO;
import com.portfolio.board.domain.Criteria;

public interface BoardService {
	public List<BoardVO> listPage(Criteria cri);

	public BoardVO readPage(int bno);

	public void modifyPage(BoardVO boardVO);

	public void register(BoardVO boardVO);

	public void removePage(int bno);
	
	public int listTotalCount(); 
}
