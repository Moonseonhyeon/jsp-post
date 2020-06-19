<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정 목록 페이지</title>
<link href="/apple/static/css/style.css" rel="stylesheet"> 
</head>
<body>
	<header>
		<h1>글수정 페이지</h1>		
	</header>
	<hr />
	<%@include file="../include/nav.jsp" %>
	<section>
	<form action="/apple/post?cmd=updateProc" method="post">
	<input type="hidden" value="${detailDto.id}" name="id" />
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input value="${detailDto.title}" type="text" name="title" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="22" name="content">${detailDto.content}</textarea></td>
		</tr>
	</table>
	<button>글수정 완료</button>
	</form>
</section>
	<footer>
		<p>Created By Apple.</p>
		<p>부산 진구 중앙대로 708</p>
	</footer>
</body>
</html>