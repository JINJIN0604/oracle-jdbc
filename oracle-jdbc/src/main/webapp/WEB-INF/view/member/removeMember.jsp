<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>REMOVE MEMBER</title>
</head>
<body>
	<h2>회원탈퇴</h2>
	<form method="post" action="<%=request.getContextPath()%>/member/removeMember">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" value="${loginMember.memberId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="memberName" value="${loginMember.memberName}" readonly="readonly"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit">삭제</button>
	</form>
</body>
</html>
