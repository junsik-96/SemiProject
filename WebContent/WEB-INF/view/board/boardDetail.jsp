<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>

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

  
  <div id="wrap" class="container">
    <br><br>
    <div id="board">
    <h1>대나무 숲</h1>
        <table id="detailBoard" width="500"border="3"  bordercolor="lightgray" class="table table-hover">
        
            <tr>
                <td id="title">작성자</td>
                <td>${data.board.userId}</td>
            </tr>
            <tr>
                <td id="title">제목</td>
                <td>${data.board.title}</td>
            </tr>
            <tr>
                <td id="title">
                    작성일
                </td>
                <td>
                    ${data.board.regDate}
                </td>        
            </tr>
            <tr>
            
            <tr>
                <td id="title">
                  분 야 
                </td>
                <td>
                    ${data.board.field}
                </td>        
            </tr>
            <tr>
                <td id="title">
                    내 용
                </td>
                <td>
                    ${board.board.content}

                </td>        
            </tr>
           
    
            <tr align="center" valign="middle">
                <td colspan="5">
                    <input type="button" value="수정" >
                    <input type="button" value="삭제" >
                    <input type="button" value=답글 >    
                    <input type="button" value="목록" 
                        onclick="javascript:location.href='/board'">            

                </td>
            </tr>
        </table>
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