<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hk.pilot.dto.Members" %>
<%@ page import="com.hk.pilot.dto.Bubble" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Bubble 리스트</h2>
<div id='maindiv'>
	<table border='1'>
		<tr>
			<td>충전금액</td><td>버블잔량</td>
		</tr>
		<c:forEach items="${bub}" var="bubble"> <!-- 반복문으로 tr,td생성 -->
			<tr>
				<td>${bubble.b_price}</td>
<%-- 				<td><a href='update?mno=<c:out value="${member.mno}" />'><c:out value="${member.mname}" /></a></td> --%>
				<td>${bubble.bubble}</td>
<%-- 				<td><c:out value="${member.email}" /></td> --%>
<%-- 				<td><a href='delete?mno=<c:out value="${member.mno}" />'>삭제</a></td> --%>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div id='detail'>
	</div>
</body>
</html>