<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>글입력</h2>
		<form action="${pageContext.request.contextPath}/board/addBoard" method="post"> 
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="boardTitle"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" cols="50" name="boardContent"></textarea></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" value="${loginMember.memberId}" name="memberId" readonly="readonly"> </td>
				</tr>
				<tr>
					<td colspan="2">
				  		<button type="submit">등록</button>	
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>