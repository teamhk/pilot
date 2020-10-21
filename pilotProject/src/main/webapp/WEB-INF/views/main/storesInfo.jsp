<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.hk.pilot.dto.StoreInfo"%>
<%@ page import="com.hk.pilot.dto.Product"%>

<%@ page import="java.util.List"%>
<%
	List<Product> pro = (List<Product>) request.getAttribute("product");
%>
<%
	StoreInfo StoreInfo = (StoreInfo) request.getAttribute("storeInfo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<title>퀴클린24셀프빨래방 | 카카오맵</title>
<script type="text/javascript">



//팝업창 오픈하여 데이터 전송



function openPopup( ) {
	


// window.open("", popOpen, ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=650,height=550'] );



// productForm.target="popOpen";

productForm.action=" info";

console.log("서브밋 들어옴");
var itemlist = "";
var itemname = $('input[name="item"]');
var itemmimi = $('input[name="mimi"]');
console.log(itemname);
console.log(itemmimi);
for(var i=0;i<itemname.length;i++){
	itemlist += itemname.eq(i).val()+"!@#"+itemmimi.eq(i).val()+"$%^";
// 	if(itemmimi.eq(i).attr("id")==="input_cnt_셔츠"){
// 		itemmimi.eq(i).prop("name","Y1");
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_블라우스"){
// 		itemmimi.eq(i).prop("name","B1");
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_티셔츠"){
// 		itemmimi.eq(i).prop("name","T1");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_맨투맨"){
// 		itemmimi.eq(i).prop("name","M1");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_바지"){
// 		itemmimi.eq(i).prop("name","P1");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_니트"){
// 		itemmimi.eq(i).prop("name","K1");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_자켓"){
// 		itemmimi.eq(i).prop("name","J1");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_코트"){
// 		itemmimi.eq(i).prop("name","C1");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_패딩"){
// 		itemmimi.eq(i).prop("name","P2");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_이불"){
// 		itemmimi.eq(i).prop("name","D1");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_신발"){
// 		itemmimi.eq(i).prop("name","S1");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_커튼"){
// 		itemmimi.eq(i).prop("name","C2");	
// 	}else if(itemmimi.eq(i).attr("id")==="input_cnt_가방"){
// 		itemmimi.eq(i).prop("name","B2");	
// 	}

}
console.log(itemlist);

console.log("서브밋 중반");
$('#items').val(itemlist);
console.log("서브밋 후반");
console.log($('#items').val(itemlist));


//	if(prmtObj.goodsId==="셔츠"){
//	mimi="Y1";
//}else if(prmtObj.goodsId==="블라우스"){
//	mimi="B1";
//}else if(prmtObj.goodsId==="티셔츠"){
//	mimi="T1";
//}else if(prmtObj.goodsId==="맨투맨"){
//	mimi="M1";
//}else if(prmtObj.goodsId==="바지"){
//	mimi="P1";
//}else if(prmtObj.goodsId==="니트"){
//	mimi="K1";
//}else if(prmtObj.goodsId==="자켓"){
//	mimi="J1";
//}else if(prmtObj.goodsId==="코트"){
//	mimi="C1";
//}else if(prmtObj.goodsId==="패딩"){
//	mimi="P2";
//}else if(prmtObj.goodsId==="이불"){
//		mimi="D1";
//}else if(prmtObj.goodsId==="신발"){
//	mimi="S1";
//}else if(prmtObj.goodsId==="커튼"){
//	mimi="C2";
//}else if(prmtObj.goodsId==="가방"){
//	mimi="B2";
//}

productForm.submit();



}

function wrapWindowByMask() {
	//화면의 높이와 너비를 구한다.
	var maskHeight = $(document).height();
	var maskWidth = $(window).width();

	//문서영역의 크기 
	console.log("document 사이즈:" + $(document).width() + "*"
			+ $(document).height());
	//브라우저에서 문서가 보여지는 영역의 크기
	console.log("window 사이즈:" + $(window).width() + "*"
			+ $(window).height());

	//마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
	$('#mask').css({
		'width' : maskWidth,
		'height' : maskHeight
	});

	//애니메이션 효과
	//$('#mask').fadeIn(1000);      
	$('#mask').fadeTo("slow", 0.5);
}

function popupOpen() {
	$('.layerpop').css("position", "absolute");
	//영역 가운에데 레이어를 뛰우기 위해 위치 계산 
	$('.layerpop').css(
			"top",
			(($(window).height() - $('.layerpop').outerHeight()) / 2)
					+ $(window).scrollTop());
	$('.layerpop').css(
			"left",
			(($(window).width() - $('.layerpop').outerWidth()) / 2)
					+ $(window).scrollLeft());
	$('.layerpop').draggable();
	$('#layerbox').show();
}

function popupClose() {
	$('#layerbox').hide();
	$('#mask').hide();
	
	
}

function goDetail() {

	/*팝업 오픈전 별도의 작업이 있을경우 구현*/

	popupOpen(); //레이어 팝업창 오픈 
	wrapWindowByMask(); //화면 마스크 효과 
}

$(document).ready(function() {
	var formObj = $("form[name='reviewForm']");
	$(".write_btn").on("click", function() {
		if (fn_valiChk()) {
			return false;
		}
		alert("문의글 작성이 완료되었습니다.");
		formObj.attr("action", "/");
		formObj.attr("method", "post");
		formObj.submit();
	});

})

</script>
<meta property="og:title" content="퀴클린24셀프빨래방">
<meta property="og:site_name" content="카카오맵">
<meta property="og:description" content="서울 은평구 은평로12길 7-10 (응암동 97-28)">
<meta property="og:type" content="website">
<meta property="og:image"
	content="http://map3.daum.net/staticmap/og?type=place&amp;srs=wcongnamul&amp;size=400x200&amp;m=483596%2C1139090">
<meta property="og:url" content="https://place.map.kakao.com/892584709">
<meta name="twitter:card" content="summary_large_image">
<meta name="twitter:title" content="퀴클린24셀프빨래방">
<meta name="twitter:description"
	content="서울 은평구 은평로12길 7-10 (응암동 97-28)">
<meta name="twitter:image"
	content="http://map3.daum.net/staticmap/og?type=place&amp;srs=wcongnamul&amp;size=400x200&amp;m=483596%2C1139090">
<link
	href="//t1.daumcdn.net/localimg/localimages/07/common/kakaomap_favicon.ico"
	rel="shortcut icon">


<link rel="stylesheet" type="text/css"
	href="//t1.daumcdn.net/kakaomapweb/place/jscss/pc.efe78505.css">


<style type="text/css">/* global */
.screen_out {
	overflow: hidden;
	position: absolute;
	width: 0;
	height: 0;
	line-height: 0;
	text-indent: -9999px
}

.show {
	display: block
}

.hide {
	display: none
}

/* PC Social Share */
/* 2018-04-25 수정 시작 */
.social_comm_p {
	position: absolute;
	z-index: 1000;
}

.social_comm_p .img_social {
	display: block;
	overflow: hidden;
	font-size: 0;
	background:
		url(//t1.daumcdn.net/daumtop_deco/images/common/social/img_social_200414.png)
		no-repeat 0 0;
	text-indent: -9999px
}

.social_comm_p .sns_comm_p {
	overflow: hidden;
	position: relative;
	border: 1px solid #e2e2e2;
	font-size: 11px;
	color: #222;
	background-color: #fff;
	letter-spacing: -0.025em
}

.social_comm_p .btn_close {
	position: absolute;
	top: 5px;
	right: 5px;
	width: 24px;
	height: 24px
}

.social_comm_p .ico_close {
	width: 15px;
	height: 16px;
	margin: 5px;
	background-position: -150px 0
}

.social_comm_p .share_layer {
	position: relative;
	width: 260px;
	min-height: 228px
}

.social_comm_p .list_sns {
	overflow: hidden;
	margin: 26px 14px 0일단 바
}

.social_comm_p .list_sns li {
	float: left;
	width: 77px;
	height: 78px
}

.social_comm_p .list_sns .link_sns {
	display: block;
	text-align: center;
	text-decoration: none
}

.social_comm_p .list_sns .link_sns .img_social {
	width: 43px;
	height: 43px;
	margin: 0 auto 4px
}

.social_comm_p .list_sns .tit_sns {
	display: block;
	margin-top: 7px;
	font-weight: normal;
	line-height: 16px
}

.social_comm_p .list_sns .ico_sns_ks {
	background-position: -50px 0
}

.social_comm_p .list_sns .ico_sns_fb {
	background-position: -100px 0
}

.social_comm_p .list_sns .ico_sns_tw {
	background-position: 0 -50px
}

.social_comm_p .list_sns .ico_sns_cafe {
	background-position: -100px -50px
}

.social_comm_p .list_sns .ico_sns_mail {
	background-position: -50px -50px
}

.social_comm_p .list_sns .ico_sns_kt {
	background-position: 0 0
}

.social_comm_p .sns_copyurl {
	margin: -1px 26px 0;
	padding-bottom: 23px
}

.social_comm_p .sns_copyurl .link_copyurl {
	display: block;
	overflow: hidden;
	position: relative;
	height: 23px;
	line-height: 23px;
	border: 1px solid #d0d0d0;
	background-color: #f8f8f8;
	text-decoration: none
}

.social_comm_p .sns_copyurl .txt_url {
	display: block;
	overflow: hidden;
	padding: 0 64px 0 7px;
	color: #2695f8;
	white-space: nowrap;
	text-overflow: ellipsis
}

.social_comm_p .sns_copyurl .txt_copy {
	position: absolute;
	top: 0;
	right: 0;
	width: 47px;
	height: 25px;
	border-left: 1px solid #d0d0d0;
	background-color: #fff;
	text-align: center
}

.social_comm_p .copyurl_layer {
	width: 254px;
	height: 78px;
	text-align: center
}

.social_comm_p .inner_copyurl {
	display: table;
	width: 100%;
	height: 100%
}

.social_comm_p .inner_copyurl .desc_copyurl {
	display: table-cell;
	padding: 18px 0 17px;
	line-height: 19px;
	vertical-align: middle
}

.social_comm_p .sns_copyurl_type2 .tf_url {
	display: block;
	width: 210px;
	height: 25px;
	padding: 0 10px;
	border: 0 none;
	color: #2695f8;
	background-color: transparent
}

.social_comm_p .sns_copyurl_type2 .desc_tip {
	padding: 13px 0;
	line-height: 18px;
	color: #888;
	text-align: center;
	letter-spacing: 0
}

@media only screen and (-webkit-min-device-pixel-ratio: 1.5) , only screen and
		(min-device-pixel-ratio: 1.5) , only screen and (min-resolution:
		144dpi) , only screen and (min-resolution: 1.5dppx) {
	.social_comm_p .img_social {
		background-image:
			url(//t1.daumcdn.net/daumtop_deco/images/common/social/rtn/img_social_200414.png);
		background-size: 170px 100px
	}
}

/*-- POPUP common style S ======================================================================================================================== --*/
#mask {
	position: absolute;
	left: 0;
	top: 0;
	z-index: 999;
	background-color: #000000;
	display: none;
}

.layerpop {
	display: none;
	z-index: 1000;
	border: 2px solid #ccc;
	background: #fff;
	/* 	cursor: move; */
}

.layerpop_area .title {
	padding: 10px 10px 10px 10px;
	border: 0px solid #aaaaaa;
	background: #f1f1f1;
	color: red;
	font-size: 1.3em;
	font-weight: bold;
	line-height: 24px;
}

.layerpop_area .layerpop_close {
	width: 25px;
	height: 25px;
	display: block;
	position: absolute;
	top: 10px;
	right: 10px;
	background: transparent url('/resources/images/btn_exit_off.png') no-repeat;
}

}
.layerpop_area .layerpop_close:hover {
	background: transparent url('/resources/images/btn_exit_on.png') no-repeat;
	cursor: pointer;
}

}
.layerpop_area .content {
	width: 96%;
	margin: 2%;
	color: #828282;
}

