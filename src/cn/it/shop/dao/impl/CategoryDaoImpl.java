package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.dao.CategoryDao;
import cn.it.shop.model.Category;
@SuppressWarnings("unchecked")
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
	public CategoryDaoImpl(){
		super();
	}

	
	@Override
	public List<Category> queryJoinAccount(String type, int page, int  size) {
		String hql = "FROM Category c LEFT JOIN FETCH c.account WHERE c.type LIKE :type";
		return getSession().createQuery(hql)
					.setString("type", "%"+type+"%")
					.setFirstResult((page-1)*size)
					.setMaxResults(page*size)
					.list();
	}


	@Override
	public Long getCount(String type) {
		String hql = "SELECT count(c) FROM Category c WHERE c.type LIKE :type";
		return (Long)getSession().createQuery(hql)
					.setString("type", "%"+type+"%")
					.uniqueResult();
	}


	@Override
	public void deleteByIds(String ids) {
		String hql = "DELETE  FROM Category WHERE id in("+ids+")";
		getSession().createQuery(hql)
				.executeUpdate();
	}


	@Override
	public List<Category> queryByHot(boolean hot) {
		String hql = "FROM Category c WHERE c.hot=:hot";
		return getSession().createQuery(hql)
		.setBoolean("hot", hot)
		.list();
	}
}
