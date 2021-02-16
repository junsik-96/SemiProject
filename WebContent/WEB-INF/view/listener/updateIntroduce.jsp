<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>
     <div class="col-lg-9 mb-4" style="padding-top: 1vw; min-height: 700px;">
        <h1>내 정보 수정</h1>
        <hr>
        <div class="row">
    	<div style="width: 70%; height: 70%; padding-left: 2vw; padding-top: 1vw; padding-bottom: 1vw">
        <form action="/listener/updateintroduceimpl" method="POST" id="user_modify" name="sentMessage" id="contactForm" novalidate>
          <div class="control-group form-group">
            <div class="controls">
              <label>아이디<br></label>
            </div>
            <div class="col-lg-9 mb-4">
            	<h5><b>${sessionScope.user.userId}</b></h5>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>이름</label>
              <input type="text" class="form-control" id="name" name="name" required data-validation-required-message="Please enter your name." placeholder="${sessionScope.user.name}">
              <p class="help-block"></p>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>이메일</label>
            </div>
            <div class="col-lg-9 mb-4">
            	<h5><b>${sessionScope.user.email}</b></h5>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>전화번호</label>
              <input type="tel" class="form-control" id="tel" name="tel" required data-validation-required-message="Please enter your phone number." placeholder="${sessionScope.user.tel}">
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>생년월일 <br></label>
            </div>
            <div class="col-lg-9 mb-4">
            	<h5><b>${sessionScope.user.birth}</b></h5>
            </div>
          </div>

          <div id="success"></div>
          <!-- For success/fail messages -->
          <br>
          <button type="submit" class="btn btn-primary">수정하기</button>
        </form>
      </div>
      </div>
    </div>





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