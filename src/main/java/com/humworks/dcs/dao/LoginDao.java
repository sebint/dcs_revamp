package com.humworks.dcs.dao;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.entities.Login;

@Repository("loginDao")
public class LoginDao extends AbstractDao<Integer, Login> {

	public Integer checkUser(String strUserName,String strPassword){
		
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Login> cq = criteriaBuilder.createQuery(Login.class);
		Root<Login> root = cq.from(Login.class);
		cq.where(criteriaBuilder.equal(root.get("strUserName"), strUserName));
		cq.where(criteriaBuilder.equal(root.get("strPassword"), strPassword));
		ArrayList<Login> login =  (ArrayList<Login>) getSession().createQuery(cq).getResultList();
		return login.size();

	}
}