.starcolor {
	color: red;
}

</style>




</head>

<body>
	<div id="kakaoIndex">
		<a href="#kakaoBody">본문 바로가기</a> <a href="#kakaoGnb">메뉴 바로가기</a>
	</div>
	<div id="kakaoWrap" class="wrap_mapdetail">
		<div data-viewid="header" id="kakaoHead" class="head_mapdetail"
			role="banner">

			<h1 class="logo_daum">
				<a href="http://daum.net" id="kakaoLogo" data-logtarget
					data-logevent="daum_top" target="_blank"><img
					src="//t1.daumcdn.net/localimg/localimages/07/2017/pc/rtn/logo_daum.png"
					width="44" height="18" class="img_logo" alt="다음"></a> <a
					href="https://map.kakao.com" id="kakaoServiceLogo" data-logtarget
					data-logevent="map_top" target="_blank"> <img
					src="//t1.daumcdn.net/localimg/localimages/07/2017/pc/rtn/logo_service.png"
					width="39" height="20" class="img_logo" alt="지도">
				</a>
			</h1>

			<h1 class="logo_daum">
				2018-07-23 수정 <a href="https://map.kakao.com" id="#kakaoMapLogo"
					data-logtarget="" data-logevent="map_top" target="_blank"><img
					src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/logo_kakaomap.png"
					width="121" height="25" class="img_logo" alt="카카오맵"
					id="exifviewer-img-1" exifid="1656209132"
					oldsrc="http://t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/logo_kakaomap.png">
				</a>
			</h1>
			<div data-viewid="header" data-root="" class="search_map">
				<h2 class="screen_out">검색</h2>
				<form id="searchForm" method="GET">
					<fieldset>
						<legend class="screen_out">검색어 입력 폼</legend>
						<label for="searchKeyword" class="lab_search">카카오맵 지도 검색</label> <input
							type="text" name="q" id="searchKeyword" class="tf_search"
							autocomplete="off" spellcheck="false">
						<button type="submit" id="kakaoBtnSearch" class="btn_search">
							<span class="ico_comm ico_search">검색</span>
						</button>
					</fieldset>
					<blockquote id="searchKeywordSuggest" class="wrapper">
						<div class="suggestBox box_sub" style="display: none;">
							<div class="baseBox bg">
								<div class="list">
									<ul class="suggest_list_target"></ul>
								</div>
							</div>
							<div class="favorite_find"></div>
							<div class="search_recent"></div>
						</div>
						<div class="suggestBox box_sub">
							<div class="baseBox bg">
								<div class="list">
									<ul class="suggest_list_target"></ul>
								</div>
							</div>
							<div class="favorite_find"></div>
							<div class="search_recent"></div>
						</div>
					</blockquote>
				</form>
			</div>

			<div id="kakaoGnb" data-viewid="navBar" data-root=""
				class="location_bar" role="navigation">
				스크롤 내려 왔을 때 location_bar_on 추가
				<div class="inner_bar">
					<div class="outer_header_share_container">
						<div id="header_share_container"
							class="inner_header_share_container">
							<div class="social_comm_p hide">
								<div class="sns_comm_p share_layer">
									<strong class="screen_out">SNS로 공유하기 펼쳐짐</strong>
									<ul class="list_sns">
										<li><a href="#none" class="link_sns"
											data-handler="kakaotalk"> <span
												class="img_social ico_sns_kt"> </span>카카오톡
										</a></li>
										<li><a href="#none" class="link_sns"
											data-handler="kakaostory"> <span
												class="img_social ico_sns_ks"> </span>카카오스토리
										</a></li>
										<li><a href="#none" class="link_sns"
											data-handler="facebook"> <span
												class="img_social ico_sns_fb"> </span>페이스북
										</a></li>
										<li><a href="#none" class="link_sns"
											data-handler="twitter"> <span
												class="img_social ico_sns_tw"> </span>트위터
										</a></li>
										<li><a href="#none" class="link_sns" data-handler="mail">
												<span class="img_social ico_sns_mail"> </span>다음메일
										</a></li>
										<li><a href="#none" class="link_sns"
											data-handler="daumcafe"> <span
												class="img_social ico_sns_cafe"> </span>다음카페
										</a></li>
									</ul>
									<div class="copyUrl">
										<div class="sns_copyurl">
											<a href="#none" class="link_copyurl"> <span
												class="screen_out">현재페이지 URL복사</span> <span class="txt_url">https://place.map.kakao.com/892584709</span>
												<span class="txt_copy">URL복사</span>
											</a>
										</div>
									</div>
									<button class="btn_close">
										<span class="img_social ico_close">공유목록 닫기</span>
									</button>
								</div>
								<div class="sns_comm_p copyurl_layer hide">
									<div class="inner_copyurl">
										<p class="desc_copyurl">
											주소가 복사되었습니다.<br>원하는곳에 붙여넣기(Ctrl+V)해주세요.
										</p>
										<button class="btn_close">
											<span class="img_social ico_close">공유목록 닫기</span>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<h2 class="tit_location" aria-hidden="true" data-logtarget=""
						data-logevent="name_bar,name">퀴클린24셀프빨래방</h2>
					<strong class="screen_out">상세정보 퀵메뉴</strong>
					<ul class="list_lnb">
						<li><a
							href="https://map.kakao.com?urlX=483596&amp;urlY=1139090&amp;urlLevel=3&amp;itemId=892584709&amp;q=%ED%80%B4%ED%81%B4%EB%A6%B024%EC%85%80%ED%94%84%EB%B9%A8%EB%9E%98%EB%B0%A9&amp;srcid=892584709&amp;map_type=TYPE_MAP"
							target="_blank" class="link_lnb" data-logtarget=""
							data-logevent="name_bar,map"> <span class="ico_comm ico_map">지도</span>
								2018-11-28 추가 : 텍스트 감싸는 .ico_comm.ico_map 요소 추가
						</a></li> 2018-11-28 추가 : 로드뷰, 즐겨찾기 위치이동으로 인한 추가
						<li><a
							href="https://map.kakao.com?srcid=892584709&amp;confirmid=892584709&amp;q=%ED%80%B4%ED%81%B4%EB%A6%B024%EC%85%80%ED%94%84%EB%B9%A8%EB%9E%98%EB%B0%A9&amp;rv=on"
							target="_blank" class="link_lnb" data-roadview=""
							data-logtarget="" data-logevent="name_bar,roadview"> <span
								class="ico_comm ico_roadview">로드뷰</span> 2018-11-28 추가 : 텍스트 감싸는
								.ico_comm.ico_roadview 요소 추가
						</a></li>
						<li>2018-11-28 즐겨찾기 메뉴의 lst클래스 삭제 <a href="#none"
							class="link_lnb link_bookmark " data-fid="" data-link="fav"
							data-logtarget="" data-logevent="name_bar,favorite"> <span
								class="ico_comm ico_bookmark">즐겨찾기 추가</span> <span
								class="ico_num ico_num"><span class="screen_out">나의
										즐겨찾기 폴더 개수</span></span>
						</a>
						</li>
						<li data-share=""><a href="#none" target="_blank"
							class="link_lnb" data-link="share"> <span
								class="ico_comm ico_share">공유하기</span>
						</a></li> // 2018-11-28 추가 : 공유하기 버튼 추가
						<li><a
							href="https://map.kakao.com?map_type=TYPE_MAP&amp;target=car&amp;rt=,,483596,1139090&amp;rt1=&amp;rt2=%ED%80%B4%ED%81%B4%EB%A6%B024%EC%85%80%ED%94%84%EB%B9%A8%EB%9E%98%EB%B0%A9&amp;rtIds=,892584709"
							target="_blank" class="link_lnb" data-logtarget=""
							data-logevent="name_bar,route"> <span
								class="ico_comm ico_route">길찾기</span> 2018-11-28 추가 : 텍스트 감싸는
								.ico_comm.ico_route 요소 추가
						</a></li>
					</ul>
				</div>
			</div>
			<div data-viewid="headerProfile" data-root="">
				<a href="https://map.kakao.com/user/signup" target="_top"
					class="btn_login">시작하기</a>
			</div>

		</div>
		<hr class="hide">
		<div data-viewid="nativeAdvertisement"
			adfit-unit-id="DAN-1h8210bp60zzq" data-root=""
			style="position: absolute; top: 354px; left: 50%; margin-left: -555px;"
			adfit-init="true" adfit-unit-idx="0">
			<strong
				style="overflow: hidden; position: absolute; width: 0; height: 0; line-height: 0; text-indent: -9999px">광고</strong>
			<a
				href="https://analytics.ad.daum.net/clk?wa=kYrDZmAs_17qld0MtxcOTw&amp;enc=ZpRCYkW-dpMXSnvMo4DsErYV17s_vfccVRVMfJL6IgC3j_TT7-tcnNSzi7bYsgg5SimxpP2PQY2bjNLrJNC12nCBNR0Z2Eqc1f3lBSyWj9Usw6tT7BSNzqjh5DUZudILd_VpJtv_NSbwzVV47yV3QVblWKD017_2TiW9lNRziZXjpbHoTt6oYGLW65TTpUf5dAWeXiMjbe9RcsG_dBH8EkK_6_O0qhDpsJQul1RcreM8XZ74MscbFzFQPCpnrqoc7L0DYCStMGjhnZVAMMMXcRUnvQi7i53kpcNZ3fnymceY3I-fJwXZT35A3IZJBzamA-FQjF1qrugLbakRV1s17PjElbzWG69pzlwQ6VtmpdUgt9gDnpIuSuYhdOQLsSI4is5lujWv2_1L5ag9SkQ38rSQILaGyv34ewtFLSsuBCEqFOpjYBgZWU6a3BllPI3zbE7LaWKJFEskkd9IkXG7EEKvhKxGjHvYR2Eznw0lfku0-qbBlMsBKqu01yqGva3rn8pJrOqMTIPd1RLxQx5SvbS3iGZX5sLWpNNbRfQt_i0lNbwIWt2PIqTPawzfkuzBteQEALpLgO_GFSvNGl2mQhpjpwjGOKMtG7RQs234uT7csY_baLIdF0Oqk2svdgj9aFg8RI--ZMJjKTjGGqJcT6N9mb4qEqvFwU-kA_mic5ZA0dQtnVVwM9PAFfavBK2Z&amp;lc=1"
				target="_blank" style="display: block" adfit-landing-url=""> <span
				style="display: block; overflow: hidden; position: relative">
					<img width="125" height="94" adfit-image-width="125"
					adfit-image-height="94" adfit-main-img-url=""
					style="display: block; border-radius: 4px"
					alt="암 투병 하며 쌍둥이를 돌보는 엄마"
					src="https://img1.daumcdn.net/thumb/S250x187/?scode=b2_01&amp;x-twg-thumb-fname=http%3A%2F%2Ft1.daumcdn.net%2Fb2%2Fcreative%2F51957%2Fa72797fc8570cdb8e75138ccf48ad592.jpg&amp;TWGServiceId=b2&amp;Expires=1601816400&amp;Signature=zy4LOEmuej96Tys0Wyd7QqYPBLY%3D"
					adfit-action-type="mainImage"> <img adfit-ad-info-icon=""
					src="https://t1.daumcdn.net/b2/templates/image/opt_out_30.png"
					width="24" height="16"
					style="position: absolute; top: 4px; right: 4px; cursor: pointer; pointer-events: auto;"
					alt="암 투병 하며 쌍둥이를 돌보는 엄마" adfit-action-type="adInfoIcon">
			</span> <strong class="tit_item" adfit-title=""
				style="display: block; overflow: hidden; width: 125px; max-height: 38px; padding-top: 6px; font-weight: normal; font-size: 13px; line-height: 18px; color: #555; font-family: AppleSDGothicNeo-Regular, 'Malgun Gothic', '맑은 고딕', dotum, '돋움', sans-serif; text-align: center"
				adfit-action-type="title">암 투병 하며 쌍둥이를 돌보는 엄마</strong>
			</a>
		</div>
		<div id="kakaoContent" role="main" class="cont_mapdetail">
			<div class="dimmed_layer hide"></div>
			<div id="mArticle">
				<div data-viewid="basicInfo" class="cont_essential">
					<div data-viewid="basicInfoTop" data-root="">
						<div class="details_present" style="background: none;">
							<a href="#none" class="link_present" data-logtarget=""
								data-logevent="info_pannel,main_pic"> <span
								class="bg_present"
								style="background-image: url('//img1.daumcdn.net/thumb/T800x0.q70/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocalfiy%2F2D6916B41D7C492EB7A93CEFC2F357AA')"></span>
								<span class="frame_g"></span>
							</a>
						</div>
						<div class="place_details">
							<div class="inner_place">
								<span class="color_g txt_elocation">quicklean</span>
								<h2 class="tit_location">퀴클린24셀프빨래방</h2>
								<div class="location_evaluation">
									<span class="txt_location"><span class="screen_out">분류:
									</span>셀프빨래방</span> <span class="ico_comm ico_dot"></span> <a href="#none"
										class="link_evaluation" data-cnt="3" data-target="comment"
										data-logtarget="" data-logevent="info_pannel,point">평점 <span
										class="color_b">5.0<span class="screen_out">점</span></span> <span
										class="color_g">(3)<span class="screen_out">명 평가</span></span>
									</a> <span class="ico_comm ico_dot"></span> <a href="#none"
										class="link_evaluation" data-cnt="0" data-target="review"
										data-logtarget="" data-logevent="info_pannel,review"> 리뷰 <span
										class="color_b inactive">0<span class="screen_out">개</span></span>
									</a>
								</div>
								<strong class="screen_out">위치 정보 및 공유하기</strong>
								<ul class="list_place">
									<li><a
										href="https://map.kakao.com?urlX=483596&amp;urlY=1139090&amp;urlLevel=3&amp;itemId=892584709&amp;q=%ED%80%B4%ED%81%B4%EB%A6%B024%EC%85%80%ED%94%84%EB%B9%A8%EB%9E%98%EB%B0%A9&amp;srcid=892584709&amp;map_type=TYPE_MAP"
										target="_blank" class="link_place" data-logtarget=""
										data-logevent="info_pannel,map_view"><span
											class="ico_comm ico_storemap"></span>지도</a></li>
									<li><a
										href="https://map.kakao.com?map_type=TYPE_MAP&amp;target=car&amp;rt=,,483596,1139090&amp;rt1=&amp;rt2=%ED%80%B4%ED%81%B4%EB%A6%B024%EC%85%80%ED%94%84%EB%B9%A8%EB%9E%98%EB%B0%A9&amp;rtIds=,892584709"
										target="_blank" class="link_place" data-logtarget=""
										data-logevent="info_pannel,route"><span
											class="ico_comm ico_route"></span>길찾기</a></li>
									<li><a
										href="https://map.kakao.com?srcid=892584709&amp;confirmid=892584709&amp;q=%ED%80%B4%ED%81%B4%EB%A6%B024%EC%85%80%ED%94%84%EB%B9%A8%EB%9E%98%EB%B0%A9&amp;rv=on"
										class="link_place" target="_blank" data-logtarget=""
										data-logevent="info_pannel,roadview" data-roadview=""><span
											class="ico_comm ico_roadmap"></span>로드뷰</a></li>
									<li class="lst"><a href="#none" class="link_place"
										data-logevent="info_pannel,share"><span
											class="ico_comm ico_share"></span>공유하기</a>
										<div data-viewid="snsShare" data-root="" class="detail_share">
										</div>
										<div class="place_share_container" id="place_share_container">
											<div class="social_comm_p hide">
												<div class="sns_comm_p share_layer">
													<strong class="screen_out">SNS로 공유하기 펼쳐짐</strong>
													<ul class="list_sns">
														<li><a href="#none" class="link_sns"
															data-handler="kakaotalk"> <span
																class="img_social ico_sns_kt"> </span>카카오톡
														</a></li>
														<li><a href="#none" class="link_sns"
															data-handler="kakaostory"> <span
																class="img_social ico_sns_ks"> </span>카카오스토리
														</a></li>
														<li><a href="#none" class="link_sns"
															data-handler="facebook"> <span
																class="img_social ico_sns_fb"> </span>페이스북
														</a></li>
														<li><a href="#none" class="link_sns"
															data-handler="twitter"> <span
																class="img_social ico_sns_tw"> </span>트위터
														</a></li>
														<li><a href="#none" class="link_sns"
															data-handler="mail"> <span
																class="img_social ico_sns_mail"> </span>다음메일
														</a></li>
														<li><a href="#none" class="link_sns"
															data-handler="daumcafe"> <span
																class="img_social ico_sns_cafe"> </span>다음카페
														</a></li>
													</ul>
													<div class="copyUrl">
														<div class="sns_copyurl">
															<a href="#none" class="link_copyurl"> <span
																class="screen_out">현재페이지 URL복사</span> <span
																class="txt_url">https://place.map.kakao.com/892584709</span>
																<span class="txt_copy">URL복사</span>
															</a>
														</div>
													</div>
													<button class="btn_close">
														<span class="img_social ico_close">공유목록 닫기</span>
													</button>
												</div>
												<div class="sns_comm_p copyurl_layer hide">
													<div class="inner_copyurl">
														<p class="desc_copyurl">
															주소가 복사되었습니다.<br>원하는곳에 붙여넣기(Ctrl+V)해주세요.
														</p>
														<button class="btn_close">
															<span class="img_social ico_close">공유목록 닫기</span>
														</button>
													</div>
												</div>
											</div>
										</div></li>
								</ul>

								<a href="#none" class="link_bookmark " data-fid=""
									data-logtarget="" data-logevent="info_pannel,favorite"> <span
									class="ico_comm ico_bookmark">즐겨찾기 추가</span> <span
									class="ico_num ico_num"><span class="screen_out">나의
											즐겨찾기 폴더 개수</span></span>
								</a>

							</div>
						</div>
						<div class="details_rest">
							<strong class="screen_out">기타 메뉴</strong>
							<ul class="list_rest">
								<li><a href="#none" class="link_rest" data-type="print"
									data-logtarget="" data-logevent="right_etc,print"> <span
										class="ico_comm ico_print">프린트하기</span>
								</a></li>
								<li><a href="#none" class="link_rest" data-type="roughmap"
									data-logtarget="" data-logevent="right_etc,simplemap"> <span
										class="ico_comm ico_makemap">약도 만들기</span>
								</a></li>
							</ul>
						</div>
					</div>
					<div data-viewid="basicInfo" data-root="" class="details_placeinfo">
						<h3 class="tit_subject">상세정보</h3>
						<div class="placeinfo_default">
							<h4 class="tit_detail">
								<span class="ico_comm ico_address">위치</span>
							</h4>
							<div class="location_detail">
								<span class="txt_address">서울 은평구 은평로12길 7-10 (우)03462</span> <span
									class="txt_addrnum">지번<span class="bg_bar"></span>응암동
									97-28
								</span>
							</div>
						</div>
						<div class="placeinfo_default">
							<h4 class="tit_detail">
								<span class="ico_comm ico_operation">운영시간 안내</span>
							</h4>
							<div class="location_detail openhour_wrap">
								btn_more 클릭 했을 때 open_on 추가
								<div class="location_present">
									<strong class="tit_operation fst">영업시간 <span
										class="open">영업중</span>
									</strong>

									<ul class="list_operation">
										<li><span class="txt_operation">매일 <span
												class="time_operation">00:00 ~ 24:00</span>

										</span></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="placeinfo_default placeinfo_facility">
							<h4 class="tit_facility">
								<span class="ico_comm ico_installation"></span>시설정보
							</h4>
							<ul class="list_facility">
								<li><span class="ico_comm ico_wifi"></span> <span
									class="color_g">WIFI</span></li>
								<li><span class="ico_comm ico_parking"></span> <span
									class="color_g">주차</span></li>
							</ul>



							<select id="selGoods" name="selGoods" style="height: 40px;">
								<option value=''>-[필수] 옵션을 선택해 주세요 -</option>
								<c:set var="num" value="1" />
								<c:forEach var="item" items="${items}" varStatus="status">
									<option id="${item}" value="${item}">${item}</option>
									<c:set var="num" value="${num + 1}" />
								</c:forEach>
							</select>


							<!-- </select> -->
							<form name='productForm' method="post">
								<div id="container" name="addCart">
									<input type="hidden" value="${storeInfo.snum}" name="snum">
									<input type="hidden" value="${storeInfo.sname}" name="sname">
									<input type="hidden" id="items" value="" name="items">
									<input type="hidden" value='N' name="choice"> <input
										type="hidden" value='N' name="c_check">

								</div>




								총금액:<input id="goodsTotAmt" name="pay_cart" value="0"> <input
									type='button' value='장바구니담기' onclick="openPopup()" /> <input
									type='submit' value='구매하기' onclick="cart" />
							</form>
							<!-- //<input type='button' value='장바구니담기' onclick='location.href="cart"'/> -->
							<c:forEach var="ppp" items='${product }'>
								<input type='hidden' value='${ppp.pname}' name='pname'>
								<input type='hidden' value='${ppp.pprice}' name='pprice'>
							</c:forEach>
							<script>



