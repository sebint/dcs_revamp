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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "tbl_user_role_master")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class UserRole extends AuditMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166385764868177785L;
	
	@Id
	@Column(name = "USER_ROLE_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_role_master_seq")
	@SequenceGenerator(name="user_role_master_seq", sequenceName="tbl_user_role_master_user_role_master_id_seq")
	private Long intUserRoleId;
	
	@Column(name = "USER_MASTER_ID")
	private Long intUserId;
	
	@Column(name = "ROLE_MASTER_ID")
	private Long intRoleId;

	public Long getIntUserRoleId() {
		return intUserRoleId;
	}

	public Long getIntUserId() {
		return intUserId;
	}

	public Long getIntRoleId() {
		return intRoleId;
	}

	public void setIntUserRoleId(Long intUserRoleId) {
		this.intUserRoleId = intUserRoleId;
	}

	public void setIntUserId(Long intUserId) {
		this.intUserId = intUserId;
	}

	public void setIntRoleId(Long intRoleId) {
		this.intRoleId = intRoleId;
	}
	
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
	@Override
	public String toString() {
		return "UserRole [intUserRoleId=" + intUserRoleId + ", intUserId=" + intUserId + ", intRoleId=" + intRoleId
				+ ", strCreatedBy=" + strCreatedBy + ", dtDateCreated=" + dtDateCreated + ", strModifiedBy="
				+ strModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((intRoleId == null) ? 0 : intRoleId.hashCode());
		result = prime * result + ((intUserId == null) ? 0 : intUserId.hashCode());
		result = prime * result + ((intUserRoleId == null) ? 0 : intUserRoleId.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((strCreatedBy == null) ? 0 : strCreatedBy.hashCode());
		result = prime * result + ((strModifiedBy == null) ? 0 : strModifiedBy.hashCode());
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
		UserRole other = (UserRole) obj;
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
		if (intRoleId == null) {
			if (other.intRoleId != null)
				return false;
		} else if (!intRoleId.equals(other.intRoleId))
			return false;
		if (intUserId == null) {
			if (other.intUserId != null)
				return false;
		} else if (!intUserId.equals(other.intUserId))
			return false;
		if (intUserRoleId == null) {
			if (other.intUserRoleId != null)
				return false;
		} else if (!intUserRoleId.equals(other.intUserRoleId))
			return false;
		return true;
	}
}
