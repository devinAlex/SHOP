package cn.it.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.BaseDao;
/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
@Service("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	private Class clazz;
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
	}
	@Resource    //没有指定名称默认是属性的名称与id捆绑
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = "DELETE "+clazz.getSimpleName()+" WHERE id=:id";
		getSession().createQuery(hql)
			.setInteger("id", id).executeUpdate();
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T)getSession().get(clazz,id);
	}

	@Override
	public List<T> query() {
		// TODO Auto-generated method stub
		String hql = "FROM "+clazz.getSimpleName()+" ";
		return getSession().createQuery(hql).list();
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);
	}

}
