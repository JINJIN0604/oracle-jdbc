<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- Core JSTL 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD MEMBER</title>
<!--  부트스트랩 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#memberId').focusin(function(){
			$('#idMsg').text('4자이상 입력하세요.');
		});
		$('#memberId').blur(function(){
			if($('#memberId').val().length>=4){
				$('#idMsg').text('');
			}
		});
		$('#memberPw').focusin(function(){
			$('#pwMsg').text('4자이상 입력하세요.');
		});
		$('#memberPw').blur(function(){
			if($('#memberPw').val().length>=4){
				$('#pwMsg').text('');
			}
		});
		$('#submitBtn').click(function(){
			if($('#memberName').val().length==0){
				alert('이름을 입력해주세요.');
				$('#memberName').focus();
				return;
			}
			if($('#memberId').val().length<4){
				alert('아이디를 입력해주세요.');
				$('#memberId').focus();
				return;
			}
			if($('#memberPw').val().length<4){
				alert('비밀번호를 입력해주세요.');
				$('#memberId').focus();
				return;
			}
			if($('#memberPw').val()!=$('#checkPw').val()){
				alert('비밀번호확인이 일치하지 않습니다.')
				return;
			}
			$('#addMember').submit();
		});
	});
</script>
</head>
<body>
<div class="container p-5 my-5 border" style="width:500px">
	<h2 class="text-center"><strong>회원가입</strong></h2>
	<br>
	<form action="${pageContext.request.contextPath}/member/addMember" method="post" id="addMember">
    	<div class="mb-3 mt-3">
      		<input type="text" class="form-control" id="memberId" placeholder="아이디" name="memberId" value="${m.memberId}">
      			<div id="idMsg">
					<c:if test="${idDupResult==false}">
						이미 사용중인 아이디입니다.
					</c:if>
				</div>
    	</div>
    	<div class="mb-3">
     		<input type="password" class="form-control" id="memberPw" placeholder="비밀번호" name="memberPw">
    			<div id="pwMsg"></div>
    	</div>
    	<div class="mb-3">
     		<input type="password" class="form-control" id="checkPw" placeholder="비밀번호 확인" name="checkPw">
    	</div>
    	<div class="mb-3">
     		<input type="text" class="form-control" id="memberName" placeholder="이름" name="memberName" value="${m.memberName}">
    	</div>
    	<div class="mb-3">
    		<button type="submit" class="btn btn-dark form-control" id="submitBtn">Sign up</button>
    	</div>
	</form>
</div>
</body>
</html>