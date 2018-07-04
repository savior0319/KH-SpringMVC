package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public MemberDAOImpl() {
	}

	@Override
	public MemberVO selectOneMember(Connection conn, MemberVO mv) {

		MemberVO mvSelect = null;

		String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PW = ?";

		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, mv.getUserId());
			psmt.setString(2, mv.getUserPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				mvSelect = new MemberVO();
				mvSelect.setUserId(rs.getString("USER_ID"));
				mvSelect.setUserPw(rs.getString("USER_PW"));
				mvSelect.setUserName(rs.getString("USER_NAME"));
				mvSelect.setPhone(rs.getString("USER_PHONE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mvSelect;
	}

}
