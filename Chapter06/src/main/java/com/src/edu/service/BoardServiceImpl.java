package com.src.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.edu.domain.Board;
import com.src.edu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;

	public List<Board> getBoardList(Board board) {
		return (List<Board>) boardRepo.findAll();
	}

	public void insertBoard(Board board) {
		boardRepo.save(board);
	}

	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}

	public void updateBoard(Board board) {

	}

	public void deleteBoard(Board board) {

	}
	
	

}
