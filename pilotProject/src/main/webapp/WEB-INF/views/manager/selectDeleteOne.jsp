<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hk.pilot.dto.StoreInfo" %>
<%  
	StoreInfo stInfo = (StoreInfo) request.getAttribute("storeInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체 삭제</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
<h1>업체 삭제</h1>
		ID :<input type='text' name='id' value="${loginMember.id }" readonly><br>  <!--${loginMember.name }-->
		상호명 :<input type='text' name='sname' value="${storeInfo.sname}" readonly><br>
		주소 :<input type='text' name='saddress' value="${storeInfo.saddress}" readonly><br>
		전화번호:<input type='number' name='scontact' value="${storeInfo.scontact}" readonly><br>
	<form action='deleteOne' name='storeform' method='post' id='storeform'>
		사업자 등록 번호:<input type='number' name='snum' value="${storeInfo.snum}" readonly><br>
	</form>
		은행명:<input type='text' name='back' value="${storeInfo.bank}" readonly><br>
		계좌번호:<input type='number' name='bnum' value="${storeInfo.bnum}"><br>
		비밀번호 확인 : <input id='pwdcheck' type='password' name="pwdcheck" value="">&nbsp;&nbsp;<span id="result"></span><br>
		<button id='btn' disabled onclick="abcd();">전송</button>
<script>
$().ready(function() {
	$("#pwdcheck").change(function() {
		var pwdch = document.getElementById('pwdcheck').value;
		$.ajax({
			url : '/member/rest/pwdJson',
			data : { 
				id : '${loginMember.id}',
				pwd : pwdch
			},
			dataType : 'text', /*html, text, json, xml, script*/
			method : 'get',
			success : function(data) {
				if(data==="N"){
					$("#result").text("비밀번호가 일치 하지 않습니다.");
					$('#btn').prop('disabled',true);
				} else {
					$("#result").text("비밀번호가 일치합니다.");
					$('#btn').prop('disabled',false);
				}
			}
		})
	});
});
	
function abcd(){
	document.storeform.submit();
}
</script>
</body>
</html>