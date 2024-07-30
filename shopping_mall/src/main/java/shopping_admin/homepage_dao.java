package shopping_admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class homepage_dao {
private int signpoint, signlevel, min_pay_points, max_pay_points, delivery_fee_price;
private String hometitle, adminemail, usepointck, compamy_name, business_regist_number, president_name, president_phone,
		mailorder_report_number, telecom_busi_number, business_zipcode, business_address, infomanager_name,
		infomanager_email, non_account_bank, bank_account_number, ckuse_credit_card, ckuse_mobile_phone, ckuse_book_gift_pay,
		ckuse_cash_receipt, delivery_compamy_name, ckuse_desired_deldate;
}
