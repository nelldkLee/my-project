package com.portfolio.board.service;

import java.util.List;

import com.portfolio.board.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> listPage();

	public BoardVO readPage(int bno);

	public void modifyPage(BoardVO boardVO);

	public void register(BoardVO boardVO);
}
