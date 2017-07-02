package cn.it.shop.dao;


import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryDao extends BaseDao<Category>{
	//查询类别信息，级联管理员
	public List<Category> queryJoinAccount(String type, int page, int size);
	//查询总记录数
	public Long getCount(String type);
	//根据IDS删除数据
	public void deleteByIds(String ids);
	//根据boolean查询热点或非热点类别
	public List<Category> queryByHot(boolean hot);
}
