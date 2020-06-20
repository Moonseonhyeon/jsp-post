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

public class PostDeleteProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int id = Integer.parseInt(request.getParameter("id"));
		
		DetailDto detailDto = new DetailDto();
		detailDto.setId(id);
		
		System.out.println("detailDto.getId() : "+detailDto.getId());
		
		PostDao postDao = new PostDao();		
		int result = postDao.삭제(id);
		System.out.println("result : "+result);
		
			
		
		if(result == 1) {
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("post/detail.jsp");
		}
	}

}
