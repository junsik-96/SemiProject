
<!-- 상담사 // 상담 내역 페이지 입니다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">
  <style type="text/css">
  		#search-option {clear:both;}
    
    	#search-option > div {
       		margin:0 auto; 
        	margin-top: 30px; 
        	width:auto; 
        	height:100px;

		}
		
		#li-search {
			list-style:none;
        	text-align:center;
        	padding:0;
        	margin:0;

		}
		
		#div-Page {
			max-width: 30%;
   		 	display: flex;
    		justify-content: space-around;
    		margin: 30px;
    		margin-left: 36%;		
		
		}
  
  
  
  
  </style>

</head>
<body>

	
 
    <!-- Page Content -->
 <!-- Page Content -->
  <div class="container">

    <!-- 페이지 제목 -->
    <h1 class="mt-4 mb-3">상담사
      <small>상담내역</small>
    </h1>
    
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index">Home</a>
      </li>
      <li class="breadcrumb-item active"><a href="/shy/myPageMain">마이페이지</a></li>
    </ol>
    
    <!-- 담당맡은 상담 리스트들 -->
    <div class="row">
    	
    	<c:forEach var="cons-reviews" items="${requestScope.counsList}" varStatus="status">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h4 class="card-header"> ${counsList.counsUserId} </h4>
          <div class="card-body">
            <p class="card-text"> ${counsList.counsReview}</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">더 보기</a>
          </div>
        </div>
      </div>
      </c:forEach>
      
    </div>
    
    <ul class="pagination" style="justify-content:center;">
    	<li class="page-item"><a class="page-link" href="#">이전</a></li>
    	<li class="page-item"><a class="page-link" href="#">1</a></li>
    	<li class="page-item"><a class="page-link" href="#">2</a></li>
    	<li class="page-item"><a class="page-link" href="#">3</a></li>
   		<li class="page-item"><a class="page-link" href="#">다음</a></li>
  </ul><br>
            <!-- 검색 폼 영역 -->
            <div id="li-search">
                    <select id='search-option' >
                        <option value='A'>내담자+제목</option>
                        <option value='T'>제목</option>
                        <option value='C'>내담자</option>
                    </select>
                    <input id='txt-KeyWord' />
                    <input type='button' value='검색'/>
                
                </div><br>
    
    
    
    
    

  </div>
  <!-- /.container -->

 <!-- Footer -->
  <footer class="py-5 bg-dark">
   <div class="container_footer">
   (주) 귀울임 사업자 정보 
  <pre id = "footerInfo">  		 		
	(주) 귀울임 | 서울시 강남구 강남스타일로 123-4
	대표 : 홍길동 | 개인정보보호책임 : 황진이
	사업자 등록번호 : 123-45-6789
	통신판매업신고 : 2021-서울강남-01234호
	전화 : 02-1234-1234
	email : pclass@khaca.com
    </pre>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


</body>
</html>