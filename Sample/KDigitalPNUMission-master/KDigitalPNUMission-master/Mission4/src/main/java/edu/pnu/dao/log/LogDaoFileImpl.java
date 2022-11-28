package edu.pnu.dao.log;

import java.io.File;
import java.io.FileWriter;

public class LogDaoFileImpl implements LogDao {
	// interface logDao addLog 함수 설정
	@Override
	public void addLog(String method, String sqlstring, boolean success) {
		try {
			File file = new File("log.txt");
			FileWriter fw = new FileWriter(file, true);
			fw.write(method + "," + sqlstring + "," + success + "\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// File File Write 함수 - https://homzzang.com/b/java-51