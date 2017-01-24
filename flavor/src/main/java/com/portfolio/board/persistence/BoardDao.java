package com.portfolio.board.persistence;

import java.util.List;

import com.portfolio.board.domain.BoardVO;

public interface BoardDao {
	public List<BoardVO> listPage();
}
