<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>${ hpInfo.getHometitle() }</title>
    <meta charset="utf-8" />
    <meta name="naver-site-verification" content="ae074753cd9a8d0de93d840c76c89675e2aaac75" />
    <meta name="google-site-verification" content="45TXrP-dJvTayTJl2HWcKEuX2n8DGKMDaCkVhLIcCZo" />
    <link href="../css/shopping/index.css?v=1" rel="stylesheet" />
    <link href="../css/shopping/menu.css?v=1" rel="stylesheet"/>
  </head>

  <body>
<%@ include file="./top.jsp" %>
<nav>
	<div class="menu-list">
		<ul>
			<cr:forEach var="category" items="${ catelist }">
				<li>${ category.getClgmenu_name() }</li>
			</cr:forEach>
		</ul>
	</div>
</nav>
 <main>
    <div class="hero-header"></div>
    <div class="products">
      <h3>NEW PRODUCTS</h3>
      <div class="product-list" id="productListBox"></div>
    </div>
</main>
<%@ include file="./footer.jsp" %>
  </body>
  <script src="../js/shopping/index.js?v=1"></script>
</html>