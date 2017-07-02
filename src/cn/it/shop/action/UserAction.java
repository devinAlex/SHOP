package cn.it.shop.action;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.User;

/**
 * 
 * @author Administrator
 * 
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	public  String login(){
		model = userService.login(model);
		if(model==null){
			session.put("error", "��¼ʧ��");
			return "ulogin";
		}else{
			//��¼�ɹ� ���ȴ洢��session,�ٸ������������Ӧ��ҳ��
			session.put("user", model);
			//����session��goURL�Ƿ���ֵ����ҳ�����ת
			if(session.get("goURL")==null){
				return "index";
			}else{
				return "goURL";
			}
		}
	}
}
