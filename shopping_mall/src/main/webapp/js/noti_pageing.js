function go_wpage() {
	location.href = "./notice_write.do";
}

function js_selectpage(no) {
	location.href = "./notice_list.do?page=" + no;
}

function page_prev(no) {
	location.href = "./notice_list.do?page=" + no;
}

function page_next(no) {
	location.href = "./notice_list.do?page=" + no;
}

function double_prev() {
	location.href = "./notice_list.do?page=1";
}

function double_next(no) {
	location.href = "./notice_list.do?page=" + Number(no);
}