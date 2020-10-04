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
<title>업체 정보</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
<h1>업체 정보</h1>
<form action='updateOne' name='storeform' method='post' id='storeform'>
		ID :<input type='text' name='id' value=${loginMember.id } readonly><br>  <!--${loginMember.name }-->
		상호명 :<input type='text' name='sname' value="${storeInfo.sname}"><br>
		주소 :<input type='text' name='saddress' value="${storeInfo.saddress}"><br>
		전화번호:<input type='number' name='scontact' value="${storeInfo.scontact}"><br>
		사업자 등록 번호:<input type='number' name='snum' value="${storeInfo.snum}" readonly><br>
		<label for="banks">은행명:</label>
		<select id="banks" name="bank" form="storeform">
  			<option value="국민">국민</option>
  			<option value="기업">기업</option>
  			<option value="농협">농협</option>
  			<option value="신한">신한</option>
  			<option value="우체국">우체국</option>
  			<option value="스탠다드차타드">스탠다드차타드</option>
  			<option value="하나">하나</option>
  			<option value="우리">우리</option>
  			<option value="산업">산업</option>
  			<option value="수협">수협</option>
  			<option value="새마을금고">새마을금고</option>
  			<option value="신용협동조합">신용협동조합</option>
  			<option value="저축은행">저축은행</option>
  			<option value="케이뱅크">케이뱅크</option>
  			<option value="카카오뱅크">카카오뱅크</option>
  		</select>
		계좌번호:<input type='number' name='bnum' value="${storeInfo.bnum}"><br>
		취급 품목 : <input type='button' id='btn' value='펼치기'><br>
		<fieldset>
			<legend>취급 품목 리스트</legend>
				<input type='checkbox' id='list' name='blouse' 
				<%= (stInfo.getBlouse()==1) ? "checked" : ""%> value="">블라우스&nbsp;&nbsp;&nbsp;
				<input type='checkbox' id='list' name='shirt' 
				<%= (stInfo.getShirt()==1) ? "checked" : ""%> value='0'>셔츠&nbsp;&nbsp;&nbsp;
				<input type='checkbox' id='list' name='t_shirt' 
				<%= (stInfo.getT_shirt()==1) ? "checked" : ""%> value='0'>티셔츠&nbsp;&nbsp;&nbsp;
		</fieldset>
		<input type='hidden' name='area_num' value="${storeInfo.area_num}">
		<button onclick="abcd();">전송</button>
	</form>
<script>
	window.onload = function() {
		
		//--------셀렉트값을 디비에서 가져와서 표현
		var str1 = "<%=stInfo.getBank()%>";
		document.storeform.bank.value=str1;

		
		//--------품목이 체크되면 Value값을 1로 변경해주는 함수
		$("input[type='checkbox']").change(function() {
			if ($(this).is(':checked')) {
				$(this).val('1');         //체크된 체크박스는 value값을 1로 바꿈
			} else {
				$(this).val('0');			//체크되지 않은 체크박스는 value값을 0으로 바꿈
			}
		});
	

		//-----------area_num값을 자동으로 입력해주는 함수
		$("input[name='saddress']").change(function() {      
			var a = document.getElementsByName("saddress")[0];
			aval = a.value;
			if(aval.indexOf("강남구")!=-1){
				$("[name='area_num']").val('1');
			} else if (aval.indexOf("강동구")!=-1){
				$("[name='area_num']").val('2');
			} else if (aval.indexOf("강북구")!=-1){
				$("[name='area_num']").val('3');
			} else if (aval.indexOf("강서구")!=-1){
				$("[name='area_num']").val('4');
			} else if (aval.indexOf("관악구")!=-1){
				$("[name='area_num']").val('5');
			} else if (aval.indexOf("광진구")!=-1){
				$("[name='area_num']").val('6');
			} else if (aval.indexOf("구로구")!=-1){
				$("[name='area_num']").val('7');
			} else if (aval.indexOf("금천구")!=-1){
				$("[name='area_num']").val('8');
			} else if (aval.indexOf("노원구")!=-1){
				$("[name='area_num']").val('9');
			} else if (aval.indexOf("도봉구")!=-1){
				$("[name='area_num']").val('10');
			} else if (aval.indexOf("동대문구")!=-1){
				$("[name='area_num']").val('11');
			} else if (aval.indexOf("동작구")!=-1){
				$("[name='area_num']").val('12');
			} else if (aval.indexOf("마포구")!=-1){
				$("[name='area_num']").val('13');
			} else if (aval.indexOf("서대문구")!=-1){
				$("[name='area_num']").val('14');
			} else if (aval.indexOf("서초구")!=-1){
				$("[name='area_num']").val('15');
			} else if (aval.indexOf("성동구")!=-1){
				$("[name='area_num']").val('16');
			} else if (aval.indexOf("성북구")!=-1){
				$("[name='area_num']").val('17');
			} else if (aval.indexOf("송파구")!=-1){
				$("[name='area_num']").val('18');
			} else if (aval.indexOf("양천구")!=-1){
				$("[name='area_num']").val('19');
			} else if (aval.indexOf("영등포구")!=-1){
				$("[name='area_num']").val('20');
			} else if (aval.indexOf("용산구")!=-1){
				$("[name='area_num']").val('21');
			} else if (aval.indexOf("은평구")!=-1){
				$("[name='area_num']").val('22');
			} else if (aval.indexOf("종로구")!=-1){
				$("[name='area_num']").val('23');
			} else if (aval.indexOf("중구")!=-1){
				$("[name='area_num']").val('24');
			} else {
				$("[name='area_num']").val('25');  //중랑구
			}
		});

		
	}
	//--------서브밋 할때 현재 체크 상태 확인해서 체크된건 1로 변경
	function abcd(){
		$("input[type='checkbox']:checked").each(function(){
			$(this).val('1');
			}
		);
		document.storeform.submit();
	}
		
</script>
</body>
</html>