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
			session.put("error", "登录失败");
			return "ulogin";
		}else{
			//登录成功 ，先存储到session,再根据情况返回相应的页面
			session.put("user", model);
			//根据session中goURL是否有值决定页面的跳转
			if(session.get("goURL")==null){
				return "index";
			}else{
				return "goURL";
			}
		}
	}
}
