package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Status;
import cn.it.shop.model.User;

@Controller
@Scope("prototype")
public class ForderAcion extends BaseAction<Forder> {
//	@Override
//	public Forder getModel(){
//		model = (Forder)session.get("forder");
//		return model;
//	}
	
	//实现购物车（订单）与购物项（订单项）级联入库功能
	public String save(){
		Forder forder = (Forder)session.get("forder");
		
		forder.setAddress(model.getAddress());
		forder.setName(model.getName());
		forder.setPhone(model.getPhone());
		forder.setRemark(model.getRemark());
		forder.setUser((User)session.get("user"));
		forder.setStatus(new Status(1));
		forder.setPost(model.getPost());
		
		forderService.save(forder);
		session.put("oldForder", session.get("forder"));
		//此时购物车已经入库，那么原来session中的购物车就应该清空
		session.put("forder", new Forder());
		return "bank";
	}
}
