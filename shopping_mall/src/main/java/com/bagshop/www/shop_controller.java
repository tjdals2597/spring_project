package com.bagshop.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class shop_controller {

	@GetMapping("/product_list_test.do")
	public String product_list_test() {
		return "product_list_test";
	}
}
