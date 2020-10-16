<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.hk.pilot.dto.OrderProcess" %>
<%  
	OrderProcess orderPro = (OrderProcess)request.getAttribute("myOrderList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<title>주문 상세 정보</title>
<style>
 	.tdn {cursor: pointer;}  /* 마우스 포인터가 손가락 모양으로 바꿈*/
</style>
</head>
<body>
	<c:set var="itemStr" value="${myOrderList.items}"/>
	<c:set var="itemStr" value="${fn:replace(itemStr, '!@#', ':')}"/>
	<c:set var="itemStr" value="${fn:replace(itemStr, '$%^', '개 ')}"/>
	<c:set var="itemStr" value="${fn:substring(itemStr, 0, fn:length(itemStr)-1)}" />
	<div id='maindiv'>
	주문번호:<input type='text' value='${myOrderList.orderNum}'><br>
	ID:<input type='text' value='${myOrderList.id}'><br>
	품목:<input type='text' class='item' value='${itemStr}'><br>
	결제금액:<input type='text' value='${myOrderList.pay_price}'><br>
	결제일:<fmt:formatDate value='${myOrderList.pay_date}' type='both' pattern='yyyy.MM.dd(E)(a)hh:mm:ss'/><br>
	진행 상황: <%String process="";%>
				<c:choose>
					<c:when test="${myOrderList.finish ne null}"><%process="배달완료";%></c:when>
					<c:when test="${myOrderList.wash ne null}"><%process="세탁중";%></c:when>
					<c:when test="${myOrderList.pick ne null}"><%process="수거완료";%></c:when>
					<c:when test="${myOrderList.ok ne null}"><%process="접수완료";%></c:when>
					<c:when test="${myOrderList.wait ne null}"><%process="접수중";%></c:when>
				</c:choose>
				<input type='text' value='<%=process%>' class='pro' readonly><br>
	</div>
	<button class='review'>리뷰작성</button>
	<button class='tdn'>전화면으로</button>
	<div id='detail'>
	</div>

</body>
</html>