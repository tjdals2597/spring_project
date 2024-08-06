function go_wpage() {
	location.href = "./notice_write.do";
}

function js_selectpage(no) {
	location.href = "./notice_list.do?page=" + no;
}

function page_prev(no) {
	location.href = "./notice_list.do?page=" + (Number(no) - 1);
}

function page_next(no) {
	location.href = "./notice_list.do?page=" + (Number(no) + 1);
}

function double_prev(no) {
	location.href = "./notice_list.do?page=" + no + "&doublep=prev";
}

function double_next(no) {
	location.href = "./notice_list.do?page=" + no + "&doublep=next";
}