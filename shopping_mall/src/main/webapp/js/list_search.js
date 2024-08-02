function js_search(page) {
	var frm_url = "";
	search_frm.method = "GET";
	if (search_frm.search_word.value == "") {
		frm_url = "./" + page + "_list.do"
	}
	else {
		frm_url = "./" + page + "_list.do?search_part="
				+ search_frm.search_part.value
				+ "&search_word="
				+ search_frm.search_word.value;
	}
	search_frm.action = frm_url;
	return true;
}