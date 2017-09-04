package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_user_login_monitor")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class LoginAttempt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 626824208556694915L;
	
	
	@Id
	@Column(name = "USER_ATTEMPT_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userAtmptId;
	  
	@Column(name = "USER_ATTEMPT_COUNT", nullable = false)
	private Integer userAtmptCount;	  
	
	@Column(name = "USER_ID", nullable = false)
	private String userName;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ATMP_START_TIMESTAMP", updatable = false)
	private Date dtDateCreated;
	
	@UpdateTimestamp
	@Column(name = "ATMP_STOP_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtDateModified;
	
	@Column(name = "LOGIN_IP", nullable = false)
	private String ipLogin;
	
	@Column(name = "ISHISTORY", nullable = false)
	private Integer isHistory;

	public LoginAttempt() {		
	}
	
	public LoginAttempt(Integer userAtmptCount, String userName, String ipLogin, Integer isHistory) {
		super();
		this.userAtmptCount = userAtmptCount;
		this.userName = userName;
		this.ipLogin = ipLogin;
		this.isHistory = isHistory;
	}

	public Integer getUserAtmptId() {
		return userAtmptId;
	}

	public void setUserAtmptId(Integer userAtmptId) {
		this.userAtmptId = userAtmptId;
	}

	public Integer getUserAtmptCount() {
		return userAtmptCount;
	}

	public void setUserAtmptCount(Integer userAtmptCount) {
		this.userAtmptCount = userAtmptCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}

	public Date getDtDateModified() {
		return dtDateModified;
	}

	public void setDtDateModified(Date dtDateModified) {
		this.dtDateModified = dtDateModified;
	}

	public String getIpLogin() {
		return ipLogin;
	}

	public void setIpLogin(String ipLogin) {
		this.ipLogin = ipLogin;
	}

	public Integer getIsHistory() {
		return isHistory;
	}

	public void setIsHistory(Integer isHistory) {
		this.isHistory = isHistory;
	}

	@Override
	public String toString() {
		return "LoginAttempt [userAtmptId=" + userAtmptId + ", userAtmptCount=" + userAtmptCount + ", userName="
				+ userName + ", dtDateCreated=" + dtDateCreated + ", dtDateModified=" + dtDateModified + ", ipLogin="
				+ ipLogin + ", isHistory=" + isHistory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((ipLogin == null) ? 0 : ipLogin.hashCode());
		result = prime * result + ((isHistory == null) ? 0 : isHistory.hashCode());
		result = prime * result + ((userAtmptCount == null) ? 0 : userAtmptCount.hashCode());
		result = prime * result + ((userAtmptId == null) ? 0 : userAtmptId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginAttempt other = (LoginAttempt) obj;
		if (dtDateCreated == null) {
			if (other.dtDateCreated != null)
				return false;
		} else if (!dtDateCreated.equals(other.dtDateCreated))
			return false;
		if (dtDateModified == null) {
			if (other.dtDateModified != null)
				return false;
		} else if (!dtDateModified.equals(other.dtDateModified))
			return false;
		if (ipLogin == null) {
			if (other.ipLogin != null)
				return false;
		} else if (!ipLogin.equals(other.ipLogin))
			return false;
		if (isHistory == null) {
			if (other.isHistory != null)
				return false;
		} else if (!isHistory.equals(other.isHistory))
			return false;
		if (userAtmptCount == null) {
			if (other.userAtmptCount != null)
				return false;
		} else if (!userAtmptCount.equals(other.userAtmptCount))
			return false;
		if (userAtmptId == null) {
			if (other.userAtmptId != null)
				return false;
		} else if (!userAtmptId.equals(other.userAtmptId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
	
}
