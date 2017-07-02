package cn.it.shop.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;
@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil {
	/* (non-Javadoc)
	 * @see cn.it.shop.util.MessageUtil#sendMail(java.lang.String, java.lang.String)
	 */
	public void sendMail(String address, String id){
		//登录邮件客户端（创建会话Session）
		Properties prop = new Properties();
		Session session = null;
		Message message = null;
		Transport transport = null;
		try{
			prop.setProperty("mail.transport.protocol", "smtp");
			//创建了session回话
			session = Session.getDefaultInstance(prop);
			//设置debug模式调试发送信息
			session.setDebug(true);
			//创建一封邮件对象
			message = new MimeMessage(session);
			//写信
			message.setSubject("订单支付成功邮件！");
			message.setContent("订单"+id+"已经支付成功！", "text/html;charset=utf-8");
			message.setFrom(new InternetAddress("soft03_test@sina.com"));
			transport = session.getTransport();
			transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
			transport.sendMessage(message, new Address[]{new InternetAddress(address)});
		}catch(Exception e){
			throw  new RuntimeException(e);
		}finally{
			try {
				transport.close();
			} catch (MessagingException e) {
				throw  new RuntimeException(e);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		//登录邮件客户端（创建会话Session）
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		//创建了session回话
		Session session = Session.getDefaultInstance(prop);
		//设置debug模式调试发送信息
		session.setDebug(true);
		//创建一封邮件对象
		Message message = new MimeMessage(session);
		//写信
		message.setSubject("订单支付成功邮件！");
		message.setContent("订单123456已经支付成功！", "text/html;charset=utf-8");
		message.setFrom(new InternetAddress("soft03_test@sina.com"));
		Transport transport = session.getTransport();
		transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
		transport.sendMessage(message, new Address[]{new InternetAddress("soft03_test@sina.com")});
		transport.close();
	}
}
