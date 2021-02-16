<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shytalker</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">
<style type="text/css">
	.btn{
		width: 100%;
	}
</style>
</head>
<body>
	 
  
<!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">MyPage
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="/index">Home</a>
      </li>
      <li class="breadcrumb-item">
        <a href="/member/mypage">Mypage</a>
      </li>
      <li class="breadcrumb-item active">찜 목록</li>
    </ol>

    <!-- Content Row -->
    <div class="row">
      <!-- Sidebar Column -->
      <div class="col-lg-3 mb-4">
        <div class="list-group" style="text-align: center; padding-top: 1vw">
          <a href="/member/mypage" class="list-group-item">마이페이지</a>
          <a href="/member/user_modify" class="list-group-item">내 정보 수정</a>
          <a href="/member/hold" class="list-group-item">찜 목록</a>
          <a href="/member/reservation" class="list-group-item">예약내역</a>
          <a href="/member/payment" class="list-group-item">결제내역</a>
          <a href="/member/myboard" class="list-group-item">내 게시글</a>
        </div>
      </div>
      
      <!-- Content Column -->
      <div class="col-lg-9 mb-4" style="padding-top: 1vw">
        <h1>찜 목록</h1>
        <hr>
        <!-- Blog Post -->
        <c:forEach var="listener" items="${listArr}">
		    <div class="card mb-4">
		      <div class="card-body">
		        <div class="row">
		          <div class="col-lg-6">
		            <a href="#">
		              <img class="img-fluid rounded" src="http://placehold.it/750x300" alt="">
		            </a>
		          </div>
		          <div class="col-lg-6">
		            <h2 class="card-title">${listener.listId}</h2>
		            <p class="card-text">${listener.listPro}</p>
		            <a href="#" class="btn btn-primary">바로 가기 &rarr;</a>
		          </div>
		        </div>
		      </div>
		      <div class="card-footer text-muted">
		       	상담가격 : ${listener.listAmt} / 추천 수 : ${listener.listLikely}
		      </div>
		     </div>
	     </c:forEach>

        
        <!-- Pagination -->
	    <ul class="pagination justify-content-center mb-4">
	      <li class="page-item">
	        <a class="page-link" href="#">&larr; Older</a>
	      </li>
	      <li class="page-item disabled">
	        <a class="page-link" href="#">Newer &rarr;</a>
	      </li>
	    </ul>
	    
      </div>
    </div>
    <!-- /.row -->   
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
  
  <script type="text/javascript">
		let login = () => {
			
			const url = '/member/loginimpl';
			
			let params = {};
			params.id = id.value;
			params.pw = pw.value;
			
			//post방식으로 진행
			//헤더 설정
			let headerObj = new Headers();
			//form태그의 기본 content 타입인 application/x-www-form-urlencoded로
			//content-type을 맞춰야 서버에서 편하게 getParameter로 사용할 수 있다.
			//name=value&name=value
			headerObj.append("content-type","application/x-www-form-urlencoded");
			fetch(url,{
				method : "POST",
				headers : headerObj,
				body : "data=" + JSON.stringify(params)
			}).then(response => {
				//200번대 응답코드라면
				if(response.ok){
					return response.text();
				}else{
					throw new AsyncResponseError(response.text());
				}
			}).then(text => {
				if(text == 'fail'){
					document.querySelector('#success').innerHTML = '아이디나 비밀번호를 확인하세요';
				}else if(text == 'success'){
					location.href = "/index";
					//document.querySelector('html').innerHTML = text;
				}
			}).catch((error)=>{
				error.alertMessage();
			})
		}
	</script>

</body>
</html>