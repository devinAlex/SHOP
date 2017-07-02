package cn.it.shop.dao;


import java.util.List;

import cn.it.shop.model.Product;

public interface ProductDao extends BaseDao<Product>{
	public List<Product> queryJoinCategory(String name, int page, int size);
	
	//��ѯ�ܼ�¼��
	public Long getCount(String name);
	//�����ȵ���𣬲�ѯ��ǰ����Ƽ���Ʒ��������ѯǰ4����
	public List<Product> queryByCid(int cid);
}
