package org.kh.member.model.dao;

import java.sql.Connection;

import org.kh.member.model.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectOneMember(Connection conn, MemberVO mv);

}
