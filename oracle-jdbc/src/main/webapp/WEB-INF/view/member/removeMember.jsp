<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>REMOVE MEMBER</title>
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

<!--  회원탈퇴 시작 -->
<div class="container mt-5 ">
	<div class="row">   
		<h2 class="text-center"><strong>회원탈퇴</strong></h2>
		<form method="post" action="<%=request.getContextPath()%>/member/removeMember">
			<div class="container p-5 my-5 border" style="width:700px">
				<div class="mb-3 row">
					<label for="staticEmail" class="col-sm-2 col-form-label">아이디</label>
						<div class="col-sm-10">
							<input type="text" readonly class="form-control-plaintext" id="memberId" value="${loginMember.memberId}">
						</div>
	  			</div>
				<div class="mb-3 row">
					<label for="inputPassword" class="col-sm-2 col-form-label">이름</label>
						<div class="col-sm-10">
							<input type="text" readonly class="form-control-plaintext"  id="memberName" value="${loginMember.memberName}">
						</div>
				</div>	
				<div class="mb-3 row">
					<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="memberPw">
						</div>
				</div>	
			</div>
		</form>
	</div>	
	<div class="text-center">
		<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/member/memberOne">취소</a>
		<button type="submit" class="btn btn-dark">삭제</button>
	</div>
</div>		
</body>
</html>
