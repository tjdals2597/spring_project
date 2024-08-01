package shopping_admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("productmodule")
public class product_module {

	Map<String, String> keycode = null;
	
	@Resource(name = "shoptemplate")
	private SqlSessionTemplate sstm;
	
	public List<String> catemenu_search() {
		return this.sstm.selectList("cateproduct.select_category");
	}
	
	public List<category_dao> category_search(Integer no) {
		Map<String, Integer> keycodeno = new HashMap<String, Integer>();
		keycodeno.put("no", (no - 1) * 10);
		return this.sstm.selectList("cateproduct.select_cateall", keycodeno);
	}
	
	public int category_count() {
		this.keycode = new HashMap<String, String>();
		this.keycode.put("table", "category");
		return this.sstm.selectOne("cateproduct.select_count", this.keycode);
	}
	
	public List<product_dao> product_search(Integer no) { // 미완성
		Map<String, Integer> keycodeno = new HashMap<String, Integer>();
		keycodeno.put("no", (no - 1) * 10);
		return this.sstm.selectList("cateproduct.select_prodall", keycodeno);
	}
	
	public int product_count() {
		this.keycode = new HashMap<String, String>();
		this.keycode.put("table", "product");
		return this.sstm.selectOne("cateproduct.select_count", this.keycode);
	}
	
	public List<category_dao> catelist_search() {
		return this.sstm.selectList("cateproduct.catelist_pwpage");
	}
	
	public int duplicate_codeck(String code) {
		this.keycode = new HashMap<String, String>();
		this.keycode.put("part", "1");
		this.keycode.put("table", "category");
		this.keycode.put("pcode", code);
		return this.sstm.selectOne("cateproduct.select_count", this.keycode);
	}
	
	public int write_product(product_dao dao) {
		return this.sstm.insert("cateproduct.insert_product", dao);
	}
	
	public int write_category(category_dao dao) {
		return this.sstm.insert("cateproduct.insert_category", dao);
	}
}
