package shopping;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("membermodule")
public class member_module {

	@Resource(name = "shoptemplate")
	private SqlSessionTemplate sstm;
	
	public List<String> mlist_select() {
		return null;
	}
}
