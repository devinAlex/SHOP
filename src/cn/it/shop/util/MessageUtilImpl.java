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
		//1，打开IE浏览器
		HttpClient client = new HttpClient();
		//2，创建请求的方式，get/post
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		//设置请求的参数信息
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		post.setParameter("Uid", "zg_shop_ms");
		post.setParameter("Key", "42b1b7ffabcc7caf933");
		post.setParameter("smsMob", "18792577179");
		post.setParameter("smsText", "订单123已经支付成功");
		try {
			//提交请求
			int code = 0;
			code = client.executeMethod(post);
			System.out.println("http返回的状态码"+code);
			//获取服务器返回的数据信息
			String result = post.getResponseBodyAsString();
			System.out.println("短信发送结果为：" + result);
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			post.releaseConnection();
		}
	}
}
