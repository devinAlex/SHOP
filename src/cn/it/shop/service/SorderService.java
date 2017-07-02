package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;




public interface SorderService extends BaseService<Sorder>{
	//计算购物总价格
	public Forder addSorder(Forder forder, Product product);
	//把product数据转化Sorder
	public Sorder productToSorder(Product product);
	
	public Forder updateSorder(Forder forder, Sorder sorder);
	//查询热点商品的销售量
	public List<Object> querySale(int number);
	
	
}
