package shopping;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import shopping_admin.product_dao;

public class json_maker {

	public String getProductList(List<product_dao> productList) {
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		
		for (product_dao pdto : productList) {
			JSONObject jo_dump = new JSONObject();
			jo_dump.put("pidx", pdto.getPidx());
			jo_dump.put("pcode", pdto.getPcode());
			jo_dump.put("pname", pdto.getPname());
			jo_dump.put("original_price", pdto.getOriginal_price());
			jo_dump.put("discount_price", pdto.getDiscount_price());
			jo_dump.put("pimages", pdto.getPimages());
			ja.put(jo_dump);
		}
		jo.put("product", ja);
		return jo.toString();
	}
}
