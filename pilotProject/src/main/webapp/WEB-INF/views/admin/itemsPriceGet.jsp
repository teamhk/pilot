<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<title>가격 정보 수정</title>
</head>
<body>
<article class="container">
		<div class="page-header">
			<div class="col-md-6 col-md-offset-3">
			<h3>가격 정보 수정</h3>
			</div>
		</div>
		<div id='maindiv'>
		<form action='price' method='post'>
			와이셔츠:<input type='text' name='Y1P' value='${itp.Y1P}'><br>
			블라우스:<input type='text' name='B1P' value='${itp.B1P}'><br>
			티셔츠:<input type='text' name='T1P' value='${itp.T1P}'><br>
			맨투맨:<input type='text' name='M1P' value='${itp.M1P}'><br>
			바지:<input type='text' name='P1P' value='${itp.P1P}'><br>
			니트:<input type='text' name='K1P' value='${itp.K1P}'><br>
			자켓:<input type='text' name='J1P' value='${itp.J1P}'><br>
			코트:<input type='text' name='C1P' value='${itp.C1P}'><br>
			패딩:<input type='text' name='P2P' value='${itp.P2P}'><br>
			이불:<input type='text' name='D1P' value='${itp.D1P}'><br>
			신발:<input type='text' name='S1P' value='${itp.S1P}'><br>
			커튼:<input type='text' name='C2P' value='${itp.C2P}'><br>
			가방:<input type='text' name='B2P' value='${itp.B2P}'><br>
		<button onclick='updatePrice()'>수정</button>
		</form>		
	</div>

<%-- 		<c:if test="${not empty stores }"> --%>
<%-- 		<%int i=1; %> --%>
<!-- 		<div> -->
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>번호</td> -->
<!-- 					<td>사업자번호</td> -->
<!-- 					<td>업체명</td> -->
<!-- 					<td>상세정보</td> -->
<!-- 				</tr> -->
			
<%-- 			<c:forEach var="store" items="${stores }"> --%>
<!-- 				<tr> -->
<%-- 					<td><%=i %></td> --%>
<%-- 					<td>${store.snum }</td> --%>
<%-- 					<td>${store.sname }</td> --%>
<!-- 					<td> -->
<%-- 						<button onclick="window.location.href='/admin/storeUpdate?snum=${store.snum }'">상세정보</button> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
<%-- 				<%i++; %> --%>
<%-- 			</c:forEach> --%>
<!-- 			</table> -->
<!-- 		</div> -->
<%-- 		</c:if> --%>
	</article>
<script>

function updatePrice(){

	$("form").submit();
}
</script>	
</body>
</html>