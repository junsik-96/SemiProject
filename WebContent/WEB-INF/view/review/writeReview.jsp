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
<link href="/resources/star-rating/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="/resources/star-rating/js/star-rating.js" type="text/javascript"></script>



</head>

<body>


 <form action="${context}/review/upload" method="post" id="re_upload">
 
    <div class="text">
    <div>${sessionScope.sessionID}</div>
    <textarea id="writeReview" class="write-review" name="wr_review" 
					style="width:200px; height:300px; overflow:auto;" required="required"></textarea>
					
	</div>				
    <!-- 평점 선택창 -->
    <label path="rating">평점: </label>
    <select path="rating">
        <span>${data.review.ratingOptions}</span>
    </select>
    <c:hidden path="rvListId" />
    <c:hidden path="rvUserId" />
    <button class="btn btn-block btn-primary" type="submit">리뷰 등록</button>
    
    <!-- 리뷰작성자만 수정,삭제 가능 -->
    <c:if test="${data.review.rvUserId == sessionScope.sessionID }">
    	<a href="#">수정</a><br>
    	<a href="#">삭제</a>
    </c:if>
    
</form>

	
	
	

















</body>
</html>