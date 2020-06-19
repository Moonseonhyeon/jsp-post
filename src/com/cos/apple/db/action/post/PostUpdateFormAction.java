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

public class PostUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) {
			response.sendRedirect("member/loginForm.jsp");
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("PostUpdateFormAction id : "+ id);
		
		
		PostDao postDao = new PostDao();
		DetailDto detailDto = postDao.수정(id);
		
		request.setAttribute("detailDto", detailDto);
		RequestDispatcher dis = request.getRequestDispatcher("post/updateForm.jsp");
		dis.forward(request, response);
		
		//response.sendRedirect("post/updateForm.jsp");
	}

}
