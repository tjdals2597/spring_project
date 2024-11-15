<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=1">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>
<%@ include file="./admin_top.jsp" %>
<main class="maincss">
<section>
    <p>신규등록 관리자</p>
    <ol class="new_admin_title2">
        <li>NO</li>
        <li>관리자명</li>
        <li>아이디</li>
        <li>전화번호</li>
        <li>이메일</li>
        <li>담당부서</li>
        <li>담당직책</li>
        <li>가입일자</li>
        <li>승인여부</li>
    </ol>
    <cr:if test="${ adminlist.size() == 0 }">
	    <ol class="new_admin_none">
	        <li>신규 등록된 관리자가 없습니다.</li>
	    </ol>
    </cr:if>
    <cr:if test="${ adminlist.size() != 0 }">
    	<form id="amloginck_frm">
    		<input type="hidden" name="amloginck" id="amloginck">
    		<input type="hidden" name="amvalueck" id="amvalueck">
    	</form>
    	<cr:forEach var="admindao" items="${ adminlist }" varStatus="stat">
		    <ol class="new_admin_lists2">
		        <li>${ stat.count }</li>
		        <li>${ admindao.getAmname() }</li>
		        <li>${ admindao.getAmid() }</li>
		        <li>${ admindao.getAmphone() }</li>
		        <li>${ admindao.getAmemail() }</li>
		        <li>${ admindao.getAmdepartment() }</li>
		        <li>${ admindao.getAmposition() }</li>
		        <li>${ fn:substring(admindao.getAmindate(), 0, 10) }</li>
		        <li>
		        	<cr:if test="${ admindao.getAmloginck() == 'N' }">
			            <input type="button" value="승인" onclick="amlogin_ok('${ admindao.getAmidx() }')" class="new_addbtn1" title="승인">
		        	</cr:if>
		        	<cr:if test="${ admindao.getAmloginck() == 'Y' }">
			            <input type="button" value="미승인" onclick="amlogin_no('${ admindao.getAmidx() }')" class="new_addbtn2" title="미승인">
		        	</cr:if>
		        </li>
		    </ol>
    	</cr:forEach>
    </cr:if>
</section>
<section></section>
<section></section>
</main>
<footer class="admin_copy">
	<%@ include file="./admin_footer.jsp" %>
</footer>
</body>
<script src="./js/admin_list.js?v=1"></script>
</html>