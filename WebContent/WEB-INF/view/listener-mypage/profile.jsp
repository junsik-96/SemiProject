<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>
<style type="text/css">
	.btn-primary{
		width: 80%;
	}
</style>
</head>
<body>

<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">About
      <small>ListenerProfile</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="/index">Home</a>
      </li>
      <li class="breadcrumb-item active">상담사 상세</li>
    </ol>

    <!-- Content Row -->
<div class="card" style="border-style: hidden; margin:10px">
		<div class="card-header" style="font-size: large; border:1px;">
			<div class="row">
				<div class="col-8 text-left"><h3><b>${listById.listName}</b>&nbsp;님의 프로필</h3></div>
				<div class="col-4 text-right">
					( 추천현황 :  <span style="color: red;">${listById.listLikely}</span> )
				</div>
			</div>
		</div>

		<div class="card-body" style="margin-top : 10px;">
			<h3 class="card-title">
				주 분야 : <b>${listById.listField}</b>&nbsp;<small>| ${listById.type}</small>
			</h3>
			<br>
			<hr style="border-bottom-style: dashed;">
			<div class="row">
				<div class="col-9 text-left">
					<h4>
	            	<br>
	     			상담가격 :  <span style="color: #6495ED;">${listById.listAmt}</span><br><hr>
	   				최종학력 :  <span style="color: #6495ED;">${listById.listSchool} / ${listById.listClass}</span><br><hr>
	    			성별 :  <span style="color: #6495ED;">${listById.listGen}</span><br><hr>
	     			상담사 등록일 :  <span style="color: #6495ED;">${listById.listRegDate}</span><br><hr>
	      			총 예약 수 : <span style="color: #6495ED;">${listById.listResCnt}</span><br><hr>
	      			자기소개 : <span style="color: #6495ED;">${listById.listPro}</span><br><br>
	      			</h4>
	            </div>
				
				<c:if test="${sessionScope.userType eq '일반회원'}">
				<div class="col-3 text-right">
					<br>
					<a onclick="return confirm('추천하시겠습니까?')" href="/member/likey?listId=${listById.listId}" class="btn btn-primary">추천하기</a>
					<br>
					<a onclick="return confirm('찜목록에 추가하시겠습니까?')" href="/member/holdAction?listId=${listById.listId}" style="margin-top: 5%;" class="btn btn-primary">찜하기</a>
					<br>
					<a href="/reservation/view?id=${listById.listId}" class="btn btn-primary" style="margin-top: 5%;">예약하기</a>
					
				</div>
				</c:if>
		</div>
		</div>
	</div>
</div>
  <!-- /.container -->


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
</body>
</html>