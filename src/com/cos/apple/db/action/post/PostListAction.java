package com.cos.apple.db.action.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.db.action.Action;
import com.cos.apple.db.dao.PostDao;
import com.cos.apple.db.model.Post;

public class PostListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostDao postDao = new PostDao();
		List<Post> posts = postDao.글목록();
		request.setAttribute("posts", posts);
		
		RequestDispatcher dis = request.getRequestDispatcher("post/list.jsp");
		dis.forward(request, response);
	}

}
