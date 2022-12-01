package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient_2 {


	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		// EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04Mysql");
		EntityManager em = emf.createEntityManager();

		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			for (int i = 1; i <= 10; i++) {
				Board board = new Board();

				board.setTitle("JPA 제목" + i);
				board.setWriter("관리자" + i);
				board.setContent("JPA 글 등록 잘 되네요." + i);
				board.setCreateDate(new Date());
				board.setCnt(0L);

				em.persist(board);

			}
			
			Board board = em.find(Board.class,1L);
			board.setTitle("검색한 게시글의 제목 수정");		
		

		tx.commit();


		} catch (Exception e) {
			e.printStackTrace();			
			tx.rollback();
			System.out.println("ROLLBACK");
		} finally {
			em.close();
		}

//		test(emf);
		emf.close();
	}
}
