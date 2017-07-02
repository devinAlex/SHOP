package cn.it.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.util.FileUpload;
import cn.it.shop.util.ProductTimerTask;
/**
 * ������Ŀ����ʱ�����ݳ�ʼ��
 * @author Administrator
 *
 */
public class InitDataListener implements ServletContextListener {
	private ApplicationContext context = null;
	private ProductTimerTask productTimerTask = null;
	private FileUpload fileUpload = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
			//1,��ȡҵ���߼����ѯ��Ʒ��Ϣ
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productTimerTask = (ProductTimerTask)context.getBean("productTimerTask");
		fileUpload = (FileUpload)context.getBean("fileUpload");
		productTimerTask.setApplication(event.getServletContext());
		//ͨ�����ö�ʱ��������ҳ������ÿ��һСʱͬ��һ�Σ�Ҫ����Ϊ�ػ��̣߳�
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
		//��Ŀ����ʱ��Ҫ�������е�ͼ��
		event.getServletContext().setAttribute("bankList", fileUpload.getBankImage());
	}

}
