<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD ONE</title>
	<!--  부트스트랩 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- js -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<!--  스타일 적용 -->
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

<!--  board one 시작 -->
<div class="container mt-5">
	<div class="row">   
		<h2 class="text-center"><strong>Board List</strong></h2>
		<p class="text-center"><small>게시글 상세보기</small></p>
		<br> 
		<div class="container mt-3" style="width:700px">         
			<table class="table table-bordered">
				<tr>
					<th scope="col" >번호</th>	
					<td>${b.boardNo}</td>
				</tr>
				<tr>
					<th scope="row" >제목</th>
					<td>${b.boardTitle}</td>
				</tr>
				<tr>
					<th scope="row" >내용</th>
					<td>${b.boardContent}</td>
				</tr>
				<tr>
					<th scope="row" >작성자</th>
					<td>${b.memberId}</td>
				</tr>
				<tr>
					<th scope="row" >작성일</th>
					<td>${b.createdate}</td>
				</tr>
			</table>
		</div>
	</div>
</div>
	
<div class="container mt-3" style="width:700px">     
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
	<!-- 회원과 작성자가 동일할때 수정/삭제 버튼 보여주기 -->
	<c:if test="${loginMember.memberId == b.memberId}"> 
		<a type="button" class="btn btn-dark" href='${pageContext.request.contextPath}/board/modifyBoard?boardNo=${b.boardNo}&memberId=${b.memberId}'>수정</a>
		<a type="button" class="btn btn-dark" href='${pageContext.request.contextPath}/board/removeBoard?boardNo=${b.boardNo}&memberId=${b.memberId}'>삭제</a>
	</c:if>
		<a type="button" class="btn btn-dark" class="nav-link" href="${pageContext.request.contextPath}/board/boardList">목록</a>
	</div>
</div>
</body>
</html>
