
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

 <!-- 별점 css -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">





</head>


<body>


  <!-- Page Content -->
  <div class="container">
  
  <h1 class="mt-4 mb-3">평가내역
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index">Home</a>
      </li>
       <li class="breadcrumb-item active"><a href="/shy/myPageMain">Mypage</a></li>
       <li class="breadcrumb-item active">평가내역</li>
    </ol>
    
    <h3><b>${sessionScope.user.name}</b><small>님의 평가내역</small></h3>
    <hr>

     <!-- review start -->
                <div style="width: 100%;">
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
							            <th id="review-rate" style="padding-left:40px;">평점</th> <!-- 평점 -->
							            <th id="review-member" style="padding-right:40px;">회원</th>
							            <th id="review-review" style="padding-right:50px;">후기</th>
							        </tr>
							    </thead>
							    <tbody>
							    
							        <c:forEach var="review" items="${reviewList}">
							            <!-- 평점 기준 별표시 출력 -->
							            <tr>
							                <td id="star-color" style="color:#F05522;">
							                <c:forEach var="rating" begin="1" end="${review.rating}"><i class="fas fa-star"></i></c:forEach>
							                </td>
							                <td>${review.rvUserId}</td>
							                <td>${review.review}</td>
							            </tr>
							        </c:forEach>
							        
							    </tbody>
							</table>
                                </div>
                            </div>
                        </div>
                        <br>
                    </div>
                    
                    
                    
                </div>
                <br>
                <br>
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