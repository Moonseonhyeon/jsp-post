package com.cos.apple.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.jstl.sql.Result;

import com.cos.apple.db.DBConn;
import com.cos.apple.db.model.Member;

public class PostDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

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
