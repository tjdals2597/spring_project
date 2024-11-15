<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="stylesheet" type="text/css" href="./css/subpage.css?v=5">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>
<%@ include file="./admin_top.jsp" %>
<form id="homepage_info_frm">
<main class="maincss">
<section>
    <p>홈페이지 가입환경 설정</p>
    <input type="hidden" name="homekey" value="${ homepagedata.get(0) }">
<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
        <input type="text" name="hometitle" value="${ homepagedata.get(1) }" class="in_form1"> 
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input type="text" class="in_form2" name="adminemail" value="${ homepagedata.get(2) }"> ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입,인증메일,회원메일발송 등에서 사용)
    </li>
</ul> 
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss">
    	<cr:if test="${ homepagedata.get(3) == 'Y' }">
	        <em><label><input type="radio" name="usepointck" value="Y" class="ckclass" checked>포인트 사용</label></em> 
	        <em><label><input type="radio" name="usepointck" value="N" class="ckclass">포인트 미사용</label></em>
    	</cr:if>
    	<cr:if test="${ homepagedata.get(3) == null || homepagedata.get(3) == 'N' }">
	        <em><label><input type="radio" name="usepointck" value="Y" class="ckclass">포인트 사용</label></em> 
	        <em><label><input type="radio" name="usepointck" value="N" class="ckclass" checked>포인트 미사용</label></em>
    	</cr:if>
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input type="text" class="in_form3" maxlength="5" name="signpoint" value="${ homepagedata.get(4) }"> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input type="text" class="in_form3" maxlength="1" name="signlevel" value="${ homepagedata.get(5) }"> 레벨
    </li>
</ul>
</div>
<p>홈페이지 기본환경 설정</p>
<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input type="text" class="in_form0" name="compamy_name" value="${ homepagedata.get(6) }"> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input type="text" class="in_form0" name="business_regist_number" value="${ homepagedata.get(7) }"> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input type="text" class="in_form0" name="president_name" value="${ homepagedata.get(8) }"> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input type="text" class="in_form0" name="president_phone" value="${ homepagedata.get(9) }"> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input type="text" class="in_form0" name="mailorder_report_number" value="${ homepagedata.get(10) }"> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input type="text" class="in_form0" name="telecom_busi_number" value="${ homepagedata.get(11) }"> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input type="text" class="in_form0" name="business_zipcode" value="${ homepagedata.get(12) }" maxlength="5"> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input type="text" class="in_form2" name="business_address" value="${ homepagedata.get(13) }"> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input type="text" class="in_form0" name="infomanager_name" value="${ homepagedata.get(14) }"> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input type="text" class="in_form1" name="infomanager_email" value="${ homepagedata.get(15) }"> 
    </li>
</ul>
</div>
<p>결제 기본환경 설정</p>
<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행</li>
    <li>
        <input type="text" class="in_form0" name="non_account_bank" value="${ homepagedata.get(16) }"> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input type="text" class="in_form1" name="bank_account_number" value="${ homepagedata.get(17) }"> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
        <cr:if test="${ homepagedata.get(18) == 'Y' }">
	        <em><label><input type="radio" name="ckuse_credit_card" value="Y" class="ckclass" checked> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_credit_card" value="N" class="ckclass"> 미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    	</cr:if>
    	<cr:if test="${ homepagedata.get(18) == null || homepagedata.get(18) == 'N' }">
	        <em><label><input type="radio" name="ckuse_credit_card" value="Y" class="ckclass"> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_credit_card" value="N" class="ckclass" checked> 미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    	</cr:if>
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
    	<cr:if test="${ homepagedata.get(19) == 'Y' }">
	        <em><label><input type="radio" name="ckuse_mobile_phone" value="Y" class="ckclass" checked> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_mobile_phone" value="N" class="ckclass"> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    	</cr:if>
    	<cr:if test="${ homepagedata.get(19) == null || homepagedata.get(19) == 'N' }">
	        <em><label><input type="radio" name="ckuse_mobile_phone" value="Y" class="ckclass"> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_mobile_phone" value="N" class="ckclass" checked> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    	</cr:if>
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
    	<cr:if test="${ homepagedata.get(20) == 'Y' }">
	        <em><label><input type="radio" name="ckuse_book_gift_pay" value="Y" class="ckclass" checked> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_book_gift_pay" value="N" class="ckclass"> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    	</cr:if>
    	<cr:if test="${ homepagedata.get(20) == null || homepagedata.get(20) == 'N' }">
	        <em><label><input type="radio" name="ckuse_book_gift_pay" value="Y" class="ckclass"> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_book_gift_pay" value="N" class="ckclass" checked> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    	</cr:if>
    </li>
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" name="min_pay_points" value="${ homepagedata.get(21) }"> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" name="max_pay_points" value="${ homepagedata.get(22) }"> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
    	<cr:if test="${ homepagedata.get(23) == 'Y' }">
	        <em><label><input type="radio" name="ckuse_cash_receipt" value="Y" class="ckclass" checked> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_cash_receipt" value="N" class="ckclass"> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    	</cr:if>
    	<cr:if test="${ homepagedata.get(23) == null || homepagedata.get(23) == 'N' }">
	        <em><label><input type="radio" name="ckuse_cash_receipt" value="Y" class="ckclass"> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_cash_receipt" value="N" class="ckclass" checked> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    	</cr:if>
    </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input type="text" class="in_form0" name="delivery_compamy_name" value="${ homepagedata.get(24) }"> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input type="text" class="in_form0" maxlength="7" name="delivery_fee_price" value="${ homepagedata.get(25) }"> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
    	<cr:if test="${ homepagedata.get(26) == 'Y' }">
	        <em><label><input type="radio" name="ckuse_desired_deldate" value="Y" class="ckclass" checked> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_desired_deldate" value="N" class="ckclass"> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    	</cr:if>
    	<cr:if test="${ homepagedata.get(26) == null || homepagedata.get(26) == 'N' }">
	        <em><label><input type="radio" name="ckuse_desired_deldate" value="Y" class="ckclass"> 사용</label></em> 
	        <em><label><input type="radio" name="ckuse_desired_deldate" value="N" class="ckclass" checked> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    	</cr:if>
    </li>
</ul>
</div>
<div class="btn_div">
    <button type="button" class="sub_btn1" title="설정 저장" onclick="hp_info_save()">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소" onclick="save_cancel()">저장 취소</button>
</div>
</section>
<section></section>
<section></section>
</main>
</form>
<footer class="main_copyright">
	<%@ include file="./admin_footer.jsp" %>
</footer>
</body>
<script src="./js/admin_siteinfo.js?v=2"></script>
</html>