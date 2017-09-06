package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbl_user_status")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class UserStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7585819810815005624L;
	
	@Id
	@Column(name = "USER_MASTER_ID", updatable = false, unique = true, nullable = false)
	private Integer intUserId;
	
	@Column(name = "IS_ENABLED", nullable = false)
	private Integer isEnabled;
	
	@Column(name = "IS_ACCOUNT_NON_EXPIRED", nullable = false)
	private Integer isAccountNonExpired;
	
	@Column(name = "IS_CREDENTIALS_NON_EXPIRED", nullable = false)
	private Integer isCredentialsNonExpired;
	
	@Column(name = "IS_ACCOUNT_NON_LOCKED", nullable = false)
	private Integer isAccountNonLocked;
	
	@Column(name = "CREATED_BY", updatable = false)
	private Integer intCreatedBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date dtDateCreated;

	@Column(name = "MODIFIED_BY")
	private Integer intModifiedBy;

	@UpdateTimestamp
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtDateModified;

	public Integer getIntUserId() {
		return intUserId;
	}

	public Integer getIsEnabled() {
		return isEnabled;
	}

	public Integer getIsAccountNonExpired() {
		return isAccountNonExpired;
	}

	public Integer getIsCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public Integer getIsAccountLocked() {
		return isAccountNonLocked;
	}

	public Integer getIntCreatedBy() {
		return intCreatedBy;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public Integer getIntModifiedBy() {
		return intModifiedBy;
	}

	public Date getDtDateModified() {
		return dtDateModified;
	}

	public void setIntUserId(Integer intUserId) {
		this.intUserId = intUserId;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	public void setIsAccountNonExpired(Integer isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public void setIsCredentialsNonExpired(Integer isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public void setIsAccountLocked(Integer isAccountLocked) {
		this.isAccountNonLocked = isAccountLocked;
	}

	public void setIntCreatedBy(Integer intCreatedBy) {
		this.intCreatedBy = intCreatedBy;
	}

	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}

	public void setIntModifiedBy(Integer intModifiedBy) {
		this.intModifiedBy = intModifiedBy;
	}

	public void setDtDateModified(Date dtDateModified) {
		this.dtDateModified = dtDateModified;
	}
	
	public UserStatus(){		
	}
	
	public UserStatus(Integer intUserId, Integer isEnabled, Integer isAccountNonExpired,
			Integer isCredentialsNonExpired, Integer isAccountNonLocked, Integer intCreatedBy, Integer intModifiedBy) {
		super();
		this.intUserId = intUserId;
		this.isEnabled = isEnabled;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.intCreatedBy = intCreatedBy;
		this.intModifiedBy = intModifiedBy;
	}

	@Override
	public String toString() {
		return "UserStatus [intUserId=" + intUserId + ", isEnabled=" + isEnabled + ", isAccountNonExpired="
				+ isAccountNonExpired + ", isCredentialsNonExpired=" + isCredentialsNonExpired + ", isAccountNonLocked="
				+ isAccountNonLocked + ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated
				+ ", intModifiedBy=" + intModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((intUserId == null) ? 0 : intUserId.hashCode());
		result = prime * result + ((isAccountNonLocked == null) ? 0 : isAccountNonLocked.hashCode());
		result = prime * result + ((isAccountNonExpired == null) ? 0 : isAccountNonExpired.hashCode());
		result = prime * result + ((isCredentialsNonExpired == null) ? 0 : isCredentialsNonExpired.hashCode());
		result = prime * result + ((isEnabled == null) ? 0 : isEnabled.hashCode());
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
		UserStatus other = (UserStatus) obj;
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
		if (intCreatedBy == null) {
			if (other.intCreatedBy != null)
				return false;
		} else if (!intCreatedBy.equals(other.intCreatedBy))
			return false;
		if (intModifiedBy == null) {
			if (other.intModifiedBy != null)
				return false;
		} else if (!intModifiedBy.equals(other.intModifiedBy))
			return false;
		if (intUserId == null) {
			if (other.intUserId != null)
				return false;
		} else if (!intUserId.equals(other.intUserId))
			return false;
		if (isAccountNonLocked == null) {
			if (other.isAccountNonLocked != null)
				return false;
		} else if (!isAccountNonLocked.equals(other.isAccountNonLocked))
			return false;
		if (isAccountNonExpired == null) {
			if (other.isAccountNonExpired != null)
				return false;
		} else if (!isAccountNonExpired.equals(other.isAccountNonExpired))
			return false;
		if (isCredentialsNonExpired == null) {
			if (other.isCredentialsNonExpired != null)
				return false;
		} else if (!isCredentialsNonExpired.equals(other.isCredentialsNonExpired))
			return false;
		if (isEnabled == null) {
			if (other.isEnabled != null)
				return false;
		} else if (!isEnabled.equals(other.isEnabled))
			return false;
		return true;
	}
}
