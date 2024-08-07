package shopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("usermodule")
public class user_module {

	Map<String, String> keycode = null;
	
	@Resource(name = "shoptemplate")
	private SqlSessionTemplate sstm;
	
	public List<malluser_dao> ulist_select() {
		return this.sstm.selectList("shopuser.user_search");
	}
	
	public int loginck_update(String uidx, String ck) {
		this.keycode = new HashMap<String, String>();
		this.keycode.put("uidx", uidx);
		this.keycode.put("ck", ck);
		return this.sstm.update("shopuser.userlogin_ck_update", this.keycode);
	}
}
