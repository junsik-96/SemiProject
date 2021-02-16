
<!-- 상담사 // 예약관리 페이지 입니다. -->

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
.col-md-12 {
	margin-left: 25%;
}
.chk-option{
	float: left;
}

.card-header{
	display: flex;
}
  
.table-card {
    .card-body {
        padding-left: 0;
        padding-right: 0;
        padding-top: 0;

        .table {
            > thead > tr > th {
                border-top: 0;
            }

            .chk-option {
                vertical-align: middle;
                width: 30px;
                display: inline-block;

                .checkbox-fade,
                .checkbox-fade .cr,
                .checkbox-zoom,
                .checkbox-zoom .cr {
                    margin-right: 0;
                }
            }

            label {
                margin-bottom: 0;
            }

            tr {
                td,
                th {
                    &:first-child {
                        padding-left: 20px;
                    }

                    &:last-child {
                        padding-right: 20px;
                    }
                }
            }
        }
    }
}

  </style>
</head>
<body>

	
  <!-- 상단 고정 바  -->
  
  

    <!-- Page Content -->
  <div class="container">

    <!-- 페이지 제목 -->
    <h1 class="mt-4 mb-3">예약내역
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index">Home</a>
      </li>
       <li class="breadcrumb-item active"><a href="/shy/myPageMain">Mypage</a></li>
       <li class="breadcrumb-item active">예약내역</li>
    </ol>
    
    <h3><b>${sessionScope.user.name}</b><small>님의 예약내역</small></h3>
    <hr>
    
     <!-- prject ,team member start -->
                    <div class="card-header">
                        <h5>예약자 명단</h5>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-hover mb-0">
                                <thead>
                                    <tr>
                                        <th>이름 </th>
                                        <th>고민 분야</th>
                                        <th>예약일자</th>
                                        <th class="text-right">진행상황</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="calendar" items="${resList}" >
                                    <tr>
                                        <td>
                                            <div class="d-inline-block align-middle">
                                                
                                                <div class="d-inline-block">
                                                    <h6>${calendar.resUserId }</h6>
                                   
                                                </div>
                                            </div>
                                        </td>
                                        <td>우울증</td>
                                        <td>${calendar.resDate}</td>
                                        <td class="text-right"><label class="badge badge-light-danger">완료</label></td>
                                    </tr>             
                                   </c:forEach>
                                                         
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            <br>
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