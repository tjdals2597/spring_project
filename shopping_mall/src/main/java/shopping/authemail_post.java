package shopping;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class authemail_post {
	private Properties prpt = new Properties();
	private String rscSession = "mail_post.properties";
	private String user_email = "";
	private String securitycode = "";
	private Session ss = null;
	private String subject = "메일 제목";
	private String mailtext = "메일 인증번호 : ";
	
	public authemail_post(String em, String se) {
		this.user_email = em;
		this.securitycode = se;
	}
	public int post_execute() {
		int result = 0;
		try {
			System.out.println(this.getClass().getClassLoader());
			/*
			String login_user = "";
			String login_password = "";
			this.prpt.load(this.getClass().getClassLoader().getResourceAsStream(this.rscSession));
			this.ss = Session.getDefaultInstance(this.prpt, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(login_user, login_password);
				}
			});
			MimeMessage msg = new MimeMessage(this.ss);
			msg.setFrom(new InternetAddress(this.prpt.getProperty("frommail"), this.prpt.getProperty("fromname")));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(this.user_email));
			msg.setSubject(this.subject);
			msg.setText(this.mailtext + this.securitycode);
			Transport.send(msg);
			
			*/
			result = 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
