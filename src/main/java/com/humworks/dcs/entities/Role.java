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

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="tbl_role_master")
@DynamicUpdate(true)
public class Role implements Serializable {

	private static final long serialVersionUID = 1439614899111669639L;
	
	private Integer intRoleId;
	private String strRoleName;
	private String strRoleDesc;
	private Integer intRoleHome;
	private Integer intCreatedBy;
	private Date strDateCreated;
	private Integer intModifiedBy;
	private Date strDateModified;
	
	@Id
	@Column(name = "role_master_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIntRoleId() {
		return intRoleId;
	}
	public void setIntRoleId(Integer intRoleId) {
		this.intRoleId = intRoleId;
	}
	@Column(name = "role_name", nullable = false, unique = true)
	public String getStrRoleName() {
		return strRoleName;
	}
	public void setStrRoleName(String strRoleName) {
		this.strRoleName = strRoleName;
	}
	@Column(name = "role_desc", nullable = false)
	public String getStrRoleDesc() {
		return strRoleDesc;
	}
	public void setStrRoleDesc(String strRoleDesc) {
		this.strRoleDesc = strRoleDesc;
	}
	@Column(name = "home_page_url", nullable = false)
	public Integer getIntRoleHome() {
		return intRoleHome;
	}
	public void setIntRoleHome(Integer intRoleHome) {
		this.intRoleHome = intRoleHome;
	}
	@Column(name = "created_by", updatable = false)
	public Integer getIntCreatedBy() {
		return intCreatedBy;
	}
	public void setIntCreatedBy(Integer intCreatedBy) {
		this.intCreatedBy = intCreatedBy;
	}
	@Column(name = "created_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
	public Date getStrDateCreated() {
		return strDateCreated;
	}
	public void setStrDateCreated(Date strDateCreated) {
		this.strDateCreated = strDateCreated;
	}
	@Column(name="modified_by")
	public Integer getIntModifiedBy() {
		return intModifiedBy;
	}
	public void setIntModifiedBy(Integer intModifiedBy) {
		this.intModifiedBy = intModifiedBy;
	}
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
	public Date getStrDateModified() {
		return strDateModified;
	}
	public void setStrDateModified(Date strDateModified) {
		this.strDateModified = strDateModified;
	}
	@Override
	public String toString() {
		return "Role [intRoleId=" + intRoleId + ", strRoleName=" + strRoleName + ", strRoleDesc=" + strRoleDesc
				+ ", intRoleHome=" + intRoleHome + ", intCreatedBy=" + intCreatedBy + ", strDateCreated="
				+ strDateCreated + ", intModifiedBy=" + intModifiedBy + ", strDateModified=" + strDateModified + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((intRoleHome == null) ? 0 : intRoleHome.hashCode());
		result = prime * result + ((intRoleId == null) ? 0 : intRoleId.hashCode());
		result = prime * result + ((strDateCreated == null) ? 0 : strDateCreated.hashCode());
		result = prime * result + ((strDateModified == null) ? 0 : strDateModified.hashCode());
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
		if (strDateCreated == null) {
			if (other.strDateCreated != null)
				return false;
		} else if (!strDateCreated.equals(other.strDateCreated))
			return false;
		if (strDateModified == null) {
			if (other.strDateModified != null)
				return false;
		} else if (!strDateModified.equals(other.strDateModified))
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