function Goods(){

	//json 배열[{goodsId:goodsId, goodsNm:goodsNm, amt:amt},{...},{...}]
	this.arrAllGoods = new Array();//상품 목록
	this.arrSelGoods = new Array();//선택한 상품 목록
	
var p = this;
	
	//상품 추가 시
this.select = function (trgtGoodsId){
	
	var selectedIndex = -1;//이미 추가했는지 0이면 추가할걸로 뜬다	
	
	//전체 목록 배열에서 검색하여 goodsId가 없다면 선택 목록에 push후 container안에 그려준다.
	
	//선택 목록에서 검색
for(var i=0;i<p.arrSelGoods.length;i++){
		
		if(p.arrSelGoods[i].goodsId==trgtGoodsId){
			selectedIndex = i;
			break;
		}
	}
	
	if(selectedIndex<0){//선택목록에 없을 경우 추가. 잇을경우 얼럿.
		//전체목록에서 선택 추가해줌.
		for(var j=0;j<p.arrAllGoods.length;j++){
			
			if(p.arrAllGoods[j].goodsId==trgtGoodsId){
				p.arrSelGoods.push(p.arrAllGoods[j]);
				p.arrSelGoods[p.arrSelGoods.length-1].cnt = 1;//무조건 개수 초기화
				p.appendChoiceDiv(p.arrAllGoods[j]);
				break;
			}
		}
	}else{
		alert("이미 추가한 상품입니다.");
	}
	p.afterProc();
}

//상품 제거 시
this.deselect = function (trgtGoodsId){
	
	var selectedIndex = -1;
	
	//배열에서 검색.
	for(var i=0;i<p.arrSelGoods.length;i++){
				
				if(p.arrSelGoods[i].goodsId==trgtGoodsId){
					p.removeChoiceDiv(p.arrSelGoods[i]);
					p.arrSelGoods.splice(i,1);
					break;
				}
			}
			p.afterProc();
		}
		
	this.appendChoiceDiv = function(prmtObj){
			var mimi="";
// 			if(prmtObj.goodsId==="셔츠"){
// 					mimi="Y1";
// 				}else if(prmtObj.goodsId==="블라우스"){
// 					mimi="B1";
// 				}else if(prmtObj.goodsId==="티셔츠"){
// 					mimi="T1";
// 				}else if(prmtObj.goodsId==="맨투맨"){
// 					mimi="M1";
// 				}else if(prmtObj.goodsId==="바지"){
// 					mimi="P1";
// 				}else if(prmtObj.goodsId==="니트"){
// 					mimi="K1";
// 				}else if(prmtObj.goodsId==="자켓"){
// 					mimi="J1";
// 				}else if(prmtObj.goodsId==="코트"){
// 					mimi="C1";
// 				}else if(prmtObj.goodsId==="패딩"){
// 					mimi="P2";
// 				}else if(prmtObj.goodsId==="이불"){
// 						mimi="D1";
// 				}else if(prmtObj.goodsId==="신발"){
// 					mimi="S1";
// 				}else if(prmtObj.goodsId==="커튼"){
// 					mimi="C2";
// 				}else if(prmtObj.goodsId==="가방"){
// 					mimi="B2";
// 				}

			
			
			var innerHtml = "";
			
			innerHtml += '<div id="div_'+prmtObj.goodsId+'">';			
			innerHtml += '<ul>';
			innerHtml += '	<li><input type="hidden" value='+prmtObj.goodsId+' name="item"/>'+prmtObj.goodsId+'</li>';
			innerHtml += '	<li>'+prmtObj.goodsprc+'원</li>';
			innerHtml += '	<li><button type="button" id="" class="add" name="" onclick="goods.minus(\''+prmtObj.goodsId+'\');">-</button></li>';
			innerHtml += '	<li><button type="button" id="" class="remove" name="" onclick="goods.plus(\''+prmtObj.goodsId+'\');">+</button></li>';
			innerHtml += '	<li>개수:<input type="text" id="input_cnt_'+prmtObj.goodsId+'" name="mimi" value="0"/>'
			
			innerHtml += '	<li>가격:<input type="text" id="input_sumAmt_'+prmtObj.goodsId+'" name="" value="0"/>'
			innerHtml += '	<li><button type="button" id="" class="remove" name="" onclick="goods.deselect(\''+prmtObj.goodsId+'\');">제거</button></li>';
			innerHtml += '</ul>';
			innerHtml += '</div>';		
			$('#container').append(innerHtml);
			
		}
		
		this.removeChoiceDiv = function(prmtObj){
			$("#div_"+prmtObj.goodsId).remove();
		}
		
		this.plus = function (trgtGoodsId){
			
			for(var i=0;i<p.arrSelGoods.length;i++){
					
					if(p.arrSelGoods[i].goodsId==trgtGoodsId){
						p.arrSelGoods[i].cnt++;
						break;
					}
			}
			
			
			p.afterProc();			
		}
		
		this.minus = function (trgtGoodsId){
			
			for(var i=0;i<p.arrSelGoods.length;i++){
					
					if(p.arrSelGoods[i].goodsId==trgtGoodsId){
						if(p.arrSelGoods[i].cnt==1) break;
						p.arrSelGoods[i].cnt--;
						break;
					}
			}
			
			p.afterProc();			
		}
		
		//계산 후처리.
		this.afterProc = function (){
			
			for(var i=0;i<p.arrSelGoods.length;i++){
				$('#input_cnt_'+p.arrSelGoods[i].goodsId).val(p.arrSelGoods[i].cnt);
				$('#input_sumAmt_'+p.arrSelGoods[i].goodsId).val(p.arrSelGoods[i].cnt*p.arrSelGoods[i].goodsprc);
			}
			
			var goodsTotAmt = 0;
			for(var i=0;i<p.arrSelGoods.length;i++){
				goodsTotAmt += p.arrSelGoods[i].cnt*p.arrSelGoods[i].goodsprc;
			}
			$('#goodsTotAmt').val(goodsTotAmt);
			
		}

	}
				
	var goods = new Goods();


	
	
	//${product};
