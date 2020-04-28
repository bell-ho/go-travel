package org.zerock.persistence;


import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void restConnection() {
		try(Connection conn = 
				DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE",
				"c##trip","trip")){
			log.info("�׽�Ʈ �Դϴ�."+conn);
		}catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
}