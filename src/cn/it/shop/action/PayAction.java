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
 * struts�������̣���ȡ������ȴ���Action�������������ʱ��˳�㴴����Action��ִ��18����������������ִ�гɹ��ڵ���Action����
 * action����ִ����Ϻ��ڷ��ص���������
 * 
 * ���� Action ---��serletConfig ----��modelDriven
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
		//1,��ȫ����
		Forder forder = (Forder)session.get("oldForder");
		User user = (User)session.get("user");
		senddata.setP2_Order(forder.getId().toString());
		senddata.setP3_Amt(forder.getTotal().toString());
		senddata.setPa_MP(user.getEmail()+","+user.getPhone());
		//model.setPa_MP(forder.get)
		//2���Բ�������׷��
		//3�����ܻ�ȡǩ��
		//4���洢��request����
		payService.saveDataToRequest(request, senddata);
		//5����ת��֧��ҳ��
		return "pay";
	}
	public void backBank(){
		BackData backData = (BackData)model;
		
		 boolean isOk = payService.checkBackData(backData);
		if(isOk){
			//1�����¶���״̬
			forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 2);
			//2������user�����ַ�������ʼ�
			String address = backData.getR8_MP().split(",")[0];
			emailUtil.sendMail(address, backData.getR6_Order());
			//3�������ֻ�����
			String number = backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(number, backData.getR6_Order());
		}else{
			System.out.println();
		}
	}
}
