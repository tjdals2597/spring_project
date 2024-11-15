<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/mainlogin.css?v=5">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=5">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
    <link rel="stylesheet" type="text/css" href="./css/shopping/lgnacnt_table.css?v=5">
</head>
<body class="bodycss">
    <header class="admin_title">
        <p><img src="./img/logo.png" class="logo_sm"> ADMINISTRATOR</p>
    </header>
    <section class="admin_bgcolor">
        <form id="admin_login_frm" onsubmit="return admin_login()">
        <div class="admin_login">
            <span>
                <div class="left_div">
                <ul>
                <li><input type="text" class="input_text1" name="login_id" placeholder="관리자 아이디를 입력하세요"></li>
                <li><input type="password" class="input_text1" name="login_pw" placeholder="관리자 패스워드를 입력하세요"></li>
                </ul>
                </div>
                <div class="right_div">
                    <button type="submit" class="btn_submit" title="MASTER LOGIN">MASTER LOGIN</button>
                </div>
                <em class="alert_msg">※ 본 사이트는 관리자 외에는 접근을 금합니다. 페이지 접근에 대한 접속 정보는 모두 기록 됩니다.</em>
            </span>
            <span>
                <ol class="admin_info">
                    <li title="신규 관리자 등록요청" onclick="js_gopage('1')">신규 관리자 등록요청</li>
                    <li title="아이디/패스워드 찾기" onclick="js_gopage('2')">아이디/패스워드 찾기</li>
                </ol>
            </span>
        </div>
        </form>
    </section>
    <div class="acnt_box adminpage">
        <div class="acnt_title">일반 사용자 계정 견본</div>
        <table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>구분</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>master</td>
					<td>shop_master123</td>
					<td>최고관리자</td>
				</tr>
				<tr>
					<td>hongadmin</td>
					<td>h1234</td>
					<td>관리자</td>
				</tr>
			</tbody>
		</table>
    </div>
<footer class="admin_copy_login">
	<%@ include file="./admin_footer.jsp" %>
</footer>
</body>
<script src="./js/admin_index.js?v=5"></script>
</html>