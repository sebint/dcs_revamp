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
@Table(name="tbl_role_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Role extends AuditMaster implements Serializable {

	private static final long serialVersionUID = 1439614899111669639L;
	
	@Id
	@Column(name = "ROLE_MASTER_ID", unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="role_master_seq")
	@SequenceGenerator(name="role_master_seq", sequenceName="tbl_role_master_role_master_id_seq")
	private Long intRoleId;
	
	@Column(name = "ROLE_NAME", nullable = false, unique = true)
	private String strRoleName;
	
	@Column(name = "ROLE_DESC", nullable = false)
	private String strRoleDesc;
	
	@Column(name = "HOME_PAGE_URL", nullable = false)
	private Integer intRoleHome;

	public Long getIntRoleId() {
		return intRoleId;
	}

	public void setIntRoleId(Long intRoleId) {
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

	@Override
	public String toString() {
		return "Role [intRoleId=" + intRoleId + ", strRoleName=" + strRoleName + ", strRoleDesc=" + strRoleDesc
				+ ", intRoleHome=" + intRoleHome + ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated
				+ ", intModifiedBy=" + intModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
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
