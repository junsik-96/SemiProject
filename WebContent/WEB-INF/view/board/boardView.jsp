<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="semiproject.board.model.vo.Board,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>


<% Board b = (Board)request.getAttribute("board"); %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Modern Business - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">

</head>

<body>

 

<div class="content">   
	<br>
    <h2 class="tit text-center">대나무 숲</h2>
    <br>
    <div class="container">
      <table class="table table-hover">
      	<thead>
      		<tr>
      			<th class="text-center">번호</th>
      			<th class="text-center">제목</th>
      			<th class="text-center">내용</th>
      			<th class="text-center">작성자</th>
      			<th class="text-center">날짜</th>
      			<th class="text-center">조회수</th>
      		</tr>	
      	</thead>
     
      	<tbody>
      	

      		<%-- <c:forEach var="i" begin="0" end="${fn:length(comm1)-1}" step="1"> --%>
      			<tr onclick="location.href='board/boardDetail'">
      			<td class="text-center">${data.board.bdIdx}</td>
      			<td class="text-center">${data.board.title}</td>
      			<td class="text-center">${data.board.content}</td>
      			<td class="text-center">${data.board.userId}</td>
      			<td class="text-center">${data.board.regDate}</td>
      			<td class="text-center">${data.board.count}</td>
      		</tr>
      <%-- 		</c:forEach> --%>
      		
      		
      		
      	</tbody>
      </table>
      <hr>
      <br>

      <a style="justify-content:flex-end;" href="/board/boardForm" onclick='fn_write()' class="btn btn-primary">글쓰기</a>


  <ul class="pagination" style="justify-content:center;">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>

    </div>
   </div>
<!-- Footer -->
  <footer class="py-5 bg-dark">
  
	<div class = "shy_info">
   (주) 귀울임 사업자 정보    
  <div id = "footerInfo">  
  <br>		 		
	(주) 귀울임 | 서울시 강남구 강남스타일로 123-4<br>
	대표 : 홍길동 | 개인정보보호책임 : 황진이<br>
	사업자 등록번호 : 123-45-6789<br>
	통신판매업신고 : 2021-서울강남-01234호<br>
	전화 : 02-1234-1234<br>
	email : pclass@khaca.com<br>
    </div>
	</div>
    
  </footer>
  

  
   <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


</body>
</html>