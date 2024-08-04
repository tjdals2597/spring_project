<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 리스트 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/notice.css?v=10">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>
<%@ include file="./admin_top.jsp" %>
<main class="maincss">
<section>
    <p>공지사항 관리페이지</p>
    <div class="subpage_view">
    <ul>
        <li><input type="checkbox" id="all_ck" onclick="checkbox_allck()"></li>
        <li>NO</li>
        <li>제목</li>
        <li>글쓴이</li>
        <li>날짜</li>
        <li>조회</li>
    </ul>
    <cr:if test="${ noticelist.size() == 0 }">
	    <ol class="none_text">
	        <li>등록된 공지 내용이 없습니다.</li>
	    </ol>
    </cr:if>
    <cr:if test="${ noticelist.size() != 0 }">
    	<cr:forEach var="notidata" items="${ noticelist }" varStatus="stat">
		    <ol>
		        <li><input type="checkbox" name="del_ck" value="" onclick="checkbox_eachck()"></li>
		        <li>${ stat.count }</li>
		        <li>${ notidata.getNtitle() }</li>
		        <li>${ notidata.getNamname() }</li>
		        <li>${ fn:substring(notidata.getNindate(), 0, 10) }</li>
		        <li>${ notidata.getNviews() }</li>
		    </ol>
		</cr:forEach>
	</cr:if>
    </div>
    <div class="board_btn">
        <button class="border_del" onclick="check_delete()">공지삭제</button>
        <button class="border_add" onclick="go_page()">공지등록</button>
    </div>
    <div class="border_page">
        <ul class="pageing">
            <li><img src="./ico/double_left.svg"></li>
            <li><img src="./ico/left.svg"></li>
            <li>1</li>
            <li><img src="./ico/right.svg"></li>
            <li><img src="./ico/double_right.svg"></li>
        </ul>
    </div>
</section>
</main>
<footer class="main_copyright">
	<%@ include file="./admin_footer.jsp" %>
</footer>
</body>
<script src="./js/list_checkbox.js?v=2"></script>
<script>
	function go_page() {
		location.href = "./notice_write.do";
	}
</script>
</html>