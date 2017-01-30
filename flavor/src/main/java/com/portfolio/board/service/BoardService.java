package com.portfolio.board.service;

import java.util.List;

import com.portfolio.board.domain.BoardVO;
import com.portfolio.board.domain.SearchCriteria;

public interface BoardService {
	public List<BoardVO> listPage(SearchCriteria cri);

	public BoardVO readPage(int bno);

	public void modifyPage(BoardVO boardVO);

	public void register(BoardVO boardVO);

	public void removePage(int bno);
	
	public int listTotalCount(SearchCriteria cri); 
}
