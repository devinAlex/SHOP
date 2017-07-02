package cn.it.shop.service;


import java.util.List;

import cn.it.shop.model.Product;

public interface ProductService extends BaseService<Product>{
	public List<Product> queryJoinCategory(String name, int page, int size);
	
	//��ѯ�ܼ�¼��
	public Long getCount(String name);
	//�����ȵ���𣬲�ѯ��ǰ����Ƽ���Ʒ��������ѯǰ4����
	public List<Product> queryByCid(int cid);
}
