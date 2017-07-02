package cn.it.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.AccountDao;
import cn.it.shop.dao.BaseDao;
import cn.it.shop.dao.CategoryDao;
import cn.it.shop.dao.ForderDao;
import cn.it.shop.dao.ProductDao;
import cn.it.shop.dao.SorderDao;
import cn.it.shop.dao.UserDao;
import cn.it.shop.service.BaseService;
/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T>{
	
	private Class clazz;
	
	public BaseServiceImpl(){
		System.out.println("this������ǵ�ǰ���ù��췽���Ķ���"+this);
		System.out.println("��ȡ��ǰ����ĸ�����Ϣ��"+this.getClass().getSuperclass());
		System.out.println("��ȡ��ǰ����ĸ�����Ϣ������������Ϣ����"+this.getClass().getGenericSuperclass());
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
	}
	@PostConstruct
	public void init(){
		//����clazz�����ͣ��Ѳ�ͬ��DAO���󣬸�ֵ��baseDao����
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0,1).toLowerCase() + clazzName.substring(1)+"Dao";//Account ==>accountDao
		try {
			Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this));
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected BaseDao baseDao;//�����ǰ T account����baseDao�������accountDao
								//category ��baseDao����categoryDao
	@Resource
	protected AccountDao accountDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource
	protected ForderDao forderDao;
	@Resource
	protected ProductDao productDao;
	@Resource
	protected SorderDao sorderDao;
	@Resource
	protected UserDao userDao;
	
	
	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public T get(int id) {
		return (T)baseDao.get(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}

	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

}
