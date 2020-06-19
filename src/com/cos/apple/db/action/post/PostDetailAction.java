package com.cos.apple.db.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.apple.db.action.Action;
import com.cos.apple.db.dao.PostDao;
import com.cos.apple.db.dto.DetailDto;

public class PostDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) {
			response.sendRedirect("member/loginForm.jsp");
			return;
		}
		//System.out.println(request.getParameter("id"));
		
		int id = Integer.parseInt(request.getParameter("id"));
//		int memberId = Integer.parseInt(request.getParameter("memberId"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
		PostDao postDao = new PostDao();
		DetailDto detailDto = postDao.상세글보기(id);
		
		//int result = postDao.상세글보기(id, memberId, title, content);
		
		request.setAttribute("detailDto", detailDto);
		RequestDispatcher dis = request.getRequestDispatcher("post/detail.jsp");
		dis.forward(request, response);
		//response.sendRedirect("post/detail.jsp");
	}

}
