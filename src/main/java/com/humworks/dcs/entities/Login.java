package com.humworks.dcs.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
