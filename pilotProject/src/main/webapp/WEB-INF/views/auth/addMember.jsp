<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script><!-- daum 도로명주소 찾기 api --> 
<script type="text/javascript">

//모든 공백 체크 정규식
var emptyR = /\s/g;
//아이디 정규식-8~12자의 영문 소문자, 숫자만 사용 가능합니다.
var idR=/^[a-z0-9]{8,12}$/;
//비밀번호 정규식-7~15자의 영문 대소문자, 숫자와 특수기호~!@\#$%<>^&*로만 사용 가능합니다.
var pwdR=/.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*/;
//이름 정규식-한글 2~4자 이내로 입력해주세요(특수문자, 공백 사용 불가)
var nameR=/^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
//이메일 검사 정규식-이메일 양식을 확인해주세요
var emailR=/^[a-zA-Z0-9!#$%^&*_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+){1,2}$/;
//휴대폰 번호 정규식-'-'없이 번호만 입력해주세요
var phoneR=/^01([0|1|?)?([0-9]{8,9})$/;
//카드 번호 정규식 
var cardNumR = /([0-9]{12})/;


//중복검사 할건데 유효성 검사도 하고 그게 true되면 중복 검사까지!!
function checkId() {
	var regexIdResult = regexId();
	console.log('regexIdResult:',regexIdResult)
	if(regexIdResult == true){
		console.log("checkId");
		var inputed=$('#id').val();
		$.ajax({
			data: {
				id:inputed
			},
			url:"/auth1/addCustomer1",
			dataType:'text',
			method:'get',
			success:function(data){
				if(data=="0"){
					$("#id_check").text("사용 가능한 아이디 입니다..");
				} else {
					$("#id_check").text("이미 사용중인 아이디 입니다. 다시 입력해주세요");
					$("#id_check").css('color', 'red');
					$("#id").focus();
				}
			},
			error: function() {
				$("#id_check").text("url을 호출중 에러입니다.")}
		});
	}
}

 function regexId(){
 	//아이디 유효성 검사(정규식)
 	if($('#id').val() == ''){
 		$('#id_check').text('아이디를 입력해주세요');
 		$('#id_check').css('color', 'red');
	} else if(idR.test( $('#id').val() ) != true){
		$('#id_check').text('8~12자의 영문 소문자, 숫자만 사용 가능합니다.');
		$('#id_check').css('color', 'red');
		return false;
	} else {
 		return true;
	}
 }

 //----------------------------------------------------------------------------------
 //비번 유효성 검사
$(document).ready(function(){
	$('#pwd').focus(function() {
		checkPwd();
	});
});

function checkPwd() {
	console.log("result",pwdR.test( $('#pwd').val ()))
	if(pwdR.test( $('#pwd').val ()) == true){
		$('#pwd_check').text('사용가능한 비밀번호 입니다.');
		$('#pwd_check').css('color', 'black');
		return true;
	} else {
		$('#pwd_check').text('특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내의 암호 정규식로만 사용 가능합니다.');
		$('#pwd_check').css('color', 'red');
		return false;
	} 
}
//-----------------------------------------------------------------------------------------
//비번 재입력 일치 확인
$(document).ready(function(){
	$('#re-pwd').focus(function(){
		reCheckPwd();
	});
});

function reCheckPwd() {
	if($('#re-pwd').val() == ''){
		$('#pwd_re_check').text('비밀번호를 재입력 해주세요');
	} else if($('#pwd').val() != $('#re-pwd').val()) {
		$('#pwd_re_check').text('비밀번호가 일치하지 않습니다.');
		$('#pwd_re_check').css('color', 'red');
	} else {
		$('#pwd_re_check').text('비밀번호가 일치합니다.');
		$('#pwd_re_check').css('color', 'black');
	}
}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//이름에 특수문자 들어가지 않도록 설정
$(document).ready(function(){
	$('#name').focus(function(){
		checkName();
	});
});

function checkName(){
	if(nameR.test($('#name').val()) != true){
		$('#name_check').text('한글 2~4자 이내로 입력해주세요.(특수기호, 공백 사용 불가)');
		$('#name_check').css('color', 'red');
	} else {
		$('#name_check').text('✔' );
		$('#name_check').css('color', 'black');
	}
}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//이메일 양식 검사
$(document).ready(function(){
	$('#email').focus(function(){
		checkEmail();
	});
});

function checkEmail(){
	if($('#email').val() == ''){
		console.log("타니1");
		$('#email_check').text('이메일을 입력해주세요');
		$('#email_check').css('color', 'black');
		
	} else if(emailR.test($('#email').val()) != true){
		console.log("타니2");
		$('#email_check').text('이메일 양식을 확인해주세요');
		$('#email_check').css('color', 'red');
	} else {
		console.log("타니3");
		$('#email_check').text('✔' );
		$('#email_check').css('color', 'black');
	}
}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//핸드폰 번호 검사
$(document).ready(function(){
	$('#pnum').focus(function(){
		checkPnum();
	});
});

function checkPnum(){
	console.log("result",phoneR.test($('#pnum').val()));
	if($('#pnum').val() == ''){
		$('#pnum_check').text('휴대폰번호를 입력해주세요');
		$('#pnum_check').css('color', 'black');
	} else if(phoneR.test($('#pnum').val()) != true){
		$('#pnum_check').text('휴대폰번호를 확인해주세요("-"없이 입력)');
		$('#pnum_check').css('color', 'red');
	} else {
		$('#pnum_check').text('✔' );
		$('#pnum_check').css('color', 'black');
	}
}
//-----------------------------------------------------------------
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
//---------------------------------------------------------------------------------------------
//카드번호 검사
$(document).ready(function(){
	$('#cardNum').focus(function(){
		checkCardNum();
	});
});

function checkCardNum(cardNum){
	console.log("cardNum", cardNum);
	if($('#cardNum').val() == ''){
		$('#cardNum_check').text('카드번호를 입력해주세요');
		$('#cardNum_check').css('color', 'black');
	} else if(cardNumR.test($('#cardNum').val()) != true) {
		$('#cardNum_check').text('숫자만 입력해주세요(공백 사용 불가)');
		$('#cardNum_check').css('color', 'red');
	} else {
		$('#cardNum_check').text('✔' );
		$('#cardNum_check').css('color', 'black');
	}
// 	cardNum = cardNum.replace(/[-]/g,'');
}

function submitCheck() {
	if($('#id').val() == '') {
		alert('아이디를 입력해주세요.');
	} else if($('#pwd').val() == '') {
		document.getElementById('pwd').focus();
	} else if($('#re-pwd').val() == '') {
		document.getElementById('re-pwd').focus();
	} else if($('#name').val() == '') {
		document.getElementById('name').focus();
	} else if($('#email').val() == '') {
		document.getElementById('email').focus();
	} else if($('#pnum').val() == '') {
		document.getElementById('pnum').focus();
	} else if($('#sample6_postcode').val() == '') {
		document.getElementById('sample6_postcode').focus();
	} else if($('#sample6_address').val() == '') {
		document.getElementById('sample6_address').focus();
	} else if($('#sample6_extraAddress').val() == '') {
		document.getElementById('sample6_extraAddress').focus();
	} else if($('#sample6_detailAddress').val() == '') {
		document.getElementById('sample6_detailAddress').focus();
	} else if($('#cardCom').val() == '') {
		document.getElementById('cardCom').focus();
	} else if($('#cardNum').val() == '') {
		document.getElementById('cardNum').focus();
	} else {
		document.addCustomer.submit();
	}
}

</script>
</head>
<body>
	<article class="container">
		<div class="page-header">
			<div class="col-md-6 col-md-offset-3">
			<h3>회원가입</h3>
			</div>
		</div>
		<div class="col-sm-6 col-md-offset-3">
			<form name="addCustomer" action="addCustomer" method="post">
				<input type="hidden" name="grade" value="1">
				<label><b>아이디</b></label>
				<input type="text" id="id" placeholder="ID" name="id" oninput="checkId()">
				<div class="validation" id="id_check"></div>
				<label><b>비밀번호</b></label>
				<input type="password" id="pwd" placeholder="PASSWORD" name="pwd" oninput="checkPwd()">
				<div class="validation" id="pwd_check"></div>
				<label><b>비밀번호 재확인</b></label>
				<input type="password" id="re-pwd" placeholder="Confirm Password" name="re-pwd" oninput="reCheckPwd()">
				<div class="validation" id="pwd_re_check"></div>
				<label><b>이름</b></label>
				<input type="text" id="name" placeholder="Name" name="name" oninput="checkName()">
				<div class="validation" id="name_check"></div>
				<label><b>이메일</b></label>
				<input type="text" id="email" placeholder="E-mail" name="email" oninput="checkEmail()">
				<div class="validation" id="email_check"></div>
				<label><b>휴대전화</b></label>
				<input type="text" id="pnum" placeholder="Phone Number" name="pnum" oninput="checkPnum()">
				<div class="validation" id="pnum_check"></div>
				<label><b>집주소</b></label>
				<input type="text" id="sample6_postcode" placeholder="우편번호" name="userZipCode">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="sample6_address" placeholder="주소" name="userFirstAddr"><br>
				<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="userExtraAddr"><br>
				<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="userSecondAddr">
				<h3>결제 카드 등록</h3>
				<label for="cardCom"><b>카드회사</b></label>
				<select id="cardCom" name="cardCom">
					<option value="" selected>-카드사를 선택해 주세요-</option>
					<option value="KB카드">KB국민카드</option>
					<option value="신한카드">신한카드</option>
					<option value="하나카드">하나카드</option>
					<option value="롯데카드">롯데카드</option>
					<option value="BC카드">BC카드</option>
					<option value="농협카드">NH농협카드</option>
					<option value="삼성카드">삼성카드</option>
					<option value="현대카드">현대카드</option>
				</select>
				<label><b>카드번호</b></label>
				<input type="text" size="20" id="cardNum" name="cardNum" maxlength="12" oninput="checkCardNum(this.value)">
				<div class="validation" id="cardNum_check"></div>
				<!-- 카드 날짜 입력 받는거 상의해야해, 혹시 굳이 날싸 입력 받아야 된다고 하면 int타입으로 바꾸고 월입력칸 따로 년도 입력칸 따로 만든후 DB에도 칼럼을 그냥 date타입으로 하나만 하는게 아니라 나눠서 하기 -->
				<input type="button" value="회원가입" class="signup" onclick="submitCheck()" id="submintCheck">
			</form>
		</div>
	</article>		
</body>
</html>