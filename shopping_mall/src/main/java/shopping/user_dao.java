package shopping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class user_dao {
	private int uidx;
	private String uid, upass, uname, uemail, uphone, ckuse_email, ckuse_phone, login_status, uindate;
}
