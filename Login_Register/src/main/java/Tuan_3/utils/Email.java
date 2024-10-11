package Tuan_3.utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import Tuan_3.models.UserModel;

public class Email {
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d",number);
	}
	public boolean sendEmail (UserModel user) {
		boolean test = false;
		String toEmail = user.getEmail();
		String fromEmail ="duongthanhson2004@gmail.com";
		String password = "123456";
		try {
			Properties pr= configEmail(new Properties());
			Session session = Session.getInstance(pr,new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication (fromEmail,password);
				}
			});
		Message mess = new MimeMessage (session);
		mess.setHeader("Content-Type","text/plain; charset=UTF-8");
		mess.setFrom (new InternetAddress(fromEmail));
		mess.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
		mess.setSubject("Yours Password");
		mess.setText("Password: "+user.getPassWord());
		Transport.send(mess);
		test=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return test;
		
	}
	public boolean sendMail (UserModel user) {
		boolean test = false;
		String toEmail = user.getEmail();
		String fromEmail ="duongthanhson2004@gmail.com";
		String password = "123456";
		try {
			Properties pr= configEmail(new Properties());
			Session session = Session.getInstance(pr,new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication (fromEmail,password);
				}
			});
		Message mess = new MimeMessage (session);
		mess.setHeader("Content-Type","text/plain; charset=UTF-8");
		mess.setFrom (new InternetAddress(fromEmail));
		mess.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
		mess.setSubject("Confirm Code");
		mess.setText("Your is code: "+user.getCode());
		Transport.send(mess);
		test=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return test;
		
	}
	public Properties configEmail(Properties pr) {
		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
		pr.setProperty("mail.smtp.port", "587");
		pr.setProperty("mail.smtp.auth","true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.put("mail.smtp.socketFactory.port", "587");
		pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
		return pr;
		
	}
}