// 	for(Product pro : ${product}){
<%-- 		<%for(Product ppp : pro){%> --%>
<%-- 		Product abc = <%=pro%>.shift(); --%>
// 		console.log(abc);
<%-- 	<%}%> --%>
// 	goods.arrAllGoods.push({goodsId:"셔츠",goodsprc:"1500",goodsNm:"셔츠",cnt:0});
	
// 	List<Product> product = $("#product").val();
// 	for(var i=0;i<product.length;i++){
// 	var pname = new Array(); 
// 	var pprice = new Array();
		for(var i=0;i<$('input[name="pname"]').length;i++){
// 			pname.push($('input[name="pname"]').eq(i).val());
// 			pprice.push($('input[name="pprice"]').eq(i).val());
    		goods.arrAllGoods.push({goodsId:$('input[name="pname"]').eq(i).val(),goodsprc:$('input[name="pprice"]').eq(i).val(),goodsNm:$('input[name="pname"]').eq(i).val(),cnt:0});  
			
		}
// 		console.log(pname);
// 		console.log(pprice);
		
// 	}
	
// 	goods.arrAllGoods.push({goodsId:"셔츠",goodsprc:"1500",goodsNm:"셔츠",cnt:0});
//     goods.arrAllGoods.push({goodsId:"블라우스",goodsprc:"2000",goodsNm:"블라우스",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"티셔츠",goodsprc:"2000",goodsNm:"티셔츠",cnt:0});  
// 	goods.arrAllGoods.push({goodsId:"맨투맨",goodsprc:"2000",goodsNm:"맨투맨",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"바지",goodsprc:"2000",goodsNm:"바지",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"니트",goodsprc:"2000",goodsNm:"니트",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"자켓",goodsprc:"2000",goodsNm:"자켓",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"코트",goodsprc:"2000",goodsNm:"코트",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"패딩",goodsprc:"2000",goodsNm:"패딩",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"이불",goodsprc:"2000",goodsNm:"이불",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"신발",goodsprc:"2000",goodsNm:"신발",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"커튼",goodsprc:"2000",goodsNm:"커튼",cnt:0});
// 	goods.arrAllGoods.push({goodsId:"가방",goodsprc:"2000",goodsNm:"가방",cnt:0});

	 

	$(function(){

		$('#selGoods').change('click',function(){
			
			//alert(this.value);
 			goods.select($('#selGoods option:selected').val());

		}); 

	});	
