package org.kh.member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	public MemberServiceImpl() {
	}

	@Override
	public MemberVO selectOneMember(MemberVO mv) {
		Connection conn = getConnection();
		MemberVO mvSelecct = new MemberDAOImpl().selectOneMember(conn, mv);
		return mvSelecct;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SPRING", "SPRING");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
