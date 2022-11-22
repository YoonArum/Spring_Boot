package com.Mission.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDAO extends JDBConnect {
	// 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.
	public MemberDAO() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
	}

	// 명시한 아이디/패스워드와 일치하는 회원 정보를 반환합니다.
	public MemberVO getMemberDTO(String uid, String upass) {
		MemberVO dto = new MemberVO(); // 회원 정보 DTO 객체 생성
		String query = "SELECT * FROM member WHERE id=? AND pass=?";  // 쿼리문 템플릿
		// 쿼리문 템플릿
		try { // 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
            psmt.setString(1, uid);    // 쿼리문의 첫 번째 인파라미터에 값 설정
            psmt.setString(2, upass);  // 쿼리문의 두 번째 인파라미터에 값 설정
			rs = psmt.executeQuery(); // 쿼리문 실행
			// 결과 처리
			if (rs.next()) { // 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto; // DTO 객체 반환
	}

	public void selectsql() {
		String query = "SELECT * FROM member"; /* SQL 문 */
		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(" Membber Select ");
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void insertsql(String id,String pass,String name,String regidate) {
		try {			
		String sql= "INSERT INTO member(id,pass,name,regidate) VALUES(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "id");
		ps.setString(2, "pass");
		ps.setString(3, "name");
		ps.setString(4, "010-000-0000");
		ps.executeUpdate();
		System.out.println("insert");		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	public void deleatesql() {
		try {			
		String sql= "delete from member where 학과번호 = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "20");
		ps.executeUpdate();
		System.out.println("delete");		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	public void updatesql() {
		try {			
		String sql= "update member set id = ? where 학과번호 = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "11");
		ps.setString(2, "11");
		ps.executeUpdate();
		System.out.println("delete");		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
}
