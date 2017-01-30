package com.portfolio.board.persistence;

import java.util.List;

import com.portfolio.board.domain.BoardVO;
import com.portfolio.board.domain.SearchCriteria;

public interface BoardDao {
	public List<BoardVO> listPage(SearchCriteria cri);

	public BoardVO readPage(int bno);

	public void modify(BoardVO boardVO);

	public void register(BoardVO boardVO);

	public void removePage(int bno);

	public int listTotalCount();
}
