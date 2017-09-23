package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "tbl_user_status")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class UserStatus extends AuditMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7585819810815005624L;
	
	@Id
	@Column(name = "USER_MASTER_ID", updatable = false, unique = true, nullable = false)
	private Long intUserId;
	
	@Column(name = "IS_ENABLED", nullable = false)
	private Integer isEnabled;
	
	@Column(name = "IS_ACCOUNT_NON_EXPIRED", nullable = false)
	private Integer isAccountNonExpired;
	
	@Column(name = "IS_CREDENTIALS_NON_EXPIRED", nullable = false)
	private Integer isCredentialsNonExpired;
	
	@Column(name = "IS_ACCOUNT_NON_LOCKED", nullable = false)
	private Integer isAccountNonLocked;
	
	public Long getIntUserId() {
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

	public void setIntUserId(Long intUserId) {
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
	
	public String getIntCreatedBy() {
		return intCreatedBy;
	}

	public void setIntCreatedBy(String intCreatedBy) {
		this.intCreatedBy = intCreatedBy;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}

	public String getIntModifiedBy() {
		return intModifiedBy;
	}

	public void setIntModifiedBy(String intModifiedBy) {
		this.intModifiedBy = intModifiedBy;
	}

	public Date getDtDateModified() {
		return dtDateModified;
	}

	public void setDtDateModified(Date dtDateModified) {
		this.dtDateModified = dtDateModified;
	}
	
	public UserStatus(){		
	}
	
	public UserStatus(Long intUserId, Integer isEnabled, Integer isAccountNonExpired,
			Integer isCredentialsNonExpired, Integer isAccountNonLocked, String intCreatedBy, String intModifiedBy) {
		super();
		this.intUserId = intUserId;
		this.isEnabled = isEnabled;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.intCreatedBy = intCreatedBy;
		this.intCreatedBy = intModifiedBy;
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
		int result = super.hashCode();
		result = prime * result + ((intUserId == null) ? 0 : intUserId.hashCode());
		result = prime * result + ((isAccountNonExpired == null) ? 0 : isAccountNonExpired.hashCode());
		result = prime * result + ((isAccountNonLocked == null) ? 0 : isAccountNonLocked.hashCode());
		result = prime * result + ((isCredentialsNonExpired == null) ? 0 : isCredentialsNonExpired.hashCode());
		result = prime * result + ((isEnabled == null) ? 0 : isEnabled.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserStatus other = (UserStatus) obj;
		if (intUserId == null) {
			if (other.intUserId != null)
				return false;
		} else if (!intUserId.equals(other.intUserId))
			return false;
		if (isAccountNonExpired == null) {
			if (other.isAccountNonExpired != null)
				return false;
		} else if (!isAccountNonExpired.equals(other.isAccountNonExpired))
			return false;
		if (isAccountNonLocked == null) {
			if (other.isAccountNonLocked != null)
				return false;
		} else if (!isAccountNonLocked.equals(other.isAccountNonLocked))
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
