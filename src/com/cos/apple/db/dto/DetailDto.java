package com.cos.apple.db.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DetailDto {
	private int id;
	private int memberId;
	private String title;
	private String content;
	private Timestamp createDate;

}
