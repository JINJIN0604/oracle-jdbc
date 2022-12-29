<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFY BOARD</title>
</head>
	<h2>게시글 수정</h2>
	<form action="${pageContext.request.contextPath}/board/modifyBoard" method="post">
		<table>
			<tr>
				<td>번호</td>
				<td>
					<input type="number" name="boardNo" value="${b.boardNo}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="boardTitle" value="${b.boardTitle}">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="boardContent" rows="5" cols="50">${b.boardContent}</textarea>
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="memberId" value="${b.memberId}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit">수정</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>