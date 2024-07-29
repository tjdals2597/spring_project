package com.bagshop.www;

import java.security.MessageDigest;

import org.springframework.stereotype.Repository;

// 패스워드를 md5 형태로 변환하는 클래스
// 사용처 : 회원가입, 로그인, 패스워드 변경, 1:1 문의, 자유게시판, 상품 구매 등
//@Repository("md5pass")
abstract class md5_pass {

	public String md5_make(String upass) {
		StringBuilder sb = new StringBuilder(); // return 객체
		try {
			MessageDigest md = MessageDigest.getInstance("SHA3-256");
			md.update(upass.getBytes());
			for (byte bt : md.digest()) {
				sb.append(String.format("%X", bt));
			}
		} catch (Exception e) {
			sb.append("인자값 오류 발생으로 생성이 되지 않음");
		}
		return sb.toString();
	}
}
// dc10aa7021 dbf78950fd 705b1fc5de 3c779490dc 1c74597465 d87b4ca64d d8
// 8E5D794688 55B0AA3015 2460F86966 9EBECE49A7 48839C70F1 9D17BB2A22 39E2
// 1E8B9247AA 1AC59663A7 1E57DAD0BD 4F45A76ACC D5A6B49FE5 88929CA6A8 68D