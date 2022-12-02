package com.Mission;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.Mission.domain.Board;
import com.Mission.persistence.BoardRepository;

@SpringBootTest
class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepository;

//	@Test
	public void dataPrepare() {
		Random random = new Random();
		for (int i = 0; i < 200; i++) {

			Board board = new Board();
			board.setTitle("텍스트 제목 " + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(random.nextLong(100));

			boardRepository.save(board);
		}
	}

//	@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepository.findByTitle("테스트 제목 10");
		for (Board board : boardList) {
			System.out.println(board.toString());
		}
	}

//	@Test
	public void findByContentContaining() {
		List<Board> boardList = boardRepository.findByContentContaining("17");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println(board.toString());
		}
	}

//	@Test
	public void findByTitleContainingOrContentContaining() {
		List<Board> boaList = boardRepository.findByTitleContainingOrContentContaining("17", "17");

		System.out.println("검색 결과");
		for (Board board : boaList) {
			System.out.println(board.toString());
		}
	}

//	@Test
	public void testFindByTitleContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepository.findByTitleContainingOrderBySeqDesc("17");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println(board.toString());
		}
	}

//	@Test
	public void testfindByTitleContaining() {
		Pageable paging = PageRequest.of(5, 10);
		List<Board> boardList = boardRepository.findByTitleContaining("제목", paging);

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println(board.toString());
		}
	}

//	@Test
	public void testquery() {
		// List<Board> boardList = boardRepository.findByTitleContaining("1");
		// List<Board> boardList =
		// boardRepository.findByTitleContainingAndCntGreaterThan("1",50L);
		List<Board> boardList = boardRepository.findByCntBetweenOrderBySeqDesc(10L, 50L);
		// List<Board> findByTitleContainingandCntContaining("1",);

		for (Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
	

}
