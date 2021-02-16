
<!-- 상담사 예약스케줄 페이지 입니다. -->

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
  <link href='/resources/fullCalendar/lib/main.css' rel='stylesheet' />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fullcalendar/core@5.5.1/">
  <script src='/resources/fullCalendar/lib/main.js'></script>
  
  <script type="text/javascript">

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
        });
        calendar.render();
      });

    </script>
    
    <style type="text/css">
    	.fc-col-header-cell-cushion {
    		color: black;
    	}
    	
    	.fc-daygrid-day-number{
    		color: black;
    	}
    
    
    
    </style>
</head>
<body>

	
 

  <!-- Page Content -->
  <div class="container">

    <!-- 페이지 제목 -->
    <h1 class="mt-4 mb-3">예약스케줄
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index">Home</a>
      </li>
       <li class="breadcrumb-item active"><a href="/shy/myPageMain">Mypage</a></li>
       <li class="breadcrumb-item active">예약스케줄</li>
    </ol>
    
   	
   		
   		<div  id="calendar"> </div>
   		
   		<script>
   				$(document).ready(function(){
   					$('#calendar').fullCalendar({
   						$.ajax({
   							url : 'CalendarController.jsp',
   							type: "GET",
   							success: function (ResCal){
   								var json = ${calendarArr};
   								var events = [];
   								
   							$.each(json, function (key, item){
   								var str;
   								str += "[" + "회원: " + item.resUserId + ", 예약일 : " + item.resDate + " ]"
   								
   								events.push({title: str, start: item.resDate, color: '#FF5E00', allDay: true});
   								
   							
   								});
   							callback(events);
   							}
   						});
   						
   				
   					});
   					});
   			
   				
   				
   			
   		</script>
   		
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