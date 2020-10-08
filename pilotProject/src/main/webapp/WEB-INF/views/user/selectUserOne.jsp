
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hk.pilot.dto.Members" %>
<%@ page import="com.hk.pilot.dto.PersonalPay" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%  
	Members user = (Members) request.getAttribute("user");
%>
<%  
	PersonalPay pay = (PersonalPay) request.getAttribute("pay");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript">
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
</script>
</head>
<body>
<h1>회원 정보 수정</h1>
<%-- 	<form action='update' name='storeform' method='post' id='storeform'> --%>
<%-- 		ID :<input type='text' name='id' value="${loginMember.id }" readonly><br>  <!--${loginMember.name }--> --%>
<!-- 		비밀번호 확인 : <input id='pwdcheck' type='password' name= "" value="">&nbsp;&nbsp;<span id="result1"></span><br> -->
<!-- 		새 비밀번호 : <input id='newPwd' type='password' value=""><br> -->
<!-- 		새 비밀번호 확인 : <input type='password' id='pwd' name="" value="">&nbsp;&nbsp;<span id="result2"></span><br> -->
<%-- 		이름 :<input type='text' name='name' value="${user.name}"><br>  --%>
<%-- 		이메일 :<input type='text' name='email' value="${user.email}"><br> --%>
<%--         주소 :<input type='text' name='address' value="${user.userSecondAddr}"><br>  --%>
<%-- 		연락처:<input type='number' name='pnum' value="${user.pnum}"><br> --%>
<%--         비밀 번호 찾기 질문 : <input type='text' name='pwQuestion' value="${user.pwQuestion}"><br> --%>
<%--         비밀 번호 찾기 정답 : <input type='text' name='pwAnswer' value="${user.pwAnswer}"><br> --%>
<%-- 		카드회사:<input type='text' name='cardCom' value="${user.cardCom }"><br>  --%>
<%-- 		카드번호:<input type='text' name='cardNum' value="${user.cardNum }"><br> --%>
<!-- 		<label for="banks">카드등록:</label> -->
<!-- 		<select id="banks" name="bank" form="storeform"> -->
<!--   			<option value="" selected>-은행을 선택해 주세요-</option> -->
<!--   			<option value="국민">국민</option> -->
<!--   			<option value="기업">기업</option> -->
<!--   			<option value="농협">농협</option> -->
<!--   			<option value="신한">신한</option> -->
<!--   			<option value="우체국">우체국</option> -->
<!--   			<option value="스탠다드차타드">스탠다드차타드</option> -->
<!--   			<option value="하나">하나</option> -->
<!--   			<option value="우리">우리</option> -->
<!--   			<option value="산업">산업</option> -->
<!--   			<option value="수협">수협</option> -->
<!--   			<option value="새마을금고">새마을금고</option> -->
<!--   			<option value="신용협동조합">신용협동조합</option> -->
<!--   			<option value="저축은행">저축은행</option> -->
<!--   			<option value="케이뱅크">케이뱅크</option> -->
<!--   			<option value="카카오뱅크">카카오뱅크</option> -->
<!--   		</select> -->
<!-- 		카드번호:<input type='number' name='cardNum'><br> -->
<%-- 	</form> --%>
	<div class="col-sm-6 col-md-offset-3">
			<form action='update' name='storeform' method='post' id='storeform'>
				<input type="hidden" name="grade" value="1">
				<label><b>아이디</b></label>
				<input type='text' name='id' value="${loginMember.id }" readonly><br>
				<label><b>비밀번호</b></label>
				<input id='pwdcheck' type='password' name= "" value="">&nbsp;&nbsp;<span id="result1"></span><br>
				<label><b>새 비밀번호</b></label>
				<input id='newPwd' type='password' value=""><br>
				<label><b>새 비밀번호 확인</b></label>
				<input type='password' id='pwd' name="" value="">&nbsp;&nbsp;<span id="result2"></span><br>
				<label><b>이름</b></label>
				<input type='text' name='name' value="${user.name}"><br>
				<label><b>이메일</b></label>
				<input type='text' name='email' value="${user.email}"><br>
				<label><b>휴대전화</b></label>
				<input type='number' name='pnum' value="${user.pnum}"><br> 
				<label><b>집주소</b></label>
				<input type="text" id="sample6_postcode" placeholder="${user.userZipCode}" name="userZipCode" value="${user.userZipCode}">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="sample6_address" placeholder="주소" name="userFirstAddr" value="${user.userFirstAddr}"><br>
				<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="userExtraAddr" value="${user.userExtraAddr}"><br>
				<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="userSecondAddr" value="${user.userSecondAddr}">
				<label><b>카드회사</b></label>
				<input type='text' name='cardCom' value="${pay.cardCom }">
				<label><b>카드번호</b></label>
				<input type='text' name='cardNum' value="${pay.cardNum }">
<!-- 				<h3>결제 카드 등록</h3> -->
<!-- 				<label for="cardCom"><b>카드회사</b></label> -->
<!-- 				<select id="cardCom" name="cardCom"> -->
<!-- 					<option value="" selected>-카드사를 선택해 주세요-</option> -->
<!-- 					<option value="KB카드">KB국민카드</option> -->
<!-- 					<option value="신한카드">신한카드</option> -->
<!-- 					<option value="하나카드">하나카드</option> -->
<!-- 					<option value="롯데카드">롯데카드</option> -->
<!-- 					<option value="BC카드">BC카드</option> -->
<!-- 					<option value="농협카드">NH농협카드</option> -->
<!-- 					<option value="삼성카드">삼성카드</option> -->
<!-- 					<option value="현대카드">현대카드</option> -->
<!-- 				</select> -->
<!-- 				<label><b>카드번호</b></label> -->
<!-- 				<input type="text" size="20" id="cardNum" name="cardNum" maxlength="12" oninput="checkCardNum(this.value)"> -->
<!-- 				<div class="validation" id="cardNum_check"></div> -->
				<!-- 카드 날짜 입력 받는거 상의해야해, 혹시 굳이 날싸 입력 받아야 된다고 하면 int타입으로 바꾸고 월입력칸 따로 년도 입력칸 따로 만든후 DB에도 칼럼을 그냥 date타입으로 하나만 하는게 아니라 나눠서 하기 -->
			</form>
		</div>
		<button id='btn' disabled onclick="abcd();">전송</button>
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