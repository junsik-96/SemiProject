package semiproject.common.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import semiproject.common.code.Code;
import semiproject.common.code.ErrorCode;
import semiproject.common.exception.ToAlertException;

public class MailSender {
	
	//1. Session 객체 생성
	
	//2. MimeMessage 작성
	//	* Message header 작성
	//	* multipart 객체 생성
	//	* Message body 작성
	
	public void sendEmail(String to, String subject, String htmlText) {
		
		try {
			MimeMessage msg = new MimeMessage(getSession());
			
			msg.setFrom(new InternetAddress(Code.EMAIL.desc));
			msg.setRecipients(Message.RecipientType.TO, to);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setContent(getMultipart(htmlText)); //message의 바디에 추가
			
			Transport.send(msg); //전송
			
		} catch (MessagingException mex) {
			throw new ToAlertException(ErrorCode.MAIL01,mex);
		}

	}
	
	public Session getSession() {
		//1. smtp 통신을 위한 Session 객체 생성
		//인증정보 저장
		PasswordAuthentication pa = new PasswordAuthentication(Code.EMAIL.desc, "happy75310*");
		
		//2. 통신할 smtp 서버 설정 작성
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return pa;
			}
		});
		
		return session;
	}
	
	private Multipart getMultipart(String htmlText) throws MessagingException {
		
		Multipart mp = new MimeMultipart();
		MimeBodyPart htmlPart = new MimeBodyPart();
		
		//보내고 싶은 html 코드 작성
		//contentType 작성
		htmlPart.setContent(htmlText, "text/html; charset=UTF-8");
		//Multipart 객체에 추가
		mp.addBodyPart(htmlPart);
		
		return mp;
	}
	
	
}
