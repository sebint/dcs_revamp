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
@Table(name="tbl_role_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Role implements Serializable {

	private static final long serialVersionUID = 1439614899111669639L;
	
	@Id
	@Column(name = "ROLE_MASTER_ID", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer intRoleId;
	
	@Column(name = "ROLE_NAME", nullable = false, unique = true)
	private String strRoleName;
	
	@Column(name = "ROLE_DESC", nullable = false)
	private String strRoleDesc;
	
	@Column(name = "HOME_PAGE_URL", nullable = false)
	private Integer intRoleHome;
	
	@Column(name = "CREATED_BY", updatable = false)
	private Integer intCreatedBy;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date dtDateCreated;
	
	@Column(name="MODIFIED_BY")
	private Integer intModifiedBy;
	
	@UpdateTimestamp
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtDateModified;
	

	public Integer getIntRoleId() {
		return intRoleId;
	}
	public void setIntRoleId(Integer intRoleId) {
		this.intRoleId = intRoleId;
	}
	
	public String getStrRoleName() {
		return strRoleName;
	}
	public void setStrRoleName(String strRoleName) {
		this.strRoleName = strRoleName;
	}
	public String getStrRoleDesc() {
		return strRoleDesc;
	}
	public void setStrRoleDesc(String strRoleDesc) {
		this.strRoleDesc = strRoleDesc;
	}

	public Integer getIntRoleHome() {
		return intRoleHome;
	}
	public void setIntRoleHome(Integer intRoleHome) {
		this.intRoleHome = intRoleHome;
	}

	public Integer getIntCreatedBy() {
		return intCreatedBy;
	}
	public void setIntCreatedBy(Integer intCreatedBy) {
		this.intCreatedBy = intCreatedBy;
	}
	public Integer getIntModifiedBy() {
		return intModifiedBy;
	}
	public void setIntModifiedBy(Integer intModifiedBy) {
		this.intModifiedBy = intModifiedBy;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public Date getDtDateModified() {
		return dtDateModified;
	}
	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}
	public void setDtDateModified(Date dtDateModified) {
		this.dtDateModified = dtDateModified;
	}
	
	@Override
	public String toString() {
		return "Role [intRoleId=" + intRoleId + ", strRoleName=" + strRoleName + ", strRoleDesc=" + strRoleDesc
				+ ", intRoleHome=" + intRoleHome + ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated
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
		result = prime * result + ((intRoleHome == null) ? 0 : intRoleHome.hashCode());
		result = prime * result + ((intRoleId == null) ? 0 : intRoleId.hashCode());
		result = prime * result + ((strRoleDesc == null) ? 0 : strRoleDesc.hashCode());
		result = prime * result + ((strRoleName == null) ? 0 : strRoleName.hashCode());
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
		Role other = (Role) obj;
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
		if (intRoleHome == null) {
			if (other.intRoleHome != null)
				return false;
		} else if (!intRoleHome.equals(other.intRoleHome))
			return false;
		if (intRoleId == null) {
			if (other.intRoleId != null)
				return false;
		} else if (!intRoleId.equals(other.intRoleId))
			return false;
		if (strRoleDesc == null) {
			if (other.strRoleDesc != null)
				return false;
		} else if (!strRoleDesc.equals(other.strRoleDesc))
			return false;
		if (strRoleName == null) {
			if (other.strRoleName != null)
				return false;
		} else if (!strRoleName.equals(other.strRoleName))
			return false;
		return true;
	}
	
	
}
