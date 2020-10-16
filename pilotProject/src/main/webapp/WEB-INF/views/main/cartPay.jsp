<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	<script type="text/javascript">
		function itemSum() {
			console.log("시작");
			var sum = 0;
			var count = $(".chkbox").length;
			for (var i = 0; i < count; i++) {
				if ($(".chkbox")[i].checked === true) {
					sum += Number($(".chkbox").eq(i).val());
				}
				console.log(sum);
				$("#total_sum").val(sum);
				$("#pricepay").val(sum);
				$("#finalprice").val(sum);
				
			}
		}

		 $(function(){
		        $('#useraddr').click(function(){
		          var user = this.checked;
		          $('#username').val(user ? $('#orderName').val():'');
		          $('#userpnum').val(user ? $('#orderpnum').val():'');
 		          $('#postcode').val(user ? $('#sample6_postcode').val():'');
		          $('#address').val(user ? $('#sample6_address').val():'');
		          $('#extraAddress').val(user ? $('#sample6_extraAddress').val():'');
		          $('#detailAddress').val(user ? $('#sample6_detailAddress').val():'');
		        });
		      });
			//버블충전
			
			$('#bubbleBut').click(function () {
				//var id=$('input[name="id"]').val()
				console.log("id=",id);
				var b_price =$('input[name="b_price"]:checked').val()
				var email=$('input[name="email"]').val()
				var name=$('input[name="name"]').val()
// 				var pnum=$('input[name="orderpnum"]').val()
   				console.log(money);
				console.log(email);
				 
				 var IMP = window.IMP;
				 IMP.init('imp75580600'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
			        //var msg;
			        
			        IMP.request_pay({
			            pg : 'kakaopay',
			            pay_method : 'card',
			            merchant_uid : 'merchant_' + new Date().getTime(),
			            name : '버블충전',
			            amount : b_price,
			            buyer_email : email,
			            buyer_name : name,
			            buyer_tel : '01026954959',
			            //m_redirect_url : '/'
			        }, function(rsp) {
			        	 console.log(rsp);
			        	 if (rsp.success) {
			                 var msg = '결제가 완료되었습니다.';
			                 msg += '고유ID : ' + rsp.imp_uid;
			                 msg += '상점 거래ID : ' + rsp.merchant_uid;
			                 msg += '결제 금액 : ' + rsp.paid_amount;
			                 msg += '카드 승인번호 : ' + rsp.apply_num;
			                 $.ajax({
			                     type: "POST", 
			                     url: "/order/bubblePay", //충전 금액값을 보낼 url 설정
			                     data: {
			                    	 //amount : money
			                         b_price : rsp.paid_amount
			                        
			                     },
			                 });
			                    } else {
			                        var msg = '결제에 실패하였습니다.';
			                        msg += '에러내용 : ' + rsp.error_msg;
			                    }
			                    alert(msg);
			                    document.location.href="/stores/pay"; //alert창 확인 후 이동할 url 설정
			                });
			            });

            //결제금액
            	$(function(){
             $("#paybubble").change(function(){

            	 var finalbubble= $(this).val();
            	 $('input[name="p_bubble"]').val(finalbubble);
				var pay=$("#pricepay").val()-$('input[name="p_bubble"]').val();
				 $("#finalprice").val(pay)
            	 
             	});
			});

			
            	
                    
           
            
		
	</script>
	<form id="payform" method="post">
		<div class="payOrder">
			<h2>주문내역</h2>
			<table class="table table-bordered" id="tbl-product">
				<colgroup>
					<col style="width: 20%;" />
					<col style="width: 20%" />
					<col style="width: 20%" />
					<col style="width: 20%" />
					<col style="width: 20%" />
				</colgroup>
				<tr>
					<th></th>
					<th>세탁소</th>
					<th>품목</th>
					<th>가격</th>
				</tr>

				<c:forEach var="cart" items="${cartpay}">
					<tr>
						<td class="product-close"><input type="checkbox"
							name="chkbox" onClick="itemSum()" class="chkbox"
							value="${cart.pay_cart}" /></td>
						<td>${cart.sname}</td>
						<c:set var="itemStr" value="${cart.items}" />
						<c:set var="itemStr" value="${fn:replace(itemStr, '!@#', ':')}" />
						<c:set var="itemStr" value="${fn:replace(itemStr, '$%^', ',')}" />
						<c:set var="itemStr"
							value="${fn:substring(itemStr, 0, fn:length(itemStr)-1)}" />
						<td class='item'>${itemStr}</td>
						<td>${cart.pay_cart}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="cart_seq" value="${cart.cart_seq}" /> 
			합계:<input type="text" class="total-cart-p" id="total_sum" name="pay_cart" value="" />

		</div>

		<div class="member">
			<h2>주문자 정보</h2>
			<input type="hidden" name="id" value="${finalPay.id}"/>
			주문하시는 분:<input type="text" id="orderName" name="name" value="${finalPay.name}" readonly  /><br>
			주소: <input type="text" id="sample6_postcode" placeholder="${finalPay.userZipCode}" name="userZipCode" value="${finalPay.userZipCode}">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="sample6_address" placeholder="주소" name="userFirstAddr" value="${finalPay.userFirstAddr}"><br>
				<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="userExtraAddr" value="${finalPay.userExtraAddr}"><br>
				<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="userSecondAddr" value="${finalPay.userSecondAddr}"><br>
			휴대전화:<input type="text" id="orderpnum" name="orderpnum" value="${finalPay.pnum}" /><br>
			 이메일:<input type="text" name="email" value="${finalPay.email}" /><br>



		</div>
		
		<div class="addr">
			<h2>배송지 정보</h2>
			<input id="useraddr"  fw-filter="" fw-label="1" fw-msg="" value="T" type="radio">
			<label >주문자 정보와 동일</label><br>
			받으시는 분:<input type="text" id="username" /><br>
			주소:<input type="text" id="postcode"><br>
				<input type="text" id="address" placeholder="주소" ><br>
				<input type="text" id="extraAddress" placeholder="참고항목" ><br>
				<input type="text" id="detailAddress" placeholder="상세주소"><br>
			휴대전화:<input type="text" id="userpnum" ><br>
				
		</div>

		<div class="bubble">
			<h2>포인트 사용</h2>
			버블사용:<input type="text" name="pp_bubble" id="paybubble" value="0" >원(사용가능 버블:<a>${finalPay.bubble}</a>)<br>
			버블충전:<input tyPe="radio" value="10000" name="b_price"/>10000버블 <input tyPe="radio" value="30000" name="b_price"/>30000버블 <input tyPe="radio" value="50000" name="b_price"/>50000버블
			<button type="button" id="bubbleBut">충전하기</button>
		</div>

		<div class="pricechk">
			<h2>결제 수단</h2>
			

		</div>

		<div class="price">
			<h2>최종 결제금액</h2>
			상품금액:<input type="text" id="pricepay" name="orderprice"  value="" />원<br>
			버블사용:<input type="text" id="ppp" name="p_bubble" value="0" />원<br>
			총 결제금액:<input type="text" id="finalprice" name="pay_price"  value=""readonly onkeyup="plus()"/>원
			
		
		</div>
		
		<div class="pricechk">
			<h2>결제 수단</h2>
			
	
		</div>
		<input type="submit" value="결제하기">			
	</form>
	<script>
		//들오오자마자 체크박스에 체크해주기
		var ck = "${cart}";
		if (ck == 'false') {
			$("#allCheck").prop("checked", false);
		} else {
			$("#allCheck").prop("checked", true);
			$(".chkbox").prop("checked", true);
			itemSum();
		}


</script>
</body>
</html>