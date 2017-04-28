package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_menu_master")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class ObjectsMaster implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4293194985921327811L;

	@Id
	@Column(name = "MENU_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer intMenuMasterId;
	
	@Column(name = "MENU_NAME", unique = true, nullable = false)
	private String strMenuName;
	
	@Column(name = "URL_PATH")
	private String strUrlPath;
	
	@Column(name = "URL_ICON")
	private String strUrlIcon;
	
	@Column(name = "SEQ_NUMBER", nullable = false)
	private Integer intSeqNo;
	
	@Column(name = "IS_ENABLED", nullable = false)
	private Integer intIsEnabled;
	
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
	
	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Objects> subMenu;

	public Integer getIntMenuMasterId() {
		return intMenuMasterId;
	}

	public String getStrMenuName() {
		return strMenuName;
	}

	public String getStrUrlPath() {
		return strUrlPath;
	}

	public String getStrUrlIcon() {
		return strUrlIcon;
	}

	public Integer getIntSeqNo() {
		return intSeqNo;
	}

	public Integer getIntIsEnabled() {
		return intIsEnabled;
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

	public Set<Objects> getSubMenu() {
		return subMenu;
	}

	public void setIntMenuMasterId(Integer intMenuMasterId) {
		this.intMenuMasterId = intMenuMasterId;
	}

	public void setStrMenuName(String strMenuName) {
		this.strMenuName = strMenuName;
	}

	public void setStrUrlPath(String strUrlPath) {
		this.strUrlPath = strUrlPath;
	}

	public void setStrUrlIcon(String strUrlIcon) {
		this.strUrlIcon = strUrlIcon;
	}

	public void setIntSeqNo(Integer intSeqNo) {
		this.intSeqNo = intSeqNo;
	}

	public void setIntIsEnabled(Integer intIsEnabled) {
		this.intIsEnabled = intIsEnabled;
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

	public void setSubMenu(Set<Objects> subMenu) {
		this.subMenu = subMenu;
	}

	@Override
	public String toString() {
		return "ObjectsMaster [intMenuMasterId=" + intMenuMasterId + ", strMenuName=" + strMenuName + ", strUrlPath="
				+ strUrlPath + ", strUrlIcon=" + strUrlIcon + ", intSeqNo=" + intSeqNo + ", intIsEnabled="
				+ intIsEnabled + ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated
				+ ", intModifiedBy=" + intModifiedBy + ", dtDateModified=" + dtDateModified + ", subMenu=" + subMenu
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intIsEnabled == null) ? 0 : intIsEnabled.hashCode());
		result = prime * result + ((intMenuMasterId == null) ? 0 : intMenuMasterId.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((intSeqNo == null) ? 0 : intSeqNo.hashCode());
		result = prime * result + ((strMenuName == null) ? 0 : strMenuName.hashCode());
		result = prime * result + ((strUrlIcon == null) ? 0 : strUrlIcon.hashCode());
		result = prime * result + ((strUrlPath == null) ? 0 : strUrlPath.hashCode());
		result = prime * result + ((subMenu == null) ? 0 : subMenu.hashCode());
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
		ObjectsMaster other = (ObjectsMaster) obj;
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
		if (intIsEnabled == null) {
			if (other.intIsEnabled != null)
				return false;
		} else if (!intIsEnabled.equals(other.intIsEnabled))
			return false;
		if (intMenuMasterId == null) {
			if (other.intMenuMasterId != null)
				return false;
		} else if (!intMenuMasterId.equals(other.intMenuMasterId))
			return false;
		if (intModifiedBy == null) {
			if (other.intModifiedBy != null)
				return false;
		} else if (!intModifiedBy.equals(other.intModifiedBy))
			return false;
		if (intSeqNo == null) {
			if (other.intSeqNo != null)
				return false;
		} else if (!intSeqNo.equals(other.intSeqNo))
			return false;
		if (strMenuName == null) {
			if (other.strMenuName != null)
				return false;
		} else if (!strMenuName.equals(other.strMenuName))
			return false;
		if (strUrlIcon == null) {
			if (other.strUrlIcon != null)
				return false;
		} else if (!strUrlIcon.equals(other.strUrlIcon))
			return false;
		if (strUrlPath == null) {
			if (other.strUrlPath != null)
				return false;
		} else if (!strUrlPath.equals(other.strUrlPath))
			return false;
		if (subMenu == null) {
			if (other.subMenu != null)
				return false;
		} else if (!subMenu.equals(other.subMenu))
			return false;
		return true;
	}
	
}