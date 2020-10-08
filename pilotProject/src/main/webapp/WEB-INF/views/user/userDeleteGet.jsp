<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hk.pilot.dto.Members" %>
<%
	Members user = (Members) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<title>회원 탈회 확인</title>
</head>
<body>
<h1>회원 탈퇴 확인</h1>
정말로 탈퇴 하시겠습니까?<br>
탈퇴를 원하신다면 비밀번호를 입력해주세요<br>
	<form action='delet' name='storeform' method='post' id='storeform'>
		ID :<input type='text' id='id' name='id' value="${loginMember.id }" readonly><br>  <!--${loginMember.name }-->
		비밀번호 :<input id='pwdcheck' type='password' value="">&nbsp;&nbsp;<span id="result1"></span><br>
		이름 :<input type='text' name='name' value="${user.name}"><br>
		<button id='btn' disabled onclick="abcd();">삭제</button>
	</form>
<script>
$().ready(function() {
	$("#pwdcheck").change(function() {
		pwdch = document.getElementById('pwdcheck').value;
		if(pwdch===("<%=user.getPwd()%>")){
			$("#result1").text("비밀번호가 일치합니다.");
			$('#btn').prop('disabled',false);
		} else {
			$("#result1").text("비밀번호가 일치 하지 않습니다.");
			$('#btn').prop('disabled',true);
		}
	});
});
function abcd(){
	document.storeform.submit();
}

</script>
</body>
</html>