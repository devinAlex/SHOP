package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

/**
 * 
 * @author Administrator
 * 
 */
@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder>{
	//根据商品编号更新商品的数量
	public String updateSorder(){
		Forder forder = (Forder)session.get("forder");
		forder = sorderService.updateSorder(forder, model);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder", forder);
		inputStream = new ByteArrayInputStream(forder.getTotal().toString().getBytes());
		return "stream";
	}
	
	public String querySale(){
		List<Object> jsonList = sorderService.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
	public String addSorder(){
		//1，根据product.id获取相应的商品数据
		Product product = productService.get(model.getProduct().getId());
		//2，判断当前session是否有购物车，如果没有则创建
		if(session.get("forder")==null){
			//创建新的购物车  存储到session中
			session.put("forder", new Forder(new ArrayList<Sorder>()));
		}
		Forder forder = (Forder)session.get("forder");
		//3，把商品信息转化为sorder，并且添加到购物车中（判断购物项是否重复）
		forder = sorderService.addSorder(forder, product);
		
		//4，计算购物的总价格
		forder.setTotal(forderService.cluTotal(forder));
		
		session.put("forder", forder);
		return "showCar";
	}
	
}
