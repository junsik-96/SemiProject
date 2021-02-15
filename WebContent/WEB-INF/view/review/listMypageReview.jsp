
<!-- 상담사 // 평가내역 페이지 입니다 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">

 <!-- 별점 css -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="/resources/star-rating/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="/resources/star-rating/js/star-rating.js" type="text/javascript"></script>




</head>


<body>


  <!-- Page Content -->
  <div class="container">
  
  <h1 class="mt-4 mb-3">상담사
      <small>평가내역</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index">Home</a>
      </li>
       <li class="breadcrumb-item active"><a href="/shy/myPageMain">상담사 마이페이지</a></li>
    </ol>

     <!-- review start -->
            <div class="col-lg-8 col-md-12">
                <div class="card table-card review-card" style="width: 800px;
    		margin-left: 20%;">
                    <div class="card-header borderless ">
                        <h5>평가 후기</h5>
                    </div>
                    
                    <!-- 후기 카드 -->
                    <div class = "card">
                    <div class="card-body">
                        <div class="review-block">
                            <div class="row">
                 
                                <table class="table table-stripped" id="reviews">
							    <thead>
							        <tr>
							            <th>평점</th> <!-- 평점 -->
							            <th>회원</th>
							            <th>후기</th>
							        </tr>
							    </thead>
							    <tbody>
							    <c:if test="${requestScope.reviewList != null }">
							        <c:forEach var="review" items="${requestScope.reviewList}" varStatus="status">
							            <!-- 평점 기준 별표시 출력 -->
							            <tr>
							                <td><c:forEach var="rating" varStatus="status" begin="1" end="${ review.rating }">★</c:forEach></td>
							                <td>${ review.rvUserId }</td>
							                <td>${ review.review }</td>
							            </tr>
							        </c:forEach>
							        </c:if>
							    </tbody>
							</table>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="text-right  m-r-20">
                            <a href="#!" class="b-b-primary text-primary">리뷰 더 보기</a>
                        </div>
                    </div>
                    
                    
                    
                </div>
                <br>
                <br>
    			</div>

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
</div>
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
  
  
  
  
  
  
  
  
  
  
  
</div>
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