</script>



						</div>
						<span class="info_revise">업데이트 <span class="date_revise">2019.03.14.</span>
							<span class="bg_bar">|</span> <a href="#" class="link_fiy"
							data-fiytype="detail" data-logtarget=""
							data-logevent="main_info,FIY">틀린정보 신고</a></span>
					</div>
				</div>
				<div data-viewid="photoSection" data-root=""
					class="cont_photo no_category">
					<div class="particular_head">
						<h3 class="tit_subject">사진</h3>

						<div class="wrap_btn">
							<a href="#none" class="link_enroll" data-fiytype="photo"
								data-logtarget="" data-logevent="photo,add"> <span
								class="ico_comm ico_photo"></span>사진등록
							</a>
						</div>
					</div>
					<div class="photo_area">
						<ul class="list_photo">
							<li class="">사진 2장 부터 클래스 size_l 추가 <a href="#none"
								class="link_photo" data-pidx="0"
								style="background-image: url('//img1.daumcdn.net/thumb/C640x320.q70/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocalfiy%2F2D6916B41D7C492EB7A93CEFC2F357AA')"
								data-logtarget="" data-logevent="photo,photo_view"> <span
									class="frame_g"></span>
							</a>
							</li>
						</ul>

					</div>
					<br>



					<section id="container">
						<h4 class="review">리뷰</h4>
						<form role="form" method="get">
							<table>
								<tr>
									<th>리뷰번호</th>
									<th>내용</th>
									<th>작성자</th>
									<th>등록일</th>
									<th>별점</th>
								</tr>

								<c:forEach items="${reviewList}" var="reviewList">

									<c:set var="star0" value="${reviewList.star}" />
									<c:choose>
										<c:when test="${star0 eq '1' }">
											<c:set var="star1" value="${fn:replace(star0, '1', '★' ) }" />
										</c:when>

										<c:when test="${star0 eq '2' }">
											<c:set var="star1" value="${fn:replace(star0, '2', '★★')  }" />
										</c:when>


										<c:when test="${star0 eq '3' }">
											<c:set var="star1" value="${fn:replace(star0, '3', '★★★' ) }" />
										</c:when>


										<c:when test="${star0 eq '4' }">
											<c:set var="star1"
												value="${fn:replace(star0, '4', '★★★★')  }" />
										</c:when>


										<c:when test="${star0 eq '5' }">

											<c:set var="star1"
												value="${fn:replace(star0, '5', '★★★★★')  }" />
										</c:when>


									</c:choose>


									<tr>
										<td><c:out value="${reviewList.r_no}" /></td>
										<td><c:out value="${reviewList.r_content}" /></td>
										<td><c:out value="${reviewList.w_id}" /></td>
										<td><fmt:formatDate value="${reviewList.r_date}"
												pattern="yyyy-MM-dd" /></td>
										<td class="starcolor"><c:out value="${star1}" /></td>
									</tr>
								</c:forEach>

							</table>
						</form>
					</section>

				</div>


				<!-- 선택 되었을 때 클래스 agree_chacked ->
                <input id="mapChoice2" class="inp_choice" type="checkbox" checked="checked">
                <label for="mapChoice2" class="lab_agree">
                    <span class="ico_comm ico_choice"></span><!-- 선택 되었을 때 클래스 ico_focused 추가 ->
                    작성된 평점 및 평가글이 카카오맵에 노출됩니다.
                </label>
            </span>
           
            <span class="num_letter txt_len_warp"><span class="screen_out">등록한 글자수: </span><span class="txt_len">0</span><span class="num_total"> / 2000</span></span>
            <button type="submit" class="btn_enroll">등록</button>
        </div>
    </div>
    <div class="evaluation_sorting">
        <strong class="screen_out">서비스별 평가 선택상자</strong>
        <em class="screen_out">선택내용 :</em>
        <a href="#none" class="tit_subject">전체 <span class="color_b">3</span><span class="ico_comm ico_arr"></span></a>
        <em class="screen_out">선택옵션</em>
        <ul class="list_opt">
            <li><a href="#none" data-platform="" class="link_option" data-logtarget="" data-logevent="point,dropdown,all">전체 3</a></li>
            <li><a href="#none" data-platform="kakaomap" class="link_option" data-logtarget="" data-logevent="point,dropdown,kakaomap">카카오맵 3</a></li>
        </ul>
    </div>
    <div class="ahead_info">
        <strong class="screen_out">평가 요약</strong>
        <div class="grade_star">
            <em class="num_rate">5.0<span class="txt_score">점</span></em>
        <span class="ico_star star_rate"><span class="ico_star inner_star" style="width:100%"></span></span>
        </div>
    </div>
    <div class="evaluation_review">
        <strong class="screen_out">평가 리스트</strong>
        <ul class="list_evaluation">
                <li data-id="453048" class="  " data-is-block="false">
                    2018-07-23 profile_info 추가 시작
                    <a href="javascript:void(0);" class="profile_info" data-ismy="false" data-userid="njl35l" data-username="민호식" data-platform="kakaomap" data-ori="http://th-p.talk.kakao.co.kr/th/talkp/wkIC17pEoF/W5mzOJGY8Ic1WIinnKFws0/g0200b.jpg">
                            <img src="//img1.daumcdn.net/thumb/C48x48.q80/?fname=http://th-p.talk.kakao.co.kr/th/talkp/wkIC17pEoF/W5mzOJGY8Ic1WIinnKFws0/g0200b.jpg" width="48" height="48" class="thumb_g" alt="">

                            <span class="ico_comm  "></span>
                    </a>
                    <div class="star_info">
                        <div class="grade_star size_s">
                            <span class="ico_star star_rate"><span class="ico_star inner_star" style="width:100%;"></span></span>
                            <em class="num_rate">5<span class="screen_out">점</span></em>
                        </div>
                    </div>
                    // 2018-07-23 profile_info 추가 끝

                    <div class="comment_info">
                                <p class="txt_comment "><span>주차가 편해서 좋아요. 기계도 새거라 깨끗하네요</span><button type="button" class="btn_fold">더보기</button></p>

                            <div class="append_item">
                                <a href="#none" class="link_like " data-logtarget="" data-logevent="point,list,good">
                                    like_on 클래스 추가시 아이콘 변경
                                    <span class="ico_comm ico_like"></span> 좋아요 <span class="num_g" style="display:none;">0</span>
                                </a>
                                <span class="bg_bar"></span>

                                            <em class="screen_out">작성자 : </em><a class="link_user" href="javascript:void(0);" data-ismy="false" data-userid="njl35l" data-username="민호식" data-platform="kakaomap" data-ori="http://th-p.talk.kakao.co.kr/th/talkp/wkIC17pEoF/W5mzOJGY8Ic1WIinnKFws0/g0200b.jpg">민호식</a>
                                            <span class="bg_bar"></span>

                                <em class="screen_out">작성일 : </em><span class="time_write">2019.03.18.</span>

                                    <span class="bg_bar"></span>
                                    <a href="javascript:void(0);" data-id="spamLink" data-commentid="453048" class="link_function" target="popup" data-platform="kakaomap" data-logtarget="" data-logevent="point,list,report">
                                        신고
                                    </a>

                            </div>
                    </div>

                </li>
                <li data-id="429207" class="  " data-is-block="false">
                    2018-07-23 profile_info 추가 시작
                    <a href="javascript:void(0);" class="profile_info" data-ismy="false" data-userid="utgeq6" data-username="크리스" data-platform="kakaomap" data-ori="http://t1.daumcdn.net/local/kakaomapPhoto/profile/7f31a897fa22b48122438aaaa53e695798a38f18?original">
                            <img src="//img1.daumcdn.net/thumb/C48x48.q80/?fname=http://t1.daumcdn.net/local/kakaomapPhoto/profile/7f31a897fa22b48122438aaaa53e695798a38f18?original" width="48" height="48" class="thumb_g" alt="">

                            <span class="ico_comm  "></span>
                    </a>
                    <div class="star_info">
                        <div class="grade_star size_s">
                            <span class="ico_star star_rate"><span class="ico_star inner_star" style="width:100%;"></span></span>
                            <em class="num_rate">5<span class="screen_out">점</span></em>
                        </div>
                    </div>
                    // 2018-07-23 profile_info 추가 끝
                        <a href="#none" data-basis="429207" data-type="kakaomapcomment" class="link_photo" data-logtarget="" data-logevent="point,list,image">
                            <img src="//img1.daumcdn.net/thumb/C80x80.q70/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F90246d5769fcaf6ef3b0e82609e80043895a1a4e%3Foriginal" width="78" height="78" class="img_profile" alt="포토뷰어">
                            <span class="frame_photo"></span>
                            <span class="mark_photo"><span class="screen_out">갯수 : </span>2</span>
                            <span class="frame_blind"></span>
                        </a>

                    <div class="comment_info">
                                <p class="txt_comment "><span>주차가 편하고 시설물들이 깨끗해요. 세탁과 건조 모두 기다리지 않고 편안하게 했어요.  매장도 청결하고 세탁은 깨끗, 건조는 뽀송뽀송하게 되어 강추합니다!</span><button type="button" class="btn_fold">더보기</button></p>

                            <div class="append_item">
                                <a href="#none" class="link_like " data-logtarget="" data-logevent="point,list,good">
                                    like_on 클래스 추가시 아이콘 변경
                                    <span class="ico_comm ico_like"></span> 좋아요 <span class="num_g" style="display:none;">0</span>
                                </a>
                                <span class="bg_bar"></span>

                                            <em class="screen_out">작성자 : </em><a class="link_user" href="javascript:void(0);" data-ismy="false" data-userid="utgeq6" data-username="크리스" data-platform="kakaomap" data-ori="http://t1.daumcdn.net/local/kakaomapPhoto/profile/7f31a897fa22b48122438aaaa53e695798a38f18?original">크리스</a>
                                            <span class="bg_bar"></span>

                                <em class="screen_out">작성일 : </em><span class="time_write">2019.03.04.</span>

                                    <span class="bg_bar"></span>
                                    <a href="javascript:void(0);" data-id="spamLink" data-commentid="429207" class="link_function" target="popup" data-platform="kakaomap" data-logtarget="" data-logevent="point,list,report">
                                        신고
                                    </a>

                            </div>
                    </div>

                </li>
                <li data-id="425973" class="  " data-is-block="false">
                    2018-07-23 profile_info 추가 시작
                    <a href="javascript:void(0);" class="profile_info" data-ismy="false" data-userid="u2j7t4" data-username="여기는 어디 ?" data-platform="kakaomap" data-ori="http://th-p.talk.kakao.co.kr/th/talkp/wkYiBFk5Gm/Np8bK2nYwYSDTsZ5duv0v0/6ni461.jpg">
                            <img src="//img1.daumcdn.net/thumb/C48x48.q80/?fname=http://th-p.talk.kakao.co.kr/th/talkp/wkYiBFk5Gm/Np8bK2nYwYSDTsZ5duv0v0/6ni461.jpg" width="48" height="48" class="thumb_g" alt="">

                            <span class="ico_comm  "></span>
                    </a>
                    <div class="star_info">
                        <div class="grade_star size_s">
                            <span class="ico_star star_rate"><span class="ico_star inner_star" style="width:100%;"></span></span>
                            <em class="num_rate">5<span class="screen_out">점</span></em>
                        </div>
                    </div>
                    // 2018-07-23 profile_info 추가 끝

                    <div class="comment_info">
                                <p class="txt_comment "><span>아주 편하게 빨리 해서 좋아요</span><button type="button" class="btn_fold">더보기</button></p>

                            <div class="append_item">
                                <a href="#none" class="link_like " data-logtarget="" data-logevent="point,list,good">
                                    like_on 클래스 추가시 아이콘 변경
                                    <span class="ico_comm ico_like"></span> 좋아요 <span class="num_g" style="display:none;">0</span>
                                </a>
                                <span class="bg_bar"></span>

                                            <em class="screen_out">작성자 : </em><a class="link_user" href="javascript:void(0);" data-ismy="false" data-userid="u2j7t4" data-username="여기는 어디 ?" data-platform="kakaomap" data-ori="http://th-p.talk.kakao.co.kr/th/talkp/wkYiBFk5Gm/Np8bK2nYwYSDTsZ5duv0v0/6ni461.jpg">여기는 어디 ?</a>
                                            <span class="bg_bar"></span>

                                <em class="screen_out">작성일 : </em><span class="time_write">2019.03.02.</span>

                                    <span class="bg_bar"></span>
                                    <a href="javascript:void(0);" data-id="spamLink" data-commentid="425973" class="link_function" target="popup" data-platform="kakaomap" data-logtarget="" data-logevent="point,list,report">
                                        신고
                                    </a>

                            </div>
                    </div>

                </li>
        </ul>
    </div>
