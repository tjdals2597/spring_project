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
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(upass.getBytes());
			for (byte bt : md.digest()) {
				sb.append(String.format("%x", bt));
			}
		} catch (Exception e) {
			sb.append("인자값 오류 발생으로 생성이 되지 않음");
		}
		return sb.toString();
	}
}
