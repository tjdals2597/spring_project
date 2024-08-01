<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="stylesheet" type="text/css" href="./css/product.css?v=5">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>
<%@ include file="./admin_top.jsp" %>
<main class="maincss">
<section>
<p>상품관리 페이지</p>
<div class="subpage_view">
    <span>등록된 상품 ${ productcount }건</span>
    <span>
        <form>
        <select class="p_select1">
            <option>상품명</option>
            <option>상품코드</option>
        </select>
        <input type="text" class="p_input1" placeholder="검색어를 입력해 주세요">
        <input type="submit" value="검색" title="상품검색" class="p_submit">
        </form>
    </span>
</div>
<div class="subpage_view2">
    <ul>
        <li><input type="checkbox"></li>
        <li>코드</li>
        <li>이미지</li>
        <li>상품명</li>
        <li>카테고리 분류</li>
        <li>판매가격</li>
        <li>할인가격</li>
        <li>할인율</li>
        <li>재고현황</li>
        <li>판매유/무</li>
        <li>품절</li>
        <li>관리</li>
    </ul>
    <cr:if test="${ productlist.size() == 0 }">
	    <ul>
	        <li style="width: 100%;">등록된 상품이 없습니다.</li>
	    </ul>
    </cr:if>
    <cr:if test="${ productlist.size() != 0 }">
    	<cr:forEach var="pdata" items="${ productlist }">
		    <ul>
		        <li><input type="checkbox"></li>
		        <li>${ pdata.getPcode() }</li>
		        <cr:set var="imgname" value="${ fn:split(pdata.getPimages(), '|') }"/>
		        <li><a href="./product_img/${ imgname[1] }" target="_blank">이미지</a></li>
		        <li>${ pdata.getPname() }</li>
		        <li>${ pdata.getPcateidx() }</li>
		        <li>${ pdata.getOriginal_price() }</li>
		        <li>${ pdata.getDiscount_price() }</li>
		        <li>${ pdata.getDiscount_rate() }</li>
		        <li>${ pdata.getProduct_stock() }</li>
		        <li>${ pdata.getSell_ck() }</li>
		        <li>${ pdata.getEarly_sold_ck() }</li>
		        <li>관리</li>
		    </ul>
    	</cr:forEach>
	</cr:if>
</div>
<div class="subpage_view3">
    <ul class="pageing">
        <li><img src="./ico/double_left.svg"></li>
        <li><img src="./ico/left.svg"></li>
        <li>1</li>
        <li><img src="./ico/right.svg"></li>
        <li><img src="./ico/double_right.svg"></li>
    </ul>
</div>
<div class="subpage_view4">
    <input type="button" value="선택상품 삭제" title="선택상품 삭제" class="p_button">
    <span style="float: right;">
    <input type="button" value="신규상품 등록" title="신규상품 등록" onclick="location.href='./product_write.do';" class="p_button p_button_color1">
    <input type="button" value="카테고리 등록" title="카테고리 등록" onclick="location.href='./cate_list.do';" class="p_button p_button_color2">
    </span>
</div>
</section>
</main>
<footer class="main_copyright">
    <%@ include file="./admin_footer.jsp" %>
</footer>
</body>
</html>