package com.humworks.dcs.dao;

import java.io.Serializable;

public interface CommonEntityDao<PrimaryKey extends Serializable, T> {

	public T getById(PrimaryKey id);

	public Boolean Persist(T entity);

	public Boolean Update(T entity);

	public Boolean Delete(T entity);

	public Boolean DeleteAll();

}
