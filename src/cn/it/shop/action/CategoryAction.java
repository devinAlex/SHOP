package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author Administrator
 */
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{
	public String queryJoinAccount(){
		pageMap = new HashMap<String, Object>();
		System.out.println("type:"+model.getType());
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList);
		pageMap.put("total", categoryService.getCount(model.getType()));
		
		return "jsonMap";
	}
	public String deleteByIds(){
		System.out.println("É¾³ýidsÎª£º"+ids);
		categoryService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	public void save(){
		System.out.println(model);
		categoryService.save(model);
	}
	public void update(){
		System.out.println(model);
		categoryService.update(model);
	}
	public String query(){
		jsonList = categoryService.query();
		return "jsonList";
	}
}
