<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 찾기</title>
</head>
<body>
<form id="frm">
	<p>아이디 찾기</p>
	고객명 : <input type="text" name="uname"><br>
	이메일 : <input type="text" name="uemail"><br>
	<input type="button" value="아이디 찾기" onclick="btn1()">
	<br><br><br>
	<p>비밀번호 찾기</p>
	아이디 : <input type="text" name="uid"><br>
	고객명 : <input type="text" name="uname"><br>
	
	<input type="button" value="패스워드 변경" onclick="btn2()">
</form>
</body>
<script>
	function btn1() {
		frm.method = "POST";
		frm.action = "./idsearch.do";
		frm.submit();
	}
	
	function btn2() {
		frm.method = "POST";
		frm.action = "./passmodify.do";
		frm.submit();
	}
</script>
</html>