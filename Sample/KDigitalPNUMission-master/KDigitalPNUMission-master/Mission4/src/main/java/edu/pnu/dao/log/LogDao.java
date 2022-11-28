package edu.pnu.dao.log;
// interface logdao
public interface LogDao {
	// addlog 함수 지정
	void addLog(String method, String sqlstring, boolean success);

}