<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쇼핑몰 회원관리</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>
<%@ include file="./admin_top.jsp" %>
<form id="mlist_pagefrm">
<main class="maincss">
<section>
    <p>회원 리스트 - 아직 안함</p>
    <ol class="new_admin_title">
        <li>NO</li>
        <li>고객명</li>
        <li>아이디</li>
        <li>전화번호</li>
        <li>이메일</li>
        <li>이메일 수신</li>
        <li>SMS 수신</li>
        <li>가입일자</li>
        <li>상태</li>
        <li>정지여부</li>
    </ol>
    <cr:if test="${ userlist.size() == 0 }">
	    <ol class="new_admin_none">
	        <li>가입된 회원이 없습니다.</li>
	    </ol>
    </cr:if>
	<cr:if test="${ userlist.size() != 0 }">
		<cr:forEach var="udata" items="">
		    <ol class="new_admin_lists">
		        <li>1</li>
		        <li>한석봉</li>
		        <li>hansbong</li>
		        <li>01012345678</li>
		        <li>hansbong@hanmail.net</li>
		        <li>Y</li>
		        <li>N</li>
		        <li>2024-08-02</li>
		        <li>정상</li>
		        <li>
		            <input type="button" value="정지" class="new_addbtn1" title="정지">
		            <input type="button" value="해제" class="new_addbtn2" title="해제">
		        </li>
		    </ol>
		</cr:forEach>
    </cr:if>
</section>
<section style="width: 1100px; height: auto; margin: 0 auto; margin-top: 30px;">
    <p style="font-size: 15px;font-weight: bolder; margin-bottom: 10px;">■ 이용 약관</p>
    <textarea name="agree_use" placeholder="이용약관에 대한 내용을 입력하세요" style="width: 100%; height: 100px; resize: none;"></textarea>
    <input type="button" value="이용약관 수정" onclick="useck_update()" title="이용약관 수정" class="btn_button" style="position: relative; left: 100%; margin-left: -100px;">
</section>
<section style="width: 1100px; height: auto; margin: 0 auto; margin-top: 30px;">
    <p style="font-size: 15px;font-weight: bolder; margin-bottom: 10px;">■ 개인정보 수집 및 이용</p>
    <textarea name="agree_info" placeholder="개인정보 수집 및 이용에 대한 내용을 입력하세요" style="width: 100%; height: 100px; resize: none;"></textarea>
    <input type="button" value="개인정보 약관 수정" onclick="infock_update()" title="개인정보 약관 수정" class="btn_button" style="position: relative; left: 100%; margin-left: -100px;">
</section>
</main>
<input type="hidden" name="agree_ck">
</form>
<footer class="main_copyright">
    <%@ include file="./admin_footer.jsp" %>
</footer>
</body>
<script src="./js/member_list.js?v=4"></script>
</html>