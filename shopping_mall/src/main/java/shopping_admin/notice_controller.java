package shopping_admin;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class notice_controller {

	@Resource(name = "noticemodule")
	private notice_module ntmd;
	
	PrintWriter pw = null;
	
	@GetMapping("/notice_list.do")
	public String notice_list(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			m.addAttribute("noticelist", this.ntmd.notice_listall());
		}
		return "notice_list";
	}
	
	@GetMapping("/notice_write.do")
	public String notice_write(@SessionAttribute(required = false, name = "adminSessionData") ArrayList<Object> adata,
			HttpServletResponse res, Model m) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		if (adata == null) {
			this.pw = res.getWriter();
			this.pw.print("<script>alert('올바른 접근 방식이 아닙니다.'); location.href = './admin';</script>");
			this.pw.close();
		}
		else {
			m.addAttribute("loginIdx", adata.get(0));
			m.addAttribute("loginName", adata.get(3));
		}
		return "notice_write";
	}
	
	@PostMapping("/notice_writeok.do")
	public void notice_writeok(@RequestParam("mfile") MultipartFile nfile, @ModelAttribute notice_dao dao,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		this.pw = res.getWriter();
		try {
			if (dao.getAlert_ck() == null) {
				dao.setAlert_ck("N");
			}
			dao.setNfile(new files_save().fsave(req, nfile, "/notice_file/"));
			int callback = this.ntmd.submit_notice(dao);
			if (callback > 0) {
				this.pw.print("<script>alert('공지사항이 정상적으로 등록되었습니다.'); location.href = '/notice_list.do';</script>");
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
	
	@GetMapping("/notice_view") // 미완성 - 글 페이지 추가 시 업데이트
	public String notice_view(@RequestParam int nidx) throws Exception {
		this.ntmd.add_view_count(nidx);
		return "notice_view";
	}
}
