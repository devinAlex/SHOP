package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.BackData;
import cn.it.shop.model.Forder;
import cn.it.shop.model.SendData;
import cn.it.shop.model.User;

/**
 * 
 * struts处理流程：获取请求后，先创建Action代理，创建代理的时候顺便创建了Action，执行18个拦截器。拦截器执行成功在调用Action方法
 * action方法执行完毕后，在返回调用拦截器
 * 
 * 创建 Action ---》serletConfig ----》modelDriven
 */
@Controller
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware{
	private Map<String,String[]> parameters;
	
	@Override
	public Object getModel(){
		if(parameters.get("pd_FrpId")!=null){
			model = new SendData();
		}else{
			model = new BackData();
		}
		return model;
	}
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
		
	}
	public String gobank(){
		SendData senddata = (SendData)model;
		//1,补全参数
		Forder forder = (Forder)session.get("oldForder");
		User user = (User)session.get("user");
		senddata.setP2_Order(forder.getId().toString());
		senddata.setP3_Amt(forder.getTotal().toString());
		senddata.setPa_MP(user.getEmail()+","+user.getPhone());
		//model.setPa_MP(forder.get)
		//2，对参数进行追加
		//3，加密获取签名
		//4，存储到request域中
		payService.saveDataToRequest(request, senddata);
		//5，跳转到支付页面
		return "pay";
	}
	public void backBank(){
		BackData backData = (BackData)model;
		
		 boolean isOk = payService.checkBackData(backData);
		if(isOk){
			//1，更新订单状态
			forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 2);
			//2，根据user邮箱地址，发送邮件
			String address = backData.getR8_MP().split(",")[0];
			emailUtil.sendMail(address, backData.getR6_Order());
			//3，发送手机短信
			String number = backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(number, backData.getR6_Order());
		}else{
			System.out.println();
		}
	}
}
