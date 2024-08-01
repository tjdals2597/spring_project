package shopping_admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("productmodule")
public class product_module {

	@Resource(name = "shoptemplate")
	private SqlSessionTemplate sstm;
	
	public List<String> catemenu_search() {
		return this.sstm.selectList("cateproduct.select_category");
	}
	
	public List<category_dao> category_search(Integer no) {
		Map<String, Integer> keycode = new HashMap<String, Integer>();
		keycode.put("no", (no - 1) * 10);
		return this.sstm.selectList("cateproduct.select_cateall", keycode);
	}
	
	public List<category_dao> catelist_search() {
		return this.sstm.selectList("cateproduct.catelist_pwpage");
	}
	
	public int duplicate_codeck(String pcode) {
		return this.sstm.selectOne("cateproduct.select_product", pcode);
	}
	
	public int write_product(product_dao dao) {
		return this.sstm.insert("cateproduct.insert_product", dao);
	}
}
