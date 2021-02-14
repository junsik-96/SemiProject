<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="/resources/css/joinlis.css">
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
	
	.valid_info{
		display: block;
		color: red;
		font-size: 0.5vw;
	}
</style>
</head>
<body>

 

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Join
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="/index">Home</a>
      </li>
      <li class="breadcrumb-item active">Join</li>
    </ol>

    <!-- Content Row -->
    <div class="row">
      <!-- Map Column -->
        <!-- Embedded Google Map -->
        <img src="../../resources/image/login.jpg" style="width: 50%; height: 50%">
    	<div style="width: 48%; height: 50%; padding-left: 2vw; padding-top: 2vw">
	        <h2>회원가입</h2>
	        
	        <br>
	        <h6>
	        	오늘 하루는 어떠셨나요?<br><br>
	        	자존감이 떨어지고 삶에 대한 의욕을 느끼지 못하나요?<br><br>
	        	혹은 사람들과 대화하고 때로는 거절하는 것이 많이 힘겨우신가요?<br><br>
	        	말 못할 이야기, 누가 볼까 두렵고 도움이 필요한 사람들을 위한 웹<br><br>
	        	필요한 순간, ShyTalker가 당신의 편이 되어 드립니다.
	        </h6>
	        <br>
	        <a class="btn btn-primary" data-toggle="modal" href="#registerModal">회원가입</a>
	        <a class="btn btn-primary" data-toggle="modal" style="margin-top: 2%; border: none; background-color: lightgrey; color: black" 
	        onclick="lisAlert()">상담사 신청</a>
	        <hr>
	        <div style="text-align: right">
	        	<label>이미 회원이신가요? |&nbsp;&nbsp;<a href="/member/login"><small>로그인 바로가기</small></a></label>
	        </div>
	        
      	</div>
      </div>
    </div>
    
    <!-- /.row -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">회원 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
          
				<div class="modal-body">
					<div style="text-align: right; color: red">
						<small>* 는 필수 입력 항목입니다.</small>
					</div>
					<form action="${context}/member/mailauth" method="post" id="frm_join">
						<div class="control-group form-group">
							<div class="controls">
								<label>* 아이디</label>
								<input type="text" name="id" class="form-control" id="id" required placeholder="아이디를 입력하세요.">
								<button type="button" class="btn" onclick="idCheck()">check</button>
								<span class="valid_info" id="id_check"></span>
							</div>
							
							<div class="controls">
								<label>* 비밀번호</label>
								<input type="password" name="password" class="form-control" id="password" required placeholder="비밀번호를 입력하세요.">
								<span id="pw_confirm" class="valid_info"></span>
							</div>

							<div class="controls">
								<label>* 이메일</label>
								<input type="email" name="email" class="form-control" id="email" required placeholder="abcde@abcde.abc">
							</div>

							<div class="controls">
								<label>* 이름</label>
								<input type="text" name="name" class="form-control" id="name" required placeholder="이름을 입력하세요.">
							</div>

							<div class="controls">
								<label>* 전화번호</label>
								<input type="tel" name="tel" class="form-control" id="tel" required placeholder="연락처를 입력하세요.">
							</div>

							<div class="controls">
								<label>* 회원유형</label><br>
								<input type="radio" name="userType" value="상담사">&nbsp;&nbsp;&nbsp;상담사<br>
								<input type="radio" name="userType" value="일반회원">&nbsp;&nbsp;&nbsp;일반회원
							</div>

							<div class="controls">
								<label>생년월일</label>
								<input type="date" class="form-control" id="birth" name="birth" required>
							</div>

							<div class="controls">
								<label>주 고민분야</label>
                  				<select name="concern" class="form-control">
                  					<option value="선택안함" selected>선택안함</option>
				                    <option value="우울/불안">우울/불안</option>
				                    <option value="가족/부부">가족/부부</option>
				                    <option value="산후/육아">산후/육아</option>
				                    <option value="대인관계">대인관계</option>
				                    <option value="기타">기타</option>
                  				</select>
							</div>

							<div class="controls">
								<label>선호 상담사 유형</label>
                  				<select name="listType" class="form-control">
				                    <option value="선택안함" selected>선택안함</option>
				                    <option value="전문가">전문상담사</option>
				                    <option value="의사">의사</option>
				                    <option value="대학생">관련전공자</option>
                  				</select>
							</div>
							
						</div>
	              	<div class="modal-footer">
	                	<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	                	<button type="submit" class="btn btn-primary">등록하기</button>
	                	
	                	<script type="text/javascript">
						let idCheckFlg = false;
						
						let idCheck = () => {
							//사용자가 입력한 아이디
							//요소의 아이디 속성이 있을 경우 해당 엘리먼트를 가져다가 사용할 수 있다.
							let userId = id.value;
							
							if(userId){
								fetch("/member/idcheck?userId=" + userId,{
									method : "GET"
								}).then(response => response.text())
								.then(text => {
									if(text == 'success'){
										idCheckFlg = true;
										id_check.innerHTML = '사용 가능한 아이디 입니다.';
									}else{
										idCheckFlg = false;
										id_check.innerHTML = '사용 불가능한 아이디 입니다.';
										id.value="";
									}
								})
							}else{
								alert("아이디를 입력하지 않으셨습니다.");
							}
						}
						
						document.querySelector('#frm_join').addEventListener('submit',(e)=>{
							
							let password = password.value;
							let regExp = /^(?!.*[ㄱ-힣])(?=.*\W)(?=.*\d)(?=.*[a-zA-Z])(?=.{8,})/;
							
							if(!idCheckFlg){
								e.preventDefault();
								alert("아이디 중복 검사를 하지 않으셨습니다.");
								id.focus();
							}
							
							if(!(regExp.test(password))){
								//form의 데이터 전송을 막음
								e.preventDefault();
								pw_confirm.innerHTML = '비밀번호는 숫자,영문자,특수문자 조합의 8글자 이상인 문자열입니다.';
								password.value='';
							}
							
						});
					</script>
	              	</div>
	              	
	              	
		
				</form>
				</div>
        	</div>
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
  
  <script type="text/javascript">
  
  	function lisAlert(){
  		alert("회원가입/로그인 후 \n게시판 - '상담사 신청' 메뉴를 통해 이용해주세요."+
  				"\n!!! 회원가입시 회원유형 → '상담사' 로 가입바랍니다.");
  	}
  
  </script>

  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>