</div>
        <div class="cont_review" data-viewid="review" data-root="">
    <div class="particular_head">
        <h3 class="tit_subject">리뷰</h3>
            <span class="color_g">이 장소의 리뷰를 첫 번째로 등록해주세요.</span>
        <a href="#none" class="link_enroll" data-logtarget="" data-logevent="review,add_review">
            <span class="ico_comm ico_enroll"></span>블로그 리뷰등록
        </a>
    </div>
</div>
        
        <div data-viewid="findway" data-root="" class="cont_findway">
    <h3 class="tit_subject">찾아가는 길</h3>
    <div class="findway_map">
        <h4 class="screen_out">지도 보기</h4>
        <div class="view_map" id="map" style="overflow: hidden; background: url(&quot;https://t1.daumcdn.net/mapjsapi/images/2x/bg_tile.png&quot;);"><div style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; touch-action: none; cursor: url(&quot;https://i1.daumcdn.net/dmaps/apis/cursor/openhand.cur.ico&quot;) 7 5, url(&quot;https://i1.daumcdn.net/dmaps/apis/cursor/openhand.cur.ico&quot;), default;"><div style="position: absolute; left: 180px; top: -51px;"><div style="position: absolute; z-index: 0;"></div><div style="position: absolute; z-index: 1; left: 0px; top: 0px;"><img src="https://map0.daumcdn.net/map_2d_hd/2009alo/L5/503/216.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: -404px; top: 78px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map1.daumcdn.net/map_2d_hd/2009alo/L5/503/217.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: -148px; top: 78px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map2.daumcdn.net/map_2d_hd/2009alo/L5/503/218.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: 108px; top: 78px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map3.daumcdn.net/map_2d_hd/2009alo/L5/503/219.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: 364px; top: 78px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map0.daumcdn.net/map_2d_hd/2009alo/L5/504/216.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: -404px; top: -178px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map1.daumcdn.net/map_2d_hd/2009alo/L5/504/217.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: -148px; top: -178px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map2.daumcdn.net/map_2d_hd/2009alo/L5/504/218.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: 108px; top: -178px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map3.daumcdn.net/map_2d_hd/2009alo/L5/504/219.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: 364px; top: -178px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map0.daumcdn.net/map_2d_hd/2009alo/L5/505/216.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: -404px; top: -434px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map1.daumcdn.net/map_2d_hd/2009alo/L5/505/217.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: -148px; top: -434px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map2.daumcdn.net/map_2d_hd/2009alo/L5/505/218.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: 108px; top: -434px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"><img src="https://map3.daumcdn.net/map_2d_hd/2009alo/L5/505/219.png" alt="" draggable="false" style="position: absolute; user-select: none; -webkit-user-drag: none; min-width: 0px; min-height: 0px; max-width: none; max-height: none; left: 364px; top: -434px; opacity: 1; transition-property: opacity; transition-duration: 0.2s; transition-timing-function: ease; width: 256px; height: 256px;"></div><div style="position: absolute; z-index: 1;"></div><div style="width: 638px; height: 258px; position: absolute; z-index: 1;"></div><div style="position: absolute; z-index: 1;"><svg version="1.1" style="stroke: none; stroke-dashoffset: 0.5; stroke-linejoin: round; fill: none; transform: translateZ(0px); position: absolute; left: -1456px; top: -465px; width: 3190px; height: 1290px;" viewBox="0 0 3190 1290"><defs></defs></svg></div><div style="position: absolute; z-index: 1; width: 100%; height: 0px; transform: translateZ(0px);"><div style="position: absolute; margin: -48px 0px 0px -17px; z-index: 999; left: 159px; top: 193px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(0px, 66px, 50px, 30px); top: 0px; left: -30px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 185px; top: 189px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 189px; top: 190px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 166px; top: 224px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 169px; top: 163px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 181px; top: 166px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 164px; top: 235px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 115px; top: 177px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 110px; top: 184px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 146px; top: 142px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 183px; top: 125px; display: block;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div><div style="position: absolute; margin: -17px 0px 0px -15px; z-index: 0; left: 89px; top: 168px;"><img draggable="false" src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/rtn/ico_findway.png" alt="" title="" style="min-width: 0px; min-height: 0px; max-width: 99999px; max-height: none; border: 0px; display: block; position: absolute; user-select: none; -webkit-user-drag: none; clip: rect(30px, 30px, 60px, 0px); top: -30px; left: 0px; width: 70px; height: 70px;"></div></div></div></div><div style="position: absolute; cursor: default; z-index: 1; margin: 0px 6px; height: 19px; line-height: 14px; bottom: 0px; color: rgb(0, 0, 0); right: 0px;"><div style="color: rgb(0, 0, 0); text-align: center; font-size: 10px; float: right;"><div style="float: left; margin: 2px 3px 0px 4px; height: 6px; transition: width 0.1s ease 0s; border-top: none rgb(0, 0, 0); border-right: 2px solid rgb(0, 0, 0); border-bottom: 2px solid rgb(0, 0, 0); border-left: 2px solid rgb(0, 0, 0); border-image: initial; width: 58px;"></div><div style="float: left; margin: 0px 4px 0px 0px; font-family: AppleSDGothicNeo-Regular, 돋움, dotum, sans-serif; font-weight: bold; color: rgb(0, 0, 0);">250m</div></div><div style="margin: 0px 4px; float: right;"><a target="_blank" href="http://map.kakao.com/" title="Kakao 지도로 보시려면 클릭하세요." style="float: left; width: 32px; height: 10px;"><img src="https://t1.daumcdn.net/mapjsapi/images/2x/m_bi_b.png" alt="Kakao 지도로 이동" style="float: left; width: 32px; height: 10px; border: none;"></a><div style="font: 11px / 11px Arial, Tahoma, Dotum, sans-serif; float: left;"></div></div></div><div style="cursor: auto; position: absolute; z-index: 2; left: 0px; top: 0px;"></div></div>지도 영역 입니다.
        <strong class="screen_out">지도 보기 탭 메뉴</strong>
        <ul class="tab_map">
            <li class="on"><a href="#none" class="link_tab link_mapview" data-logtarget="" data-logevent="waytogo,2D_view">지도뷰</a></li>
            <li><a href="#none" class="link_tab link_skyview" data-logtarget="" data-logevent="waytogo,sky_view">스카이뷰</a></li>
        </ul>
        <div class="map_control">
            <div class="bg_control bg_zoomin link_control">
                <a href="#none" class="ico_comm ico_zoomin" data-logtarget="" data-logevent="waytogo,zoomin">확대하기</a>
            </div>
            <div class="bg_control bg_zoomout link_control">
                <a href="#none" class="ico_comm ico_zoomout" data-logtarget="" data-logevent="waytogo,zoomout">축소하기</a>
            </div>
            <div class="bg_control bg_refresh link_control">
                <a href="#none" class="ico_comm ico_refresh" data-logtarget="" data-logevent="waytogo,refresh">새로고침</a>
            </div>
            <div class="bg_control bg_full">
                <a href="https://map.kakao.com?urlX=483596&amp;urlY=1139090&amp;urlLevel=3&amp;itemId=892584709&amp;q=%ED%80%B4%ED%81%B4%EB%A6%B024%EC%85%80%ED%94%84%EB%B9%A8%EB%9E%98%EB%B0%A9&amp;map_type=TYPE_MAP" target="_blank" class="ico_comm ico_full" data-logtarget="" data-logevent="waytogo,largeview">전체화면</a>
            </div>
        </div>
        
        <div class="map_control">
            <a href="#none" class="link_control" data-logtarget data-logevent="waytogo,zoomin"><span class="ico_comm ico_zoomin">확대하기</span></a>
            <a href="#none" class="link_control" data-logtarget data-logevent="waytogo,zoomout"><span class="ico_comm ico_zoomout">축소하기</span></a>
            <a href="#none" class="link_control" data-logtarget data-logevent="waytogo,refresh"><span class="ico_comm ico_refresh">새로고침</span></a>
        </div>
        <a href="https://map.kakao.com?urlX=483596&urlY=1139090&urlLevel=3&itemId=892584709&q=%ED%80%B4%ED%81%B4%EB%A6%B024%EC%85%80%ED%94%84%EB%B9%A8%EB%9E%98%EB%B0%A9&map_type=TYPE_MAP" target="_blank" class="link_full" data-logtarget data-logevent="waytogo,largeview"><span class="ico_comm ico_full">전체화면</span></a>
       
    </div>
        <div class="station_wayout">
            <h4 class="tit_findway">지하철역</h4>
            <ul class="list_wayout">
                    <li>
                        <em class="txt_station"><a href="https://map.kakao.com?subwayId=SES2612" target="_blank" class="link_station" data-logtarget="" data-logevent="waytogo,subway">역촌역</a></em>
                            <span class="ico_traffic seoul_line6_small">6호선</span>호선별 대체 텍스트 부탁 드립니다.
                        <span class="bg_bar">|</span>
                        <span class="txt_wayout"><span class="num_wayout">4</span>번 출구 <span class="num_wayout txt_walk">도보 13분</span></span>
                    </li>
                    <li>
                        <em class="txt_station"><a href="https://map.kakao.com?subwayId=SES0313" target="_blank" class="link_station" data-logtarget="" data-logevent="waytogo,subway">녹번역</a></em>
                            <span class="ico_traffic seoul_line3_small">3호선</span>호선별 대체 텍스트 부탁 드립니다.
                        <span class="bg_bar">|</span>
                        <span class="txt_wayout"><span class="num_wayout">3</span>번 출구 <span class="num_wayout txt_walk">도보 15분</span></span>
                    </li>
                    <li>
                        <em class="txt_station"><a href="https://map.kakao.com?subwayId=SES2611" target="_blank" class="link_station" data-logtarget="" data-logevent="waytogo,subway">응암역</a></em>
                            <span class="ico_traffic seoul_line6_small">6호선</span>호선별 대체 텍스트 부탁 드립니다.
                        <span class="bg_bar">|</span>
                        <span class="txt_wayout"><span class="num_wayout">4</span>번 출구 <span class="num_wayout txt_walk">도보 15분</span></span>
                    </li>
            </ul>
        </div>
        <div class="station_ride check_list">
            <h4 class="tit_findway">버스정류장</h4>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=11120591021" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">응암1동주민센터</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12261) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 104m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_green">지선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">7019<span class="bg_bar">|</span>7734</span>
                                    <a href="https://map.kakao.com?busStopId=11120591021" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=11120591020" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">응암1동주민센터</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12270) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 119m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_green">지선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">7019<span class="bg_bar">|</span>7734</span>
                                    <a href="https://map.kakao.com?busStopId=11120591020" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=BS230548" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">녹번센트레빌아파트</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12477) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 127m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_green">지선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">7019<span class="bg_bar">|</span>7734</span>
                                    <a href="https://map.kakao.com?busStopId=BS230548" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=11120591006" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">은평세무서</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12127) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 130m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_blue">간선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">702A서오릉<span class="bg_bar">|</span>702B용두초교</span>
                                    <a href="https://map.kakao.com?busStopId=11120591006" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                            <li>
                                <em class="ico_traffic bus_green">지선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">7025<span class="bg_bar">|</span>7212<span class="bg_bar">|</span>7719<span class="bg_bar">|</span>7722<span class="bg_bar">|</span>7730</span>
                                    <a href="https://map.kakao.com?busStopId=11120591006" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                            <li>
                                <em class="ico_traffic bus_town">마을</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">은평05</span>
                                    <a href="https://map.kakao.com?busStopId=11120591006" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=11120591016" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">은평세무서</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12134) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 141m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_blue">간선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">702A서오릉<span class="bg_bar">|</span>702B용두초교</span>
                                    <a href="https://map.kakao.com?busStopId=11120591016" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                            <li>
                                <em class="ico_traffic bus_green">지선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">7025<span class="bg_bar">|</span>7719<span class="bg_bar">|</span>7722<span class="bg_bar">|</span>7730<span class="bg_bar">|</span>8771<span class="txt_bustype">(출근)</span></span>
                                    <a href="https://map.kakao.com?busStopId=11120591016" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=BS230547" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">녹번센트레빌아파트</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12476) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 166m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_green">지선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">7019<span class="bg_bar">|</span>7734</span>
                                    <a href="https://map.kakao.com?busStopId=BS230547" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=11120591005" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">본서부병원</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12128) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 188m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_blue">간선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">702A서오릉<span class="bg_bar">|</span>702B용두초교</span>
                                    <a href="https://map.kakao.com?busStopId=11120591005" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                            <li>
                                <em class="ico_traffic bus_green">지선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">7025<span class="bg_bar">|</span>7212<span class="bg_bar">|</span>7719<span class="bg_bar">|</span>7722<span class="bg_bar">|</span>7730</span>
                                    <a href="https://map.kakao.com?busStopId=11120591005" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                            <li>
                                <em class="ico_traffic bus_town">마을</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">은평05</span>
                                    <a href="https://map.kakao.com?busStopId=11120591005" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=11120591001" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">본서부병원</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12133) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 201m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_blue">간선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">702A서오릉<span class="bg_bar">|</span>702B용두초교</span>
                                    <a href="https://map.kakao.com?busStopId=11120591001" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                            <li>
                                <em class="ico_traffic bus_green">지선</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">7025<span class="bg_bar">|</span>7212<span class="bg_bar">|</span>7719<span class="bg_bar">|</span>7722<span class="bg_bar">|</span>7730<span class="bg_bar">|</span>8771<span class="txt_bustype">(출근)</span></span>
                                    <a href="https://map.kakao.com?busStopId=11120591001" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=BS424587" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">은평세무서음식문화거리</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12886) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 211m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_town">마을</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">은평05</span>
                                    <a href="https://map.kakao.com?busStopId=BS424587" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=BS115461" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">은평세무서</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12536) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 290m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_town">마을</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">은평05</span>
                                    <a href="https://map.kakao.com?busStopId=BS115461" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
                <div class="ride_wayout">지도에서 일치하는 정류장에 마우스 오버 했을 때 클래스 ride_on 추가
                    <strong class="tit_wayout">
                        <a href="https://map.kakao.com?busStopId=BS118579" class="link_wayout" target="_blank" data-logtarget="" data-logevent="waytogo,busstop">
                            <span class="txt_busstop">서부경찰서앞</span>
                            <span class="txt_number"><span class="screen_out">정류장 번호: </span>(12531) <span class="bg_bar">|</span> <span class="screen_out">거리: </span> 299m</span>
                        </a>
                    </strong>
                    <ul class="list_ride">
                            <li>
                                <em class="ico_traffic bus_town">마을</em>버스 선별로 대체 텍스트 부탁 드립니다.
                                <div class="bus_ride">
                                    <span class="num_ride">은평05</span>
                                    <a href="https://map.kakao.com?busStopId=BS118579" target="_blank" class="btn_more hide" data-logtarget="" data-logevent="waytogo,busstop_more"><span class="ico_comm ico_more">더보기</span></a>
                                </div>
                            </li>
                    </ul>
                </div>
        </div>
