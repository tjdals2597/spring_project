package shopping_admin;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class product_controller {

	@Resource(name = "productmodule")
	private product_module pdmd;
	
	PrintWriter pw = null;
	
	@GetMapping("/product_list.do")
	public String product_list(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			m.addAttribute("productlist", "");
		}
		return "product_list";
	}
	
	@GetMapping("/product_write.do")
	public String product_write(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			m.addAttribute("catelist", "");
		}
		return "product_write";
	}
	
	@GetMapping("/cate_list.do")
	public String cate_list(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			@RequestParam(defaultValue = "", required = false) String pageno, HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			Integer no = (pageno.equals("")) ? 1 : Integer.valueOf(pageno);
			m.addAttribute("categorylist", this.pdmd.category_search(no));
		}
		return "cate_list";
	}
	
	@GetMapping("/cate_write.do")
	public String cate_write(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			m.addAttribute("menulist", this.pdmd.catemenu_search());
		}
		return "cate_write";
	}
}
