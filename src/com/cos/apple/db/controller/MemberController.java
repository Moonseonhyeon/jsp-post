package com.cos.apple.db.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.db.action.Action;
import com.cos.apple.db.action.member.MemberJoinFormAction;
import com.cos.apple.db.action.member.MemberJoinProcAction;
import com.cos.apple.db.action.member.MemberLoginFormAction;
import com.cos.apple.db.action.member.MemberLoginProcAction;
import com.cos.apple.db.action.post.PostListAction;

//http://localhost:8000/apple/member
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. request utf-8 세팅 = web.xml 필터 등록함.
		// 2. response utf-8 세팅
		response.setCharacterEncoding("utf-8"); // 내가 상대한테 응답 시 바디에 담긴 거 인코딩.
		response.setContentType("text/html; charset=utf-8"); // text/html은 default타입이에요.

		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		action.execute(request, response);
	}

	private Action router(String cmd) {
		if (cmd.equals("joinForm")) {
			return new MemberJoinFormAction();
		} else if (cmd.equals("joinProc")) {
			return new MemberJoinProcAction();
		} else if (cmd.equals("loginForm")) {
			return new MemberLoginFormAction();
		} else if (cmd.equals("loginProc")) {
			return new MemberLoginProcAction();
		} 
		return null;
	}
}
