<%@page import="com.cos.apple.db.DBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//DB연결 테스트 - 해당 파일 실행
		DBConn.getConnection();
	%>
</body>
</html>