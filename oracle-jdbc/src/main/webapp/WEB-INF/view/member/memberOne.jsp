<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER ONE</title>
</head>
<body>
	<h2></h2>
	${loginMember.memberId} 님의 페이지
	<div>
	<a href="${pageContext.request.contextPath}/member/modifyMember">회원정보수정</a>
	<a href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a>
	</div>
</body>
</html>