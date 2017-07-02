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
		//��¼�ʼ��ͻ��ˣ������ỰSession��
		Properties prop = new Properties();
		Session session = null;
		Message message = null;
		Transport transport = null;
		try{
			prop.setProperty("mail.transport.protocol", "smtp");
			//������session�ػ�
			session = Session.getDefaultInstance(prop);
			//����debugģʽ���Է�����Ϣ
			session.setDebug(true);
			//����һ���ʼ�����
			message = new MimeMessage(session);
			//д��
			message.setSubject("����֧���ɹ��ʼ���");
			message.setContent("����"+id+"�Ѿ�֧���ɹ���", "text/html;charset=utf-8");
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
		//��¼�ʼ��ͻ��ˣ������ỰSession��
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		//������session�ػ�
		Session session = Session.getDefaultInstance(prop);
		//����debugģʽ���Է�����Ϣ
		session.setDebug(true);
		//����һ���ʼ�����
		Message message = new MimeMessage(session);
		//д��
		message.setSubject("����֧���ɹ��ʼ���");
		message.setContent("����123456�Ѿ�֧���ɹ���", "text/html;charset=utf-8");
		message.setFrom(new InternetAddress("soft03_test@sina.com"));
		Transport transport = session.getTransport();
		transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
		transport.sendMessage(message, new Address[]{new InternetAddress("soft03_test@sina.com")});
		transport.close();
	}
}