</div>
        <div id="photoList" class="map_layer hide"></div>
        <div id="roughMap" class="map_layer hide">
    <iframe data-id="frame" frameborder="0" border="0" class="frame" src="" style="width: 1017px; height: 693px;"></iframe>
</div>

        <div data-viewid="fiyLayer" data-root="" id="fiyModalLayer" style="display:none">
    <div class="fiy_wrap">
        <iframe frameborder="0" border="0" class="fiyFrame" src=""></iframe>
    </div>
    <div class="modal_bg"></div>
</div>
        <div data-viewid="fiyLoginLayer" data-root="" class="fiy_layer" style="display:none">
    <div class="inner_fiy_layer">
        <div class="layer_head"><strong class="tit_fiy">정보수정</strong></div>
        <div class="layer_body">
            <p class="desc_fiy">로그인을 하시면<br>요청 결과를 안내해드립니다</p>
            <div class="wrap_btn">
                <a href="#none" class="btn_fiy btn_kakao"><span class="inner_btn">카카오계정으로 로그인</span></a>
            </div>
            <button type="button" class="btn_fiy2">로그인 하지 않습니다</button>
        </div>
    </div>
</div>
    </div>
</div>
<hr class="hide">
<div data-viewid="footer" data-root="" id="kakaoFoot" class="footer_mapdetail" role="contentinfo">
    <div class="inner_mapdetail">
        <h2 class="screen_out">서비스 이용정보</h2>
        <a href="http://policy.daum.net/info/info" class="link_info" target="_blank" data-logtarget="" data-logevent="footer,term">서비스 약관/정책</a>
        <span class="bg_bar"></span>
        <a href="https://cs.kakao.com/requests?locale=ko&amp;service=101" class="link_info" target="_blank" data-logtarget="" data-logevent="footer,service">고객센터</a>
        <span class="bg_bar"></span>
        <a href="https://cs.daum.net/redbell/top.html" class="link_info" target="_blank" data-logtarget="" data-logevent="footer,report">권리침해 신고</a>
        <span class="bg_bar"></span>
        <a href="http://local.biz.daum.net/rainbow_core/ols/index.local" target="_blank" class="link_info" data-logtarget="" data-logevent="footer,ad">로컬광고신청</a>
        <span class="bg_bar"></span>
        <a href="http://kakaomap.tistory.com/category/%EC%95%8C%EB%A6%BD%EB%8B%88%EB%8B%A4/%EC%97%85%EB%8D%B0%EC%9D%B4%ED%8A%B8" target="_blank" class="link_info" data-logtarget="" data-logevent="footer,notice">공지사항<span class="ico_comm ico_new">새글</span></a>
        <small class="txt_copyright">Copyright © <a href="http://info.daum.net/" class="link_kakao" target="_blank">Kakao Corp.</a> All rights reserved.</small>
    </div>
