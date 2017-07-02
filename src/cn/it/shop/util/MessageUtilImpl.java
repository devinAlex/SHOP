package cn.it.shop.util;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {
	/* (non-Javadoc)
	 * @see cn.it.shop.util.MessageUtil#sendMessage(java.lang.String, java.lang.String)
	 */
	public void sendMessage(String number,String sid){
		//1����IE�����
		HttpClient client = new HttpClient();
		//2����������ķ�ʽ��get/post
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		//��������Ĳ�����Ϣ
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		post.setParameter("Uid", "zg_shop_ms");
		post.setParameter("Key", "42b1b7ffabcc7caf933");
		post.setParameter("smsMob", "18792577179");
		post.setParameter("smsText", "����123�Ѿ�֧���ɹ�");
		try {
			//�ύ����
			int code = 0;
			code = client.executeMethod(post);
			System.out.println("http���ص�״̬��"+code);
			//��ȡ���������ص�������Ϣ
			String result = post.getResponseBodyAsString();
			System.out.println("���ŷ��ͽ��Ϊ��" + result);
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			post.releaseConnection();
		}
	}
}
