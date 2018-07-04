package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.MemberVO;

public class LoginControllerImpl implements Controller {

	public LoginControllerImpl() {
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 처리");

		// 1. 인코딩 처리
		request.setCharacterEncoding("utf-8");

		// 2. 사용자 입력값 저장
		MemberVO mv = new MemberVO();
		mv.setUserId(request.getParameter("userId"));
		mv.setUserPw(request.getParameter("userPw"));

		// 3. 비즈니스 로직 처리
		MemberVO mvSelect = new MemberServiceImpl().selectOneMember(mv);

		// 4. View 페이지 리턴
		if (mvSelect != null) {
			return "loginSuccess";
		} else {
			return "loginFail";
		}
	}

}
