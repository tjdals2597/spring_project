package shopping_admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("noticemodule")
public class notice_module {

	Map<String, String> keycode = null;
	
	@Resource(name = "shoptemplate")
	private SqlSessionTemplate sstm;
	
	public List<notice_dao> notice_listall() {
		this.keycode = new HashMap<String, String>();
		this.keycode.put("part", "1");
		return this.sstm.selectList("shopnotice.all_notice_select", this.keycode);
	}
	
	public int submit_notice(notice_dao dao) {
		return this.sstm.insert("shopnotice.notice_write", dao);
	}
	
	public void add_view_count(int nidx) {
		this.sstm.update("shopnotice.add_views", nidx);
	}
}
