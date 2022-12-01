package com.Mission;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Mission.domain.Board;
import com.Mission.persistence.BoardRepository;

@SpringBootTest
class Chapter05ApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

//	@Test
//	void contextLoads() {
//		
//		boardRepository.save(new Board(
//				10L,
//				"title",
//				"Writer",
//				"Content",
//				new Date(),
//				0L
//			));
//	}


//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//		board.setTitle("첫 번째 게시글");
//		board.setWriter("테스터");
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRepository.save(board);
//	}

//	@Test
//	public void testGetBoard() {
//		Board board = boardRepository.findById(1L).get();
//		System.out.println(board.toString());
//	}

//	@Test
//	public void testUpdateBoard() {
//		System.out.println("=== 1번 게시글 조회 ===");
//		Board board = boardRepository.findById(1L).get();
//		
//		
//		System.out.println("=== 1번 게시글 수정 ===");
//		board.setTitle("제목을 수정했습니다.");
//		boardRepository.save(board);		
//	}
	
//	@Test
//	public void testDeleteBoard() {		
//		boardRepository.deleteById(1L);
//	}
	
}
