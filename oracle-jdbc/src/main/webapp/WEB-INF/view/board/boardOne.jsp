<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD ONE</title>
</head>
<body>
	<h2>게시글 상세보기</h2>
		<table border="1">
		<tr>
			<td>번호</td>
			<td>${b.boardNo}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${b.boardTitle}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${b.boardContent}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${b.memberId}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${b.createdate}</td>
		</tr>
	</table>
	<div>
		<a href='${pageContext.request.contextPath}/board/modifyBoard?boardNo=${b.boardNo}'>수정</a>
		<a href='${pageContext.request.contextPath}/board/removeBoard?boardNo=${b.boardNo}'>삭제</a>
	</div>
</body>
</html>