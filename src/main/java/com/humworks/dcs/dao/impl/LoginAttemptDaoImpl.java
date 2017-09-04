package com.humworks.dcs.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.LoginAttemptDao;
import com.humworks.dcs.entities.LoginAttempt;

@Repository("loginAttemptDao")
public class LoginAttemptDaoImpl extends AbstractDao<Integer, LoginAttempt> implements LoginAttemptDao {

	@Override
	public void saveUpdate(LoginAttempt loginAttempt) {
		saveOrUpdate(loginAttempt);
	}

	@Override
	public Integer getCount(String username, String ip) {
		String hql = "SELECT userAtmptCount from LoginAttempt WHERE userName =:userName AND ipLogin =:ipLogin AND isHistory !=1";
		Query query = getSession().createQuery(hql).setParameter("userName", username).setParameter("ipLogin", ip);
		Integer attemptCount = (Integer) query.getSingleResult();
		if(attemptCount != null){
			return attemptCount;
		}
		return 0;
	}

	@Override
	public LoginAttempt checkExists(String userId) {	
		try {
			CriteriaBuilder cb = createCriteriaQuery();
			CriteriaQuery<LoginAttempt> cq = cb.createQuery(LoginAttempt.class);
			Root<LoginAttempt> root = cq.from(LoginAttempt.class);
			cq.select(root);
			cq.where(cb.equal(root.get("userName"),userId),
					 cb.equal(root.get("isHistory"),0));
			return (LoginAttempt) getSession().createQuery(cq).getSingleResult();
		}catch(NoResultException ex) {
			return null;
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public boolean checkLifeSpan(String userId) {
		String hql = "SELECT EXTRACT(EPOCH FROM(LOCALTIMESTAMP - dtDateModified))/3600 from LoginAttempt WHERE userName =:userName AND isHistory !=1";
		Query query = getSession().createQuery(hql).setParameter("userName", userId);
		Integer dtDiff = (Integer) query.getSingleResult();
		if(dtDiff != null){
			return dtDiff >=24;
		}
		return false;
	}

}
