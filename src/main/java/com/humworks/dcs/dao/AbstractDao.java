package com.humworks.dcs.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PrimaryKey extends Serializable, T> {

	private final Class<T> persistentClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass =(Class<T>)(((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public T getByKey(PrimaryKey key){
		return (T) getSession().get(persistentClass, key);
	}
	
	public void persist(T entity){
		getSession().persist(entity);
	}
	
	public void delete(T entity){
		getSession().delete(entity);
	}
	
	public ArrayList<T> listAllByQuery(String query){
		@SuppressWarnings("unchecked")
		ArrayList<T> list = (ArrayList<T>) getSession().createQuery(query).getResultList();
		return list;
	}
	
	@SuppressWarnings("deprecation")
	protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
	
	

}
