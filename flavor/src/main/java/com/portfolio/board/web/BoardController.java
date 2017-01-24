package com.portfolio.board.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.board.domain.BoardVO;
import com.portfolio.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/listPage",method = RequestMethod.GET)
	public String listPage(Model model){
		
		List<BoardVO> list = boardService.listPage();
		model.addAttribute("list", list);
		return"board/listPage";
	}
}
