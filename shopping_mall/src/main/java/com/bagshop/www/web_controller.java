package com.bagshop.www;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class web_controller {

	PrintWriter pw = null;
	
	
	// HttpSession : interface를 활용하여, 세션을 빠르게 구현하는 방식
	@PostMapping("/loginok.do")
	public String loginok(@RequestParam(value = "", required = false) String mid, HttpSession session) {
		if (mid != null || mid != "") {
			session.setAttribute("mid", mid);
			session.setMaxInactiveInterval(1800);
		}
		return null;
	}
	/*
	@PostMapping("/loginok.do")
	public String loginok(String mid, HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("mid", mid);
		session.setMaxInactiveInterval(1800); // 초 단위 (밀리초 아님)
		System.out.println(mid);
		return null;
	}
	*/
	
	@GetMapping("/restapi.do")
	// @SessionAttribute : session이 이미 등록된 상황일 때 해당 정보를 바로 가져올 수 있음
	public String restapi(@SessionAttribute(name = "mid", required = false) String mid) throws Exception {
		if (mid == null) {
			System.out.println("로그인 해야만 결제내역을 확인하실 수 있습니다.");
		}
		else {
			System.out.println(mid + "님의 결제내역은 다음과 같습니다.");
		}
		return null;
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/ajaxok3.do")
	public String ajaxok3(@RequestParam(value="_") String arr, HttpServletResponse res) throws Exception {
		System.out.println(arr);
		//this.pw = res.getWriter();
		//this.pw.print("ok");
		//this.pw.close();
		return null;
	}
	/*
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/ajaxok3.do")
	public String ajaxok3(@RequestBody String arr, HttpServletResponse res) throws Exception {
		JSONArray ja = new JSONArray(arr);
		int w = 0;
		while (w < ja.length()) {
			JSONArray ja_dump = (JSONArray) ja.get(w);
			System.out.println(ja_dump.get(0));
			w++;
		}
		this.pw = res.getWriter();
		this.pw.print("ok");
		this.pw.close();
		return null;
	}
	*/
	
	// @RequestBody : JSON.stringify
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/ajaxok2.do")
	public String ajaxok2(@RequestBody String all_data, HttpServletResponse res) throws Exception {
		JSONObject jo = new JSONObject(all_data);
		JSONArray ja = new JSONArray();
		
		ja = (JSONArray) jo.get("all_data");
		ja = jo.getJSONArray("all_data");
		JSONArray ja1 = new JSONArray();
		System.out.println(ja1);
		
		// Front AJAX : dataType="JSON" => JSON으로 생성하여 전달 
		JSONObject result = new JSONObject();
		result.put("result", "ok");
		this.pw = res.getWriter();
		this.pw.print(result);
		this.pw.close();
		return null;
	}
	
	/*
		@RequestBody : JSON 기반일 때 사용 - 일반적인 GET/POST에서 사용하지 않음
		type이 json이 아닐 때는 @RequestParam 사용
		
		@ResponseBody : 미디어 타입, 파라미터 타입
		-> 메소드 자체 또는 return 타입에 사용 / 메소드 인자값에는 불가능
		
		@RequestParam : 배열을 이용하여 대표키로 전달 또는 대표키 없이 보조키로 전달될 경우 사용
		-> value에 대표 키 이름을 넣어야함
	*/
	// ajax 통신 시 CORS 방식
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/ajaxok.do")
	public String ajaxok(@RequestParam(value = "all_data") List<String> alldata,
			HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();
		System.out.println(alldata);
		JSONObject jo = new JSONObject();
		jo.put("result", "ok");
		this.pw.print(jo);
		this.pw.close();
		return null;
	}
}
