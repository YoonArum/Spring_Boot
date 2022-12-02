package com.Mission;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Mission.domain.Board;
import com.Mission.persistence.BoardRepository;

@SpringBootTest
class QueryAnnotationTest {

	@Autowired
	private BoardRepository boardRepository;

//	@Test
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepository.queryAnnotationTest1("텍스트 제목 10");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println(board.toString());
		}
	}  

//	@Test
	public void testQueryAnnotationTest2() {
		List<Object[]> boardList = boardRepository.queryAnnotationTest2("텍스트 제목 10");

		System.out.println("검색 결과");
		for (Object[] row : boardList) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	@Test
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepository.queryAnnotationTest3("텍스트 제목 10");
		
		System.out.println("검색 결과");
		for(Object[] row :boardList) {
			System.out.println(Arrays.toString(row));
		}
	}
	
}
