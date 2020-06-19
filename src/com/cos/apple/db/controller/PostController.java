package com.cos.apple.db.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.db.action.Action;
import com.cos.apple.db.action.post.PostDetailAction;
import com.cos.apple.db.action.post.PostListAction;
import com.cos.apple.db.action.post.PostSaveFormAction;
import com.cos.apple.db.action.post.PostSaveProcAction;

//http://localhost:8000/apple/post
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostController() {
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
		if (cmd.equals("list")) {
			return new PostListAction();
		}else if (cmd.equals("saveForm")) {
			return new PostSaveFormAction();
		}else if (cmd.equals("saveProc")) {
			return new PostSaveProcAction();
		}else if (cmd.equals("detail")) {
			return new PostDetailAction();
		}
		return null;
	}
}
