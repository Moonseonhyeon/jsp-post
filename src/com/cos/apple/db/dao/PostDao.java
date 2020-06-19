package com.cos.apple.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;

import com.cos.apple.db.DBConn;
import com.cos.apple.db.model.Member;
import com.cos.apple.db.model.Post;

public class PostDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<Post> 글목록() {
		try {
			//String sql = "SELECT * FROM post WHERE id >'0'"; 인덱스로 
			String sql = "SELECT * FROM post ORDER BY id DESC";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<Post> posts = new ArrayList<>();
			while(rs.next()) {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setMemberId(rs.getInt("memberId"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setCreateDate(rs.getTimestamp("createDate"));
				posts.add(post);
			}
			return posts;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int 글쓰기(int memerId, String title, String content) {
		try {
			String sql = "INSERT INTO post VALUES(post_seq.nextval, ?, ?, ?, sysdate)";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memerId);
			pstmt.setString(2, title);
			pstmt.setString(3, content);

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
