var security = "";

function make_security_code() {
	security = "";
	var w = 0;
	while (w < 8) {
		security += Math.round(Math.random() * 9);
		w++;
	}
}

document.querySelector("#duplidBtn").addEventListener("click", function() {
	fetch("./user_duplid.do?id=" + document.querySelector("#user_id").value)
		.then(function(data) {
			return data.text();
		}).then(function(data) {
			if (data == "ok") {
				if (confirm("사용 가능한 아이디입니다.\n이 아이디를 사용하시겠습니까?")) {
					document.querySelector("#user_id").readOnly = true;
				}
			}
			else {
				alert("사용 불가능한 아이디입니다.");
			}
		}).catch(function() {
			alert("오류가 발생하였습니다.\n다시 시도해주세요.");
		});
});

document.querySelector("#emailCheckBtn").addEventListener("click", function() {
	make_security_code();
	fetch("./user_emailAuth.do", {
			method : "POST",
			headers : {"content-type" : "application/json"},
			mode : "no-cors",
			body : JSON.stringify({
				user_email : document.querySelector("#user_email").value,
				security_code : security
			})
		}).then(function(data) {
			return data.text();
		}).then(function(data) {
			console.log(data);
		}).catch(function() {
			alert("오류가 발생하였습니다.\n다시 시도해주세요.");
		});
});

document.querySelector("#btnNextStep").addEventListener("click", function() {
	if (!join_frm.uid.readOnly || join_frm.uid.value == "") {
		alert("아이디 중복 체크를 진행해주세요.");
		join_frm.uid.focus();
	}
	else if (join_frm.upass.value == "") {
		alert("비밀번호를 입력해주세요.");
		join_frm.upass.focus();
	}
	else if (join_frm.upass.value != document.getElementById("pass_ck").value) {
		alert("동일한 비밀번호를 입력해주세요.");
		join_frm.upass.focus();
	}
	else if (join_frm.uname.value == "") {
		alert("이름을 입력해주세요.");
		join_frm.uname.focus();
	}
	else if (join_frm.uemail.value == "") {
		alert("이메일을 입력해주세요.");
		join_frm.uemail.focus();
	}
	else if (join_frm.uphone.value == "") {
		alert("전화번호를 입력해주세요.");
		join_frm.uphone.focus();
	}
	else {
		if (confirm("작성하신 정보로 회원가입 하시겠습니까?")) {
			join_frm.method = "POST";
			join_frm.action = "./user_signup.do";
			join_frm.submit();
		}
	}
});