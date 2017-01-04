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
@Table(name = "tbl_user_role_master")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166385764868177785L;
	
	@Id
	@Column(name = "USER_ROLE_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer intUserRoleId;
	
	@Column(name = "USER_MASTER_ID")
	private Integer intUserId;
	
	@Column(name = "ROLE_MASTER_ID")
	private Integer intRoleId;
	
	@Column(name = "CREATED_BY", updatable = false)
	private Integer intCreatedBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date dtDateCreated;

	@Column(name = "MODIFIED_BY")
	private Integer intModifiedBy;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE")
	private Date dtDateModified;

	public Integer getIntUserRoleId() {
		return intUserRoleId;
	}

	public Integer getIntUserId() {
		return intUserId;
	}

	public Integer getIntRoleId() {
		return intRoleId;
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

	public void setIntUserRoleId(Integer intUserRoleId) {
		this.intUserRoleId = intUserRoleId;
	}

	public void setIntUserId(Integer intUserId) {
		this.intUserId = intUserId;
	}

	public void setIntRoleId(Integer intRoleId) {
		this.intRoleId = intRoleId;
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

	@Override
	public String toString() {
		return "UserRole [intUserRoleId=" + intUserRoleId + ", intUserId=" + intUserId + ", intRoleId=" + intRoleId
				+ ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated + ", intModifiedBy="
				+ intModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((intRoleId == null) ? 0 : intRoleId.hashCode());
		result = prime * result + ((intUserId == null) ? 0 : intUserId.hashCode());
		result = prime * result + ((intUserRoleId == null) ? 0 : intUserRoleId.hashCode());
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
