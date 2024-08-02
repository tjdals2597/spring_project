<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/notice.css?v=11">
    <link rel="stylesheet" type="text/css" href="./css/editor_style.css?v=2">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
    <link rel="stylesheet" href="https://cdn.ckeditor.com/ckeditor5/42.0.2/ckeditor5.css" />
</head>
<body>
<%@ include file="./admin_top.jsp" %>
<form id="notice_frm">
<main class="maincss">
<section>
    <p>공지사항 등록페이지</p>
<div class="write_view">
<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox"></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
    </li>
</ul>
<ul>
    <li>공지사항 제목</li>
    <li>
        <input type="text" class="notice_input1"> ※ 최대 150자까지 입력이 가능
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li>
        <input type="text" class="notice_input2" readonly> ※ 관리자 이름이 노출 됩니다.       
    </li>
</ul>
<ul>
    <li>첨부파일</li>
    <li>
        <input type="file"> ※ 첨부파일 최대 용량은 2MB 입니다.       
    </li>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
    	<div class="main-container">
	    	<div class="editor-container editor-container_classic-editor editor-container_include-style" id="editor-container">
		    	<div class="editor-container__editor">
		        	<textarea id="editor" class="notice_input3" name="ckeditor_text"></textarea>
		        </div>
	        </div>
        </div>
    </li>
</ul>
</div>
<div class="board_btn">
    <button class="border_del" onclick="golpage()">공지목록</button>
    <button class="border_add" onclick="notice_save()">공지등록</button>
</div>
</section>
</main>
</form>
<footer class="main_copyright">
	<%@ include file="./admin_footer.jsp" %>
</footer>
</body>
<script src="./js/notice_write.js?v=1"></script>
<script type="importmap">
	{
		"imports": {
			"ckeditor5": "https://cdn.ckeditor.com/ckeditor5/42.0.2/ckeditor5.js",
			"ckeditor5/": "https://cdn.ckeditor.com/ckeditor5/42.0.2/"
		}
	}
</script>
<script type="module" src="./js/ckeditor_main.js?v=1"></script>
</html>