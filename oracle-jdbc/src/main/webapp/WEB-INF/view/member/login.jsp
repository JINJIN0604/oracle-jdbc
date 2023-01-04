<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
	<!--  부트스트랩 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- js -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>	
	<script>
		$(document).ready(function(){
			$('#submitBtn').click(function(){
				if($('#memberId').val().length==0){
					alert('아이디를 입력해주세요.');
					$('#memberId').focus();
					return;
				}
				if($('#memberPw').val().length==0){
					alert('비밀번호를 입력해주세요.');
					$('#memberPw').focus();
					return;
				}
				$('#login').submit();
			});
		})
	</script>
	<!--  스타일 적용 -->
	<style>
 	.fakeimg {
    height: 200px;
    background: #aaa;
  	}
	</style>
</head>
<body>
<div class="container p-5 my-5 border" style="width:500px">
	<h2 class="text-center"><strong>Login</strong></h2>
	<br>
	<form action="${pageContext.request.contextPath}/member/login" method="post" id="login">
    	<div class="mb-3 mt-3">
      		<input type="text" class="form-control" id="memberId" placeholder="아이디를 입력하세요" name="memberId">
    	</div>
    	<div class="mb-3">
     		<input type="password" class="form-control" id="memberPw" placeholder="비밀번호를 입력하세요" name="memberPw">
    	</div>
    	<div class="mb-3">
    		<button type="submit" class="btn btn-dark form-control" id="submitBtn">Sign in</button>
    	</div>
    	<div class="text-center">
    	회원이 아니신가요?&nbsp&nbsp<a href="${pageContext.request.contextPath}/member/addMember" style="text-decoration:none" class="text-black"><strong>회원가입 하기</strong></a>
		</div>
	</form>
</div>
</body>
</html>
