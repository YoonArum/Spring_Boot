package com.Mission.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO extends JDBConnect {
	// 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.

	public MemberDAO() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
	}

	// 명시한 아이디/패스워드와 일치하는 회원 정보를 반환합니다.
	public MemberVO getMemberDTO(String uid, String upass) {
		MemberVO dto = new MemberVO(); // 회원 정보 DTO 객체 생성
		String query = "SELECT * FROM member WHERE id=? AND pass=?"; // 쿼리문 템플릿
		// 쿼리문 템플릿
		try { // 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setString(1, uid); // 쿼리문의 첫 번째 인파라미터에 값 설정
			psmt.setString(2, upass); // 쿼리문의 두 번째 인파라미터에 값 설정
			rs = psmt.executeQuery(); // 쿼리문 실행
			// 결과 처리
			if (rs.next()) { // 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getDate(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dto);
		return dto; // DTO 객체 반환
	}

	public ArrayList<MemberVO> selectsql() {
		ArrayList<MemberVO> list = new ArrayList<>();
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
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setRegidate(rs.getDate("regidate"));
				list.add(vo);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public MemberVO insertsql(String id, String pass, String name) {
		try {
			String sql = "INSERT INTO member(id,pass,name,regidate) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setDate(4, new Date(System.currentTimeMillis()));
			ps.executeUpdate();
			return getMember(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public MemberVO updatesql(String id, String pass, String name) {
		try {
			String sql = " update member set id = ?,name = ?, name = ? where id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, name);			
			ps.setString(4, id);
			ps.executeUpdate();
			return getMember(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public MemberVO deleatesql(String id) {
		try {
			String sql = "delete from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			MemberVO vo = new MemberVO();
			vo = getMember(id);
			ps.setString(1, id);
			ps.executeUpdate();
			return vo;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public MemberVO getMember(String id) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(String.format("select * from member where id='%s'", id));

			rs.next();
			MemberVO m = new MemberVO();
			m.setId(rs.getString("id"));
			m.setName(rs.getString("name"));
			m.setPass(rs.getString("pass"));
			m.setRegidate(rs.getDate("regidate"));
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public MemberVO postMember(MemberVO m) {
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("insert into member (id, name, pass, regidate) values (?, ?, ?,?)");
			pst.setString(1, m.getId());
			pst.setString(2, m.getName());
			pst.setString(3, m.getPass());
			pst.setDate(4, new Date(System.currentTimeMillis()));
			if (pst.executeUpdate() == 1)
				return getMember(m.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
