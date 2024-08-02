package shopping_admin;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class product_controller {

	@Resource(name = "productmodule")
	private product_module pdmd;
	
	PrintWriter pw = null;
	
	@GetMapping("/product_list.do")
	public String product_list(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			@RequestParam(defaultValue = "", required = false) String search_part,
			@RequestParam(defaultValue = "", required = false) String search_word,
			@RequestParam(defaultValue = "", required = false) String pageno, HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			Integer no = (pageno.equals("")) ? 1 : Integer.valueOf(pageno);
			if (search_part.equals("") || search_word.equals("")) {
				m.addAttribute("productlist", this.pdmd.product_search(no));
				m.addAttribute("productcount", this.pdmd.product_count());
			}
			else {
				m.addAttribute("search_part", search_part);
				m.addAttribute("search_word", search_word);
				m.addAttribute("productlist", this.pdmd.product_search(no, search_part, search_word));
				m.addAttribute("productcount", this.pdmd.product_count());
			}
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
			m.addAttribute("catelist", this.pdmd.catelist_search());
		}
		return "product_write";
	}
	
	@GetMapping("/cate_list.do")
	public String cate_list(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			@RequestParam(defaultValue = "", required = false) String search_part,
			@RequestParam(defaultValue = "", required = false) String search_word,
			@RequestParam(defaultValue = "", required = false) String pageno, HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			Integer no = (pageno.equals("")) ? 1 : Integer.valueOf(pageno);
			if (search_part.equals("") || search_word.equals("")) {
				m.addAttribute("categorylist", this.pdmd.category_search(no));
				m.addAttribute("catecount", this.pdmd.category_count());
			}
			else {
				m.addAttribute("search_part", search_part);
				m.addAttribute("search_word", search_word);
				m.addAttribute("categorylist", this.pdmd.category_search(no, search_part, search_word));
				m.addAttribute("catecount", this.pdmd.category_count());
			}
			
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
	
	@PostMapping("checkbox_delete.do")
	public void checkbox_delete(@RequestParam int del_ck[], HttpServletResponse res, String page_ck) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		try {
			this.pw = res.getWriter();
			
			int callback = this.pdmd.del_list_ckbox(del_ck, page_ck);
			if (callback > 0) {
				String pagename = page_ck.equals("category") ? "cate" : page_ck;
				this.pw.print("<script>alert('정상적으로 항목이 삭제되었습니다.'); location.href = './" + pagename + "_list.do';</script>");
			}
			else {
				this.pw.print("<script>alert('오류가 발생하여 정상적으로 처리되지 않았습니다.'); history.go(-1);</script>");
			}
		} catch (Exception e) {
			this.pw.print("<script>alert('상품이 있는 카테고리는 삭제할 수 없습니다.'); history.go(-1);</script>");
		} finally {
			this.pw.close();
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/producode_check.do")
	public void producode_check(@RequestBody(required = false) String product_code,
			HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			int callback = this.pdmd.duplicate_codeck(product_code.split("=")[1]);
			if (callback == 0) {
				this.pw.print("ok");
			}
			else {
				this.pw.print("error");
			}
		} catch (Exception e) {
			this.pw.print("error");
		} finally {
			this.pw.close();
		}
	}
	
	@PostMapping("/product_insert.do")
	public void product_insert(@RequestParam("imgfile") MultipartFile files[], @ModelAttribute product_dao dao,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			dao.setPimages(new files_save().fsave(req, files));
			int callback = this.pdmd.write_product(dao);
			if (callback > 0) {
				this.pw.print("<script>alert('상품이 정상적으로 등록되었습니다.'); location.href = '/product_list.do';</script>");
			}
			else {
				this.pw.print("<script>alert('데이터 오류가 발생하여 정상적으로 처리되지 않았습니다.'); history.go(-1);</script>");
			}
		} catch (Exception e) {
			this.pw.print("<script>alert('오류가 발생하여 정상적으로 처리되지 않았습니다.'); history.go(-1);</script>");
		} finally {
			this.pw.close();
		}
	}
	
	@PostMapping("/cate_writeok.do")
	public void category_insert(@ModelAttribute category_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			int callback = this.pdmd.write_category(dao);
			if (callback > 0) {
				this.pw.print("<script>alert('카테고리가 정상적으로 등록되었습니다.'); location.href = '/cate_list.do';</script>");
			}
			else {
				this.pw.print("<script>alert('데이터 오류가 발생하여 정상적으로 처리되지 않았습니다.'); history.go(-1);</script>");
			}
		} catch (Exception e) {
			this.pw.print("<script>alert('오류가 발생하여 정상적으로 처리되지 않았습니다.'); history.go(-1);</script>");
		} finally {
			this.pw.close();
		}
	}
}