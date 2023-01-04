<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER ONE</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<style>
 	.fakeimg {
    height: 200px;
    background: #aaa;
  	}
	</style>
</head>
<body>
<!-- 페이지 상단 시작-->
<div class="container">
	<nav class="navbar navbar-expand-sm bg-light justify-content-center">
		<ul class="navbar-nav">
			<li class="nav-item">
	      		<a class="nav-link active" href="${pageContext.request.contextPath}/home">홈</a>
	    	</li>
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
</div>
<!-- 페이지 상단 끝 -->

<!-- 멤버페이지 시작 -->
<div class="container mt-5">
	<div class="row">   
		<h2 class="text-center"><strong>내정보</strong></h2>
		<div class="container p-5 my-5 border text-center" style="width:500px">
			<h5><strong>${loginMember.memberId}</strong>님의 마이페이지</h5>
			<br><br>
			<a type="button" class="btn btn-outline-dark"  href="${pageContext.request.contextPath}/member/modifyMember">회원정보수정</a>
			<a type="button" class="btn btn-outline-dark" href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a>
		</div>
   	</div>
</div>
</body>
</html>