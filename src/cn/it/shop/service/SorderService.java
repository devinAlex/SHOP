package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;




public interface SorderService extends BaseService<Sorder>{
	//���㹺���ܼ۸�
	public Forder addSorder(Forder forder, Product product);
	//��product����ת��Sorder
	public Sorder productToSorder(Product product);
	
	public Forder updateSorder(Forder forder, Sorder sorder);
	//��ѯ�ȵ���Ʒ��������
	public List<Object> querySale(int number);
	
	
}
