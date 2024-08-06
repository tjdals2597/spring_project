package shopping;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("usermodule")
public class user_module {

	@Resource(name = "shoptemplate")
	private SqlSessionTemplate sstm;
	
	public List<malluser_dao> ulist_select() {
		return this.sstm.selectList("shopuser.user_search");
	}
}
