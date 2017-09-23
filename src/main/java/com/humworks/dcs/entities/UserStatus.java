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
	
	public UserStatus() {
		super();
	}

	public UserStatus(Long intUserId, Integer isEnabled, Integer isAccountNonExpired, Integer isCredentialsNonExpired,
			Integer isAccountNonLocked, String strCreatedBy, String strModifiedBy) {
		super();
		this.intUserId = intUserId;
		this.isEnabled = isEnabled;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.strCreatedBy = strCreatedBy;
		this.strModifiedBy = strModifiedBy;
	}

	public Long getIntUserId() {
		return intUserId;
	}

	public void setIntUserId(Long intUserId) {
		this.intUserId = intUserId;
	}

	public Integer getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Integer getIsAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setIsAccountNonExpired(Integer isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public Integer getIsCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public void setIsCredentialsNonExpired(Integer isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public Integer getIsAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setIsAccountNonLocked(Integer isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	 /*********************************/		
	public String getStrCreatedBy() {
		return strCreatedBy;
	}

	public void setStrCreatedBy(String strCreatedBy) {
		this.strCreatedBy = strCreatedBy;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}

	public String getStrModifiedBy() {
		return strModifiedBy;
	}

	public void setStrModifiedBy(String strModifiedBy) {
		this.strModifiedBy = strModifiedBy;
	}

	public Date getDtDateModified() {
		return dtDateModified;
	}

	public void setDtDateModified(Date dtDateModified) {
		this.dtDateModified = dtDateModified;
	}
	 /*********************************/		
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((intUserId == null) ? 0 : intUserId.hashCode());
		result = prime * result + ((isAccountNonExpired == null) ? 0 : isAccountNonExpired.hashCode());
		result = prime * result + ((isAccountNonLocked == null) ? 0 : isAccountNonLocked.hashCode());
		result = prime * result + ((isCredentialsNonExpired == null) ? 0 : isCredentialsNonExpired.hashCode());
		result = prime * result + ((isEnabled == null) ? 0 : isEnabled.hashCode());
		 /*********************************/		
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((strCreatedBy == null) ? 0 : strCreatedBy.hashCode());
		result = prime * result + ((strModifiedBy == null) ? 0 : strModifiedBy.hashCode());
		 /*********************************/		
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
        /*********************************/		
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
		if (strCreatedBy == null) {
			if (other.strCreatedBy != null)
				return false;
		} else if (!strCreatedBy.equals(other.strCreatedBy))
			return false;
		if (strModifiedBy == null) {
			if (other.strModifiedBy != null)
				return false;
		} else if (!strModifiedBy.equals(other.strModifiedBy))
			return false;
		 /*********************************/		
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

	@Override
	public String toString() {
		return "UserStatus [intUserId=" + intUserId + ", isEnabled=" + isEnabled + ", isAccountNonExpired="
				+ isAccountNonExpired + ", isCredentialsNonExpired=" + isCredentialsNonExpired + ", isAccountNonLocked="
				+ isAccountNonLocked + "]";
	}
}
