package com.bagshop.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

// user table (select, insert, update, delete)
@Repository("userselect")
public class user_select {

	@Resource(name = "template")
	private SqlSessionTemplate tm;
	
	public ArrayList<Object> search_id(String uname, String uemail) {
		ArrayList<Object> onedata = new ArrayList<Object>();
		Map<String, String> keycode = new HashMap<String, String>();
		keycode.put("part", "1");
		keycode.put("uname", uname);
		keycode.put("uemail", uemail);
		user_dao dao = this.tm.selectOne("shopping_mall.search", keycode);
		System.out.println(dao.getUid());
		return onedata;
	}
}
