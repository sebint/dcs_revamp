package com.humworks.dcs.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.UserDao;
import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public Integer saveUser(User user) {
		 return save(user);
	}

/*	@Override
	public Optional<User> findById(Integer uid) {
		return Optional.of(getByKey(uid)).map(user->{
			return user;
		});
	}*/
	@Override
	public User findById(Integer uid) {
		return getByKey(uid);
	}
	
	@Override
	public User findByUsername(String username) {
		try{
			CriteriaBuilder cb = createCriteriaQuery();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.where(cb.equal(root.get("strUserName"), username));
	        return (User) getSession().createQuery(cq).getSingleResult();
		}catch(javax.persistence.NoResultException nr){
			return null;
		}catch(java.lang.NullPointerException np){
			return null;
		}catch(Exception ex){
			return null;
		}
	}
	
	@Override
	public ArrayList<User> selectAll() {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		cq.orderBy(cb.desc(root.get("intUserId")));
		return (ArrayList<User>) getSession().createQuery(cq).getResultList();
	}

	@Override
	public Integer updateUser(User user) {		
		String hql = "UPDATE User SET strFirstName = :strFirstName,strLastName =:strLastName, "
					+ "strEmail = :strEmail, strDeptName= :strDeptName, "
					+ "boolPwdChange =:boolPwdChange, boolLockPwd =:boolLockPwd, "
					+ "intPwdAttempt =:intPwdAttempt, intModifiedBy =:intModifiedBy, dtDateModified =:dtDateModified "
					+ "WHERE intUserId = :intUserId";
		Query query = getSession().createQuery(hql);
		query.setParameter("strFirstName", user.getStrFirstName());
		query.setParameter("strLastName", user.getStrLastName());
		query.setParameter("strEmail", user.getStrEmail());
		query.setParameter("strDeptName", user.getStrDeptName());
		query.setParameter("boolPwdChange", user.getBoolPwdChange());
		query.setParameter("boolLockPwd", user.getBoolLockPwd());
		query.setParameter("intPwdAttempt", user.getIntPwdAttempt());
		query.setParameter("intModifiedBy", user.getIntModifiedBy());
		query.setParameter("dtDateModified", new Date());
		query.setParameter("intUserId", user.getIntUserId());
		return query(query);		
	}
	
	@Override
	public void deleteUser(User user) {
		delete(user);
		
	}

	@Override
	public Integer findUid(String username) {
		String hql = "SELECT intUserId FROM User WHERE strUserName =:strUserName";
		Query query = getSession().createQuery(hql).setParameter("strUserName", username);
		Integer uid = (Integer) query.getSingleResult();
		if(uid != null){
			return uid;
		}
		return null;
	}

	@Override
	public void transactionRollback() {
		getSession().getTransaction().rollback();
		
	}

	@Override
	public Integer resetPassword(Login reset) {
		String hql = "UPDATE User SET strPassword =:strPassword WHERE intUserId =:intUserId";
		Query query = getSession().createQuery(hql).setParameter("strPassword", reset.getStrPassword()).setParameter("intUserId", reset.getIntUserId());
		return query(query);
	}

	@Override
	public String checkPassword(Integer uid) {
		String hql = "SELECT strPassword FROM User WHERE intUserId =:intUserId";
		Query query = getSession().createQuery(hql).setParameter("intUserId", uid);
		String strPassword = (String) query.getSingleResult();
		return strPassword;
		
	}

	@Override
	public ArrayList<User> findByRoleId(ArrayList<Integer> roleMasterId) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root).where(root.get("intUserId").in(roleMasterId));
		return (ArrayList<User>) getSession().createQuery(cq).getResultList();
	}

	@Override
	public Integer updateStatusField(String field, Integer value,Integer uid) {
		String hql = "UPDATE User SET "+field +"="+value+" WHERE intUserId =:intUserId";
		Query query = getSession().createQuery(hql).setParameter("intUserId", uid);
		return query(query);		
	}
	
}
