<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- js -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#rowPerPage').change(function() {
				$('#pageForm').submit();
				alert('change');
			})
		});
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

<!--  게시판 리스트 시작 -->
<div class="container mt-5" style="width:900px">
   	<div class="form-group">
	<h2 class="text-center"><strong>게시판</strong></h2>
		<form class="form-group col-sm-2" id="pageForm" method="get" action="${pageContext.request.contextPath}/board/boardList">
			<select name="rowPerPage" id="rowPerPage">
				<c:if test="${rowPerPage ==10}">
					<option value="10" selected="selected">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
				</c:if>
				<c:if test="${rowPerPage ==20}">
					<option value="10">10</option>
					<option value="20" selected="selected">20</option>
					<option value="30">30</option>
				</c:if>
				<c:if test="${rowPerPage ==30}">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30" selected="selected">30</option>
				</c:if>
			</select>			
		</form>
	</div>		
	<div class="container mt-5 text-center"> 
		<div class="row">     
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${boardList}">
						<tr>
							<td>${b.boardNo}</td>
							<td><a href="${pageContext.request.contextPath}/board/boardOne?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
							<td>${b.createdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="form-group">
		<a type="button" class="btn btn-dark" href="${pageContext.request.contextPath}/board/addBoard">글추가</a>	
		<!-- 검색창 -->
		<form style="float:right;" method="get" action="${pageContext.request.contextPath}/board/boardList ">
			<c:if test="${search != null}">
				<input class="box" type="text" name="search" value="${search}">
			</c:if>
			<c:if test="${search == null}">
				<input class="box" type="text" name="search" placeholder="제목을 입력하세요.">
			</c:if>
			<button class="btn btn-dark" type="submit">검색</button>
		</form>
	</div>


		<!-- 페이징 코드 -->
		<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${serach == null || empty search}">
				<li class="page-item"><a class="page-link text-dark" href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=1">처음</a></li>
				<c:if test="${currentPage > 1}">
					<li class="page-item"><a class="page-link text-dark" href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}">이전</a></li>
				</c:if>
				<li class="page-item"><span class="page-link text-dark">${currentPage}</span></li>
				<c:if test="${currentPage < lastPage}">
					<li class="page-item"><a class="page-link text-dark" href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}">다음</a></li>
				</c:if>
				<li class="page-item"><a class="page-link text-dark" href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${lastPage}">마지막</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link text-dark" href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=1&search=${search}">처음</a>
				<c:if test="${currentPage > 1}">
					<li class="page-item"><a class="page-link text-sdark" href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}&search=${search}">이전</a>
				</c:if>
				<li class="page-item"><span class="page-link text-dark">${currentPage}</span></li>
				<c:if test="${currentPage < lastPage}">
					<li class="page-item"><a class="page-link text-dark" href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}&search=${search}">다음</a>
				</c:if>
				<li class="page-item"><a class="page-link text-dark" href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${lastPage}&search=${search}">마지막</a>
			</c:otherwise>
		</c:choose>	
		</ul>
		
</div>




</body>
</html>








