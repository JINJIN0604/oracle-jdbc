<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<h2>홈페이지</h2>
	${loginMember.memberId} 님 , 반갑습니다!
	<div>
	<a href="${pageContext.request.contextPath}/member/memberOne">회원정보</a>
	<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	<a href="${pageContext.request.contextPath}/board/boardList">게시판</a>
	</div>
</body>
</html>