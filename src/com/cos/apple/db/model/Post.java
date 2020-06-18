package com.cos.apple.db.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Post {
	private int id;
	private int memberid;
	private String titile;
	private String content;
	private Timestamp creatDate;
}
