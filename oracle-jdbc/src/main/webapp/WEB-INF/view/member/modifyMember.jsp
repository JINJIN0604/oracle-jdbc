<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFY MEMBER</title>
</head>
<body>
	<h2>내정보 수정</h2>
	<form method="post" action="${pageContext.request.contextPath}/member/modifyMember">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" value="${loginMember.memberId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="memberName" value="${loginMember.memberName}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>
