package com.humworks.dcs.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

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
	
/*	public Optional<T> getByKey(PrimaryKey key){
		return Optional.of((T) getSession().get(persistentClass, key));
	}*/
	
	public T getByKey(PrimaryKey key){
		return (T) getSession().get(persistentClass, key);
	}
	
	public void persist(T entity){
		getSession().persist(entity);
	}
	
	public void update(T entity){
		getSession().update(entity);
	}
	
	public void saveOrUpdate(T entity){
		getSession().saveOrUpdate(entity);
	}
	
	public Integer save(T entity){
		return (Integer) getSession().save(entity);
	}
	
	public void delete(T entity){
		getSession().delete(entity);
	}
	
	public Integer query(Query query){
		return query.executeUpdate();
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
	
	protected CriteriaBuilder createCriteriaQuery(){
		return getSession().getCriteriaBuilder();
	}

}
