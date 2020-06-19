package com.cos.apple.db.model;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	private Timestamp createDate;
	
}
