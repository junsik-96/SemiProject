<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- 별점 css -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">


<style type="text/css">
	#star a{ 
	text-decoration: none; 
	color: gray; 
	} 
	
	#star a.on{ 
	color: #F05522; 
	}

</style>


</head>

<body>


 <form action="${context}/review/upload" method="post" id="re_upload"
 action="reviewWriteAction.jsp">
 
    <div class="text">
    <input type="text" name="reviewUser"><br>
    <textarea id="writeReview" class="write-review" name="wrReview" 
					style="width:400px; height:200px; overflow:auto;" required="required"></textarea>
					
	</div>				
    <!-- 평점 선택창 -->
    <div class="make-star">
    	<P id="star" name="starRating"> <!-- 부모 --> 
    	<a href="#" value="1"><i class="fas fa-star"></i></a>  
    	<a href="#" value="2"><i class="fas fa-star"></i></a> 
    	<a href="#" value="3"><i class="fas fa-star"></i></a> 
    	<a href="#" value="4"><i class="fas fa-star"></i></a> 
    	<a href="#" value="5"><i class="fas fa-star"></i></a> 
    	<p>
    
    </div>
    
    <script type="text/javascript">
   		 $('#star a').click(function(){ 
   			 $(this).parent().children("a").removeClass("on"); 
   			 $(this).addClass("on").prevAll("a").addClass("on"); 
   			 console.log($(this).attr("value"));
 		});   
    </script>
   
    	<input type="submit" value= "리뷰 등록">
    	
    
    <!-- 리뷰작성자만 수정,삭제 가능 
    <c:if test="${data.review.rvUserId == sessionScope.sessionID }">
    	<a href="#">수정</a><br>
    	<a href="#">삭제</a>
    </c:if>
    -->
    
</form>

	


</body>
</html>