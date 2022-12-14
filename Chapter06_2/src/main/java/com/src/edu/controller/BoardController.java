package com.src.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.src.edu.domain.Board;
import com.src.edu.domain.Member;
import com.src.edu.service.BoardService;


@SessionAttributes("member")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}

	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		List<Board> boardList = boardService.getBoardList(board);

		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}

	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		return "insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.updateBoard(board);
		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}

	// spring.mvc.view.suffix=.jsp -> .jsp ??? ???????????? ?????????
//	@GetMapping("/test1")
//	public String test1() {
//		return "test1";
//	}

	// @ResponseBody ???????????? ?????? ?????? ????????? ??????
//	@GetMapping("/test1")
//	public @ResponseBody String test1() {
//		return "test1";
//	}

	// #spring.mvc.view.prefix=/WEB-INF/board/ -> ??? ????????????
//	@GetMapping("/test2")
//	public String test2() {
//		return "/WEB-INF/test2"; // ??????????????? ?????? ?????? ??????
//	}

	// #spring.mvc.view.prefix=/WEB-INF/board/ -> ??? ????????????

//	@GetMapping("/test3")// ????????? ?????? ?????? ?????? return ??????
//	public void test3() {
//	}

//	@RequestMapping("/getBoardList") // ResquestMapping = put,get,post ?????? ??????
//	public String getBoardList(Model model) {
//		List<Board> boardList = new ArrayList<Board>();
//
//		for (int i = 1; i <= 10; i++) {
//			Board board = new Board();
//			board.setSeq(new Long(i));
//			board.setTitle("????????? ???????????? ?????????");
//			board.setWriter("?????????");
//			board.setContent("????????? ???????????? ????????? ?????????....");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//		}
//		model.addAttribute("boardList", boardList);
//		return "getBoardList";
//	}

//	@RequestMapping("/getBoardList1") // ResquestMapping = put,get,post ?????? ??????
//	public ModelAndView getBoardList1() {
//
//		ModelAndView mv = new ModelAndView();
//
//		List<Board> boardList = new ArrayList<Board>();
//
//		for (int i = 1; i <= 10; i++) {
//			Board board = new Board();
//			board.setSeq(new Long(i));
//			board.setTitle("????????? ???????????? ?????????");
//			board.setWriter("?????????");
//			board.setContent("????????? ???????????? ????????? ?????????....");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//		}
//		mv.addObject("boardList", boardList);
//		mv.setViewName("getBoardList");
//		return mv;
//	}

}
