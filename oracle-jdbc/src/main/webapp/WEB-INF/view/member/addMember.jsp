<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD MEMBER</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="${pageContext.request.contextPath}/member/addMember" method="post">
			<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" id="memberId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw" id="memberPw"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" name="memberPw2" id="memberPw2"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="memberName" Id="memberName">
				</td>
			</tr>
		</table>
		<button type="submit">회원가입</button>
	</form>

</body>
</html>