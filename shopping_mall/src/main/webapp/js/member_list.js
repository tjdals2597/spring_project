function ajax_second() {
	var html2 = new XMLHttpRequest();
	html2.onreadystatechange = function() {
		if (html2.readyState == 4 && html2.status == 200) {
			mlist_pagefrm.agree_info.value = this.response;
		}
	}
	html2.open("GET", "./get_agree.do?agree=info", true);
	html2.send();
}

var html1 = new XMLHttpRequest();
html1.onreadystatechange = function() {
	if (html1.readyState == 4 && html1.status == 200) {
		mlist_pagefrm.agree_use.value = this.response;
	}
}
html1.open("GET", "./get_agree.do?agree=use", true);
html1.send();

setTimeout(ajax_second, 10);

function useck_update() {
	if (mlist_pagefrm.agree_use.value == "") {
		alert("이용약관을 작성해야 수정할 수 있습니다.");
		mlist_pagefrm.agree_use.focus();
	}
	else {
		if (confirm("정말로 이용약관을 수정하시겠습니까?")) {
			mlist_pagefrm.agree_ck.value = "use";
			mlist_pagefrm.method = "POST";
			mlist_pagefrm.action = "./agree_update.do";
			mlist_pagefrm.submit();
		}
	}
}

function infock_update() {
	if (mlist_pagefrm.agree_info.value == "") {
		alert("개인정보 약관을 작성해야 수정할 수 있습니다.");
		mlist_pagefrm.agree_info.focus();
	}
	else {
		if (confirm("정말로 개인정보 약관을 수정하시겠습니까?")) {
			mlist_pagefrm.agree_ck.value = "info";
			mlist_pagefrm.method = "POST";
			mlist_pagefrm.action = "./agree_update.do";
			mlist_pagefrm.submit();
		}
	}
}