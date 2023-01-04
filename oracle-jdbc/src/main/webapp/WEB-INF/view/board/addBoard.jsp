<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD BOARD</title>
<!--  부트스트랩 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>
<body>
	<!-- 페이지 상단 시작 -->
	<nav class="navbar navbar-expand-sm bg-light justify-content-center">
		<ul class="navbar-nav">
			<li class="nav-item">
	      		<a class="nav-link" href="${pageContext.request.contextPath}/board/boardList">게시판</a>
	    	</li>
	    	<li class="nav-item">
	      		<a class="nav-link" href="${pageContext.request.contextPath}/member/memberOne">내정보</a>
	    	</li>
	    	<li class="nav-item">
	      		<a class="nav-link" href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	    	</li>
	  	</ul>
	</nav>
	<br>
	<br>
	<!-- 페이지 상단 끝 -->
	<!--  게시글 추가 시작 -->
	<div class="container mt-3">
		<h2 class="text-center"><strong>Add Board</strong></h2>
		<p class="text-center"><small>게시글 추가</small></p>
		<form action="${pageContext.request.contextPath}/board/addBoard" method="post"> 
			<div class="mb-3 mt-3">
				<label for="boardTitle">Title:</label>
				<input class="form-control" id="boardTitle" type="text" name="boardTitle">
			</div>
			<div class="mb-3 mt-3">
				<label for="boardContent">Content:</label>
				<textarea class="form-control" id="boardContent" name="boardContent" rows="5"></textarea>
			</div>
			<div class="mb-3 mt-3">
				<label for="memberId">memberId:</label>
				<input class="form-control" id="memberId" type="text" name="memberId" value="${loginMember.memberId}" readonly="readonly">
			</div>

			<button type="submit" class="btn btn-primary">등록</button>
		</form>
	</div>		
</body>
</html>