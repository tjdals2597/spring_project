function idck_ajax() {
	var html = new XMLHttpRequest();
	
	html.onreadystatechange = function() {
		if (html.readyState == 4 && html.status == 200) {
			console.log(this.response);
		}
	}
	html.open("POST", "./adminid_check.do", true);
	html.send("adminid=" + admin_login_frm.amid.value);
}

function js_signsubmit() {
	var mtel = "";
	var mtel1 = document.getElementById("mtel1").value;
	var mtel2 = document.getElementById("mtel2").value;
	var mtel3 = document.getElementById("mtel3").value;
	document.getElementById("mtelsum").value = mtel1 + mtel2 + mtel3;
	
	if (admin_login_frm.amid.value == "") {
		alert("아이디를 입력해주세요.");
	}
	else if (admin_login_frm.ampass.value == "") {
		alert("패스워드를 입력해주세요.");
	}
	else if (admin_login_frm.ampass.value != document.getElementById("ampassck").value) {
		alert("동일한 패스워드를 입력해주세요.");
	}
	else if (admin_login_frm.amname.value == "") {
		alert("이름을 입력해주세요.");
	}
	else if (admin_login_frm.amemail.value == "") {
		alert("이메일을 입력해주세요.");
	}
	else if (admin_login_frm.amphone.value == "") {
		alert("전화번호를 입력해주세요.");
	}
	else {
		if (confirm("작성하신 정보로 회원가입 하시겠습니까?")) {
			admin_login_frm.method = "POST";
			admin_login_frm.action = "./admin_main.do";
			admin_login_frm.submit();
		}
	}
}

function js_signcancel() {
	location.href = "./admin";
}