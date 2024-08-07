package shopping;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class shop_controller {

	@Resource(name = "usermodule")
	private user_module usmd;
	
	PrintWriter pw = null;
	
	@GetMapping("/")
	public String shop_main() {
		return "agree";
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
}
