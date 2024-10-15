<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>${ hpInfo.getHometitle() }</title>
    <meta charset="utf-8" />
    <link href="../css/shopping/index.css" rel="stylesheet" />
    <link href="../css/shopping/subpage.css" rel="stylesheet" />
    <link href="../css/shopping/agree.css?v=1" rel="stylesheet" />
  </head>
  <body>
<%@ include file="./top.jsp" %>
 <main>
    <div class="products">
      <h3>MEMBER_JOIN</h3>
      <div class="sub_view">

    <div class="joinview">     
    <form id="agree_frm">
        <h3>약관동의</h3>
				<div class="join_agreement_cont">
					<div class="join_agreement_box">
						<div class="form_element">
							<input type="checkbox" id="allAgree"/>
							<label class="check" for="allAgree"> <em>ShopBag의 모든 약관을 확인하고 전체 동의합니다.</em></label>
							<span>(전체동의, 선택항목도 포함됩니다.)</span>
						</div>
					</div>
					
					<div class="join_agreement_box js_terms_view">
						<div class="form_element">
							<input type="checkbox" id="termsAgree1" name="agreementInfoFl" value="Y" class="require" />
							<label class="check_s" for="termsAgree1"><strong>(필수)</strong> 이용약관</label>
							<span><a href="#" target="_blank">전체보기</a></span>
						</div>
						<div class="agreement_box" id="use_agree">
							
						</div>
						
					</div>
					
					<div class="join_agreement_box js_terms_view">
						<div class="form_element">
							<input type="checkbox" id="termsAgree2" name="privateApprovalFl" value="Y" class="require" />
							<label class="check_s" for="termsAgree2"><strong>(필수)</strong> 개인정보 수집 및 이용 </label>
							<span><a href="#" target="_blank">전체보기</a></span>
						</div>
						<div class="agreement_box" id="info_agree">
							
						</div>
					</div>
					<div class="important_check_box">
						<strong class="important_check dn">이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.</strong>
					</div>
				</div>
				
				<div class="btn_center_box">
					<button type="button" id="btnNextStep" class="btn_join">다음단계</button>
                </div>
			</form>
        </div>
      </div>
    </div>
</main>
<%@ include file="./footer.jsp" %>
  </body>
<script src="../js/shopping/agree.js?v=3"></script>
</html>