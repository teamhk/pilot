<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.hk.pilot.dto.StoreInfo"%>
<%
	StoreInfo stInfo = (StoreInfo) request.getAttribute("storeInfo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰보기</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>

</head>
<body>
	<h1>리뷰보기</h1>


	<form action='updateOne' name='storeform' method='post' id='storeform'>
		ID :<input type='text' name='id' value=${loginMember.id } readonly><br>
		<!--${loginMember.name }-->

	</form>

	<section id="container">
		<form role="form" method="get">
			<table>
				<tr>
					<th>리뷰번호</th>
					<th>주문번호</th>
					<th>내용</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>

				<c:forEach items="${reviewListU}" var="reviewListU">
					<tr>
						<td><c:out value="${reviewListU.r_no}" /></td>
						<td><c:out value="${reviewListU.orderNum}" /></td>
						<td><c:out value="${reviewListU.r_content}" /></td>
						<td><c:out value="${reviewListU.w_id}" /></td>
						<td><fmt:formatDate value="${reviewListU.r_date}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</section>






	<script>
	window.onload = function() {
		

</script>
</body>
</html>