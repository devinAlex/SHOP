package cn.it.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.util.FileUpload;
import cn.it.shop.util.ProductTimerTask;
/**
 * 用于项目启动时候数据初始化
 * @author Administrator
 *
 */
public class InitDataListener implements ServletContextListener {
	private ApplicationContext context = null;
	private ProductTimerTask productTimerTask = null;
	private FileUpload fileUpload = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
			//1,获取业务逻辑类查询商品信息
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productTimerTask = (ProductTimerTask)context.getBean("productTimerTask");
		fileUpload = (FileUpload)context.getBean("fileUpload");
		productTimerTask.setApplication(event.getServletContext());
		//通过设置定时器，让首页的数据每隔一小时同步一次（要配置为守护线程）
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
		//项目启动时候要加载银行的图标
		event.getServletContext().setAttribute("bankList", fileUpload.getBankImage());
	}

}
