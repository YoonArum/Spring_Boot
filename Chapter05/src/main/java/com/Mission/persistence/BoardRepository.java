package com.Mission.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Mission.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	List<Board> findByTitle(String searchKeyword);
		
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	List<Board> findByTitleContaining(String searchkeyword, Pageable paging);	
	
	List<Board> findByTitleContaining(String searchKeyword);
	
	List<Board> findByTitleContainingAndCntGreaterThan(String title, long cnt);
	
	List<Board> findByCntBetweenOrderBySeqDesc(long cnt,long cnt2);

	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String searchKeyword);
	
	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
			+ "FROM Board b "
			+ "WHERE b.title like %?1% "
			+ "ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	@Query(value ="select seq, title, writer,create_date "
			+ "from board where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board>queryAnnotationTest4(Pageable paging);
}
