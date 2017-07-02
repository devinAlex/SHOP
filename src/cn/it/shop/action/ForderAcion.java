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
	
	//ʵ�ֹ��ﳵ���������빺��������������⹦��
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
		//��ʱ���ﳵ�Ѿ���⣬��ôԭ��session�еĹ��ﳵ��Ӧ�����
		session.put("forder", new Forder());
		return "bank";
	}
}
