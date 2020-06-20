<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록 페이지</title>
<link href="/apple/static/css/style.css" rel="stylesheet">
</head>
<body>
	<header>
		<h1>게시글 상세 페이지</h1>
	</header>
	<hr />
	<%@include file="../include/nav.jsp" %>
	<section>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>

		<tr>
			<td>${detailDto.id}</td>
			<td>${detailDto.memberId}</td>
			<td>${detailDto.title}</td>
			<td>${detailDto.content}</td>
			<c:if test="${sessionScope.principal.id == detailDto.memberId}">
			<td><a href="/apple/post?cmd=updateForm&id=${detailDto.id}">수정</a></td>
			<td><a href="/apple/post?cmd=deleteProc&id=${detailDto.id}">삭제</a></td>
			</c:if>
		</tr>
	</table>
</section>
	<footer>
		<p>Created By Apple.</p>
		<p>부산 진구 중앙대로 708</p>
	</footer>
</body>
</html>