package cn.it.shop.service;


import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryService extends BaseService<Category>{
	//��ѯ�����Ϣ����������Ա
	public List<Category> queryJoinAccount(String type, int page, int size);
	//��ѯ�ܼ�¼��
	public Long getCount(String type);
	//����IDSɾ������
	public void deleteByIds(String ids);
	//����boolean��ѯ�ȵ����ȵ����
	public List<Category> queryByHot(boolean hot);
}
