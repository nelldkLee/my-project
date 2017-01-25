package com.portfolio.board.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "board/listPage";
	}
	
	@RequestMapping(value="/readPage",method = RequestMethod.GET)
	public String readPage(Model model, @RequestParam("bno") int bno){
		
		model.addAttribute(boardService.readPage(bno));
		
		return "board/readPage";
	}
	
	@RequestMapping(value="/modifyPage",method = RequestMethod.GET)
	public String modifyGetPage(Model model,@RequestParam("bno") int bno){
		
		model.addAttribute(boardService.readPage(bno));
		return "board/modifyPage";
		
	}
	
	@RequestMapping(value="/modifyPage", method = RequestMethod.POST)
	public String modifyPostPage(BoardVO boardVO,RedirectAttributes rttr){
		boardService.modifyPage(boardVO);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/listPage";
	}
	
}