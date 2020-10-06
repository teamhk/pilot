<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hk.pilot.dto.Members" %>
<%  
	Members owner = (Members) request.getAttribute("owner");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
<h1>회원 정보 수정</h1>
	<form action='ownerUpdate' name='storeform' method='post' id='storeform'>
		ID :<input type='text' name='id' value="${loginMember.id }" readonly><br>  <!--${loginMember.name }-->
		비밀번호 확인 : <input id='pwdcheck' type='password' name= "" value="">&nbsp;&nbsp;<span id="result1"></span><br>
		새 비밀번호 : <input id='newPwd' type='password' value=""><br>
		새 비밀번호 확인 : <input type='password' id='pwd' name="" value="">&nbsp;&nbsp;<span id="result2"></span><br>
		이름 :<input type='text' name='name' value="${owner.name}"><br>
		이메일 :<input type='text' name='email' value="${owner.email}"><br>
<%-- 		주소 :<input type='text' name='address' value="${owner.address}"><br> --%>
		연락처:<input type='number' name='pnum' value="${owner.pnum}"><br>
		비밀 번호 찾기 질문 : <input type='text' name='pwQuestion' value="${owner.pwQuestion}"><br>
		비밀 번호 찾기 정답 : <input type='text' name='pwAnswer' value="${owner.pwAnswer}"><br>
	</form>
		<button id='btn' disabled onclick="abcd();">전송</button>
<script>
$().ready(function() {
	$("#pwdcheck").change(function() {
		pwdch = document.getElementById('pwdcheck').value;
		if(pwdch===("<%=owner.getPwd()%>")){
			$("#result1").text("비밀번호가 일치합니다.");
			$('#btn').prop('disabled',false);
		} else {
			$("#result1").text("비밀번호가 일치 하지 않습니다.");
			$('#btn').prop('disabled',true);
		}
	});
	
	$("#pwd").change(function (){newPwdCheck();});
	$("#newPwd").change(function (){newPwdCheck();});
});

function newPwdCheck(){
	newPwd = document.getElementById('newPwd').value;
	rePwd = document.getElementById('pwd').value;
	if(rePwd===newPwd){
		$('#btn').prop('disabled',false);
	} else{
		$('#btn').prop('disabled',true);
	}
	if($('#btn').prop('disabled')){
		$("#result2").text("새 비밀번호가 일치 하지 않습니다.");
	} else {
		$("#result2").text("새 비밀번호가 일치합니다.");
	}
	if(rePwd===""){
		$("#result2").text("");
	}
}

function abcd(){
	pwdcheck = document.getElementById('pwdcheck');
	rePwd = document.getElementById('pwd');
	if(rePwd.value!=""){
		rePwd.setAttribute("name","pwd");
	} else {
		pwdcheck.setAttribute("name","pwd");
	}
	document.storeform.submit();
}
</script>
</body>
</html>