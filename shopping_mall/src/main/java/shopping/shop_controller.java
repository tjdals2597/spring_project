package shopping;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class shop_controller {

	@Resource(name = "usermodule")
	private user_module usmd;
	
	PrintWriter pw = null;
	
	@GetMapping("/agree")
	public String shop_agree() {
		return "agree";
	}
	@GetMapping("/join")
	public String shop_join() {
		return "join";
	}
	@GetMapping("/login")
	public String shop_login() {
		return "login";
	}
	@GetMapping("/admin_main.do")
	public String admin_main(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			HttpServletRequest req, HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			m.addAttribute("userlist", this.usmd.ulist_select());
		}
		return "shop_member_list";
	}
	
	@PostMapping("/userlogin_update.do")
	public void userlogin_update(String loginck, String valueck, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			int callback = this.usmd.loginck_update(loginck, valueck);
			if (callback > 0) {
				this.pw.print("<script>alert('정상적으로 변경하셨습니다.'); location.href = './admin_main.do';</script>");
			}
		} catch (Exception e) {
			this.pw.print("<script>alert('오류가 발생하여 정상적으로 변경되지 않았습니다.'); history.go(-1);</script>");
		} finally {
			this.pw.close();
		}
	}
}
