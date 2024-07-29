package shopping_admin;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class main_controller extends password_sha3 {

	@Resource(name = "adminmodule")
	private admin_module admd;
	
	PrintWriter pw = null;
	
	@GetMapping("/admin")
	public String adminmain() {
		return "admin_index";
	}
	
	@PostMapping("/adminid_check.do")
	public void adminid_check(@RequestBody(required = false) String adminid,
			HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			String callback = this.admd.duplicate_idck(adminid.split("=")[1]);
			this.pw.print(callback);
		} catch (Exception e) {
			this.pw.print("error");
		} finally {
			this.pw.close();
		}
	}
	
	@PostMapping("/admin_main.do")
	public void admin_main(@ModelAttribute admin_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			dao.setAmpass(this.encodePass(dao.getAmpass()));
			int callback = this.admd.admin_signup(dao);
			if (callback > 0) {
				this.pw.print("<script>alert('회원가입이 성공적으로 완료되었습니다.\n"
						+ "최고 관리자의 승인 이후 로그인이 가능합니다.'); location.href = './admin_index.jsp';</script>");
			}
		} catch (Exception e) {
			this.pw.print("<script>alert('오류가 발생하여 회원가입이 실패하였습니다.'); history.go(-1);</script>");
		} finally {
			this.pw.close();
		}
	}
	
	@PostMapping("/admin_loginok.do")
	public void admin_loginok(String login_id, String login_pw,
			HttpServletResponse res, HttpSession htss) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			admin_dao admindao = this.admd.admin_login(login_id, this.encodePass(login_pw));
			if (admindao != null) {
				htss.setAttribute("admindata", admindao.toSessionList());
				this.pw.print("<script>alert('로그인 성공하셨습니다.'); location.href = './admin_list.do';</script>");
			}
		} catch (Exception e) {
			this.pw.print("<script>alert('아이디 및 패스워드를 확인해주세요.'); history.go(-1);</script>");
		} finally {
			this.pw.close();
		}
	}
	
	@GetMapping("/admin_logout.do")
	public void admin_logout(HttpSession htss, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			htss.removeAttribute("admindata");
			htss.setMaxInactiveInterval(1800);
			this.pw.print("<script>alert('로그아웃 하셨습니다.'); location.href = './admin';</script>");
		} catch (Exception e) {
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); history.go(-1);</script>");
		} finally {
			this.pw.close();
		}
	}
	
	@GetMapping("/admin_list.do")
	public String admin_list(@SessionAttribute(required = false, name = "admindata") ArrayList<Object> adata,
			HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null || !String.valueOf(adata.get(1)).equals("1")) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); history.go(-1);</script>");
			this.pw.close();
		}
		else {
			m.addAttribute("adminlist", this.admd.list_select());
		}
		return "admin_list";
	}
}