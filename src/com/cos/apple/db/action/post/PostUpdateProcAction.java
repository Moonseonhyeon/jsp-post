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

public class PostUpdateProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) {
			response.sendRedirect("member/loginForm.jsp");
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("PostSaveProcAction title : "+title);
		
		DetailDto detailDto = new DetailDto();
		detailDto.setId(id);
		detailDto.setTitle(title);
		detailDto.setContent(content);
		
		System.out.println("detailDto.getContent() : "+detailDto.getContent());
		
		PostDao postDao = new PostDao();		
		int result = postDao.글수정(detailDto);
		System.out.println("result : "+result);
		
			
		
		if(result == 1) {
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("post/saveForm.jsp");
		}
	}

}
