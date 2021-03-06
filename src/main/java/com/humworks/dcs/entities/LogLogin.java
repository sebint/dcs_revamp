package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "tbl_user_login_log")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class LogLogin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6173880657097255110L;
	  
	@Id
	@Column(name = "USER_LOGIN_LOG_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_login_log_master_seq")
	@SequenceGenerator(name="user_login_log_master_seq", sequenceName="tbl_user_login_log_user_login_log_id_seq")
	private Long userLogId;
	
	@Column(name = "USER_ID", updatable = false, nullable = false)
	private Long userId;
	
	@Column(name = "SESSION_ID", nullable = false)
	private String sessionId;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_TIMESTAMP", updatable = false)
	private Date dtDateCreated;
	
	@Column(name = "LOGIN_IP", nullable = false)
	private String ipLogin;
	
	@Column(name = "ISMOBILE", nullable = false)
	private Integer isMobile;

	@Column(name = "USER_AGENT", nullable= false)
	private String userAgent;

	public Long getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(Long userLogId) {
		this.userLogId = userLogId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}

	public String getIpLogin() {
		return ipLogin;
	}

	public void setIpLogin(String ipLogin) {
		this.ipLogin = ipLogin;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
	public Integer getIsMobile() {
		return isMobile;
	}

	public void setIsMobile(Integer isMobile) {
		this.isMobile = isMobile;
	}

	@Override
	public String toString() {
		return "LogLogin [userLogId=" + userLogId + ", userId=" + userId + ", sessionId=" + sessionId
				+ ", dtDateCreated=" + dtDateCreated + ", ipLogin=" + ipLogin + ", isMobile=" + isMobile
				+ ", userAgent=" + userAgent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((ipLogin == null) ? 0 : ipLogin.hashCode());
		result = prime * result + ((isMobile == null) ? 0 : isMobile.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + ((userAgent == null) ? 0 : userAgent.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userLogId == null) ? 0 : userLogId.hashCode());
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
		LogLogin other = (LogLogin) obj;
		if (dtDateCreated == null) {
			if (other.dtDateCreated != null)
				return false;
		} else if (!dtDateCreated.equals(other.dtDateCreated))
			return false;
		if (ipLogin == null) {
			if (other.ipLogin != null)
				return false;
		} else if (!ipLogin.equals(other.ipLogin))
			return false;
		if (isMobile == null) {
			if (other.isMobile != null)
				return false;
		} else if (!isMobile.equals(other.isMobile))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (userAgent == null) {
			if (other.userAgent != null)
				return false;
		} else if (!userAgent.equals(other.userAgent))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userLogId == null) {
			if (other.userLogId != null)
				return false;
		} else if (!userLogId.equals(other.userLogId))
			return false;
		return true;
	}	
}
