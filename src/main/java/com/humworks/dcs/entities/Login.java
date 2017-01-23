package com.humworks.dcs.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_user_master")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Login implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6798951762443399563L;

	@Id
	@Column(name = "USER_MASTER_ID", updatable = false)
	private Integer intUserId;
	
	@NotEmpty
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String strUserName;
	
	@NotEmpty
	@Column(name = "USER_PASS")
	private String strPassword;

	@Transient
	private String strConfirmPassword;
	
	@Transient
	private String strExPassword;
	
	public Integer getIntUserId() {
		return intUserId;
	}

	public void setIntUserId(Integer intUserId) {
		this.intUserId = intUserId;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public String getStrConfirmPassword() {
		return strConfirmPassword;
	}

	public void setStrConfirmPassword(String strConfirmPassword) {
		this.strConfirmPassword = strConfirmPassword;
	}

	public String getStrExPassword() {
		return strExPassword;
	}

	public void setStrExPassword(String strExPassword) {
		this.strExPassword = strExPassword;
	}

	@Override
	public String toString() {
		return "Login [intUserId=" + intUserId + ", strUserName=" + strUserName + ", strPassword=" + strPassword
				+ ", strConfirmPassword=" + strConfirmPassword + ", strExPassword=" + strExPassword + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intUserId == null) ? 0 : intUserId.hashCode());
		result = prime * result + ((strConfirmPassword == null) ? 0 : strConfirmPassword.hashCode());
		result = prime * result + ((strExPassword == null) ? 0 : strExPassword.hashCode());
		result = prime * result + ((strPassword == null) ? 0 : strPassword.hashCode());
		result = prime * result + ((strUserName == null) ? 0 : strUserName.hashCode());
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
		Login other = (Login) obj;
		if (intUserId == null) {
			if (other.intUserId != null)
				return false;
		} else if (!intUserId.equals(other.intUserId))
			return false;
		if (strConfirmPassword == null) {
			if (other.strConfirmPassword != null)
				return false;
		} else if (!strConfirmPassword.equals(other.strConfirmPassword))
			return false;
		if (strExPassword == null) {
			if (other.strExPassword != null)
				return false;
		} else if (!strExPassword.equals(other.strExPassword))
			return false;
		if (strPassword == null) {
			if (other.strPassword != null)
				return false;
		} else if (!strPassword.equals(other.strPassword))
			return false;
		if (strUserName == null) {
			if (other.strUserName != null)
				return false;
		} else if (!strUserName.equals(other.strUserName))
			return false;
		return true;
	}
	
}