</div>스크롤이 내려 왔을 때 클래스 lbar_on 
        <div id="wrapMinidaum"></div>
    </div>
    <div id="daumWrap" style="display:none;">
        <div id="daumContent">
            <div id="shareContainer"></div>
        </div>
    </div>
    <script type="text/javascript" src="//ssl.daumcdn.net/dmaps/map_js_init/v3.js"></script><script charset="UTF-8" src="https://t1.daumcdn.net/mapjsapi/js/main/4.2.1/v3.js"></script>
    <script type="text/javascript" src="//t1.daumcdn.net/tiara/js/v1/tiara.min.js"></script>
    <script type="text/javascript" src="//t1.daumcdn.net/daumtop_deco/socialshare/socialshare_pc-2.4.1.js"></script>
    <script type="text/javascript" src="//t1.daumcdn.net/adfit/static/ad-native.min.js"></script>
    <script>
        window.ENV = 'PROD';
        window.browserversion = 'chrome85';
        
        // 티아라 초기화
        try {
            TiaraTracker.getInstance().init({
                svcDomain: 'place.map.kakao.com',
                deployment: window.ENV === 'PROD' ? 'production' : 'dev'
            });
        } catch(e) {}
        window.needFiy = 'true';
        window.needBlogReview = 'true';
        window._cp = '';
    </script>

    
        
            <script type="text/javascript" src="//s1.daumcdn.net/svc/attach/U0301/cssjs/mm/1482483925476/Chart.min.js"></script>
            <script type="text/javascript" src="//t1.daumcdn.net/kakaomapweb/place/jscss/pc.2018109d.js"></script><iframe style="position:absolute;left:0;top:0;width:0;height:0;border:0" src="mapclick.html?_=1601813623771"></iframe>-->


				<!--
    <script>
        var minidaum_options = {
            disableTracker: true, // 미니다음에서 tiara 사용안함
            bgType: "white",
            enableLogoutRetun: true,
            returnUrl: '',
            disableHotissue: true,
            disableLogo:true,
            enableShield: false
        };
    </script>
    <script async src="//go.daum.net/jsa_minidaum_pc.daum" charset="utf-8" type="text/javascript"></script>
    -->
				<!-- <input type='submit' value='주문하기' > -->
				<!-- <input type='button' onclick='location.href="list"' value='계쇽쇼핑하기'> -->

				<!-- </form>  -->

				<!--Popup Start -->
				<div>
					<button onClick="javascript:goDetail('테스트');">문의글 작성하기</button>
					<div style="height: 1000px;"></div>

					<!-- 팝업뜰때 배경 -->
					<div id="mask"></div>


					<div id="layerbox" class="layerpop"
						style="width: 700px; height: 350px;">
						<article class="layerpop_area">
							<div class="title">문의하기</div>
							<a href="javascript:popupClose();" class="layerpop_close"
								id="layerbox_close"></a> <br>

							<form name="writeForm" method="post" action="/user/schatW">
								<table>
									<tbody>

										<tr>
											<td><label for="content">제목</label> <textarea
													id="c_title" name="c_title" class="chk" title="제목을 입력하세요."
													placeholder="내용을 입력해주세요"></textarea></td>
										</tr>

										<tr>
											<td><label for="content">내용</label> <textarea
													id="c_content" name="c_content" class="chk"
													title="내용을 입력하세요." placeholder="내용을 입력해주세요"></textarea></td>
										</tr>
										<tr>
											<td><label for="writer">작성자</label><input type="text"
												id="writer" name="w_id" placeholder="ID가져올 예정"
												value="${loginMember.id}" /></td>
										<tr>
										<tr>
											<td><label for="writer"></label><input type="hidden"
												id="grade" name="g_check" placeholder="회원등급 가져올예정"
												value="${loginMember.grade}" /></td>
										<tr>
										<tr>
											<td><label for="writer"></label><input type="hidden"
												id="snum" name="snum" value='${storeInfo.snum}'
												placeholder="사업자번호 가져올예정" /></td>
										<tr>

											<td>
												<button type="submit" class="write_btn">작성하기</button>
											</td>
										</tr>

										<!-- <tr>


											<td>
												<button onclick="javascript:popupClose() ;">취소</button>
											</td>
										</tr>
 -->
									</tbody>
								</table>
							</form>

						</article>
					</div>
				</div>
				<!--Popup End -->
</body>
</html>