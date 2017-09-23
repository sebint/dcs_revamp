package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "tbl_menu_master")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class ObjectsMaster extends AuditMaster implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4293194985921327811L;

	@Id
	@Column(name = "MENU_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="menu_master_seq")
	@SequenceGenerator(name="menu_master_seq", sequenceName="tbl_menu_master_menu_master_id_seq")
	private Long intMenuMasterId;
	
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
	
	@OneToMany(mappedBy = "menu", targetEntity=Objects.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@OrderBy("intSeqNo")
	private Set<Objects> subMenu =  new HashSet<Objects>();

	public Long getIntMenuMasterId() {
		return intMenuMasterId;
	}

	public void setIntMenuMasterId(Long intMenuMasterId) {
		this.intMenuMasterId = intMenuMasterId;
	}

	public String getStrMenuName() {
		return strMenuName;
	}

	public void setStrMenuName(String strMenuName) {
		this.strMenuName = strMenuName;
	}

	public String getStrUrlPath() {
		return strUrlPath;
	}

	public void setStrUrlPath(String strUrlPath) {
		this.strUrlPath = strUrlPath;
	}

	public String getStrUrlIcon() {
		return strUrlIcon;
	}

	public void setStrUrlIcon(String strUrlIcon) {
		this.strUrlIcon = strUrlIcon;
	}

	public Integer getIntSeqNo() {
		return intSeqNo;
	}

	public void setIntSeqNo(Integer intSeqNo) {
		this.intSeqNo = intSeqNo;
	}

	public Integer getIntIsEnabled() {
		return intIsEnabled;
	}

	public void setIntIsEnabled(Integer intIsEnabled) {
		this.intIsEnabled = intIsEnabled;
	}

	public Set<Objects> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(Set<Objects> subMenu) {
		this.subMenu = subMenu;
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
		return "ObjectsMaster [intMenuMasterId=" + intMenuMasterId + ", strMenuName=" + strMenuName + ", strUrlPath="
				+ strUrlPath + ", strUrlIcon=" + strUrlIcon + ", intSeqNo=" + intSeqNo + ", intIsEnabled="
				+ intIsEnabled + ", subMenu=" + subMenu + ", strCreatedBy=" + strCreatedBy + ", dtDateCreated="
				+ dtDateCreated + ", strModifiedBy=" + strModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intIsEnabled == null) ? 0 : intIsEnabled.hashCode());
		result = prime * result + ((intMenuMasterId == null) ? 0 : intMenuMasterId.hashCode());
		result = prime * result + ((intSeqNo == null) ? 0 : intSeqNo.hashCode());
		result = prime * result + ((strMenuName == null) ? 0 : strMenuName.hashCode());
		result = prime * result + ((strUrlIcon == null) ? 0 : strUrlIcon.hashCode());
		result = prime * result + ((strUrlPath == null) ? 0 : strUrlPath.hashCode());
		result = prime * result + ((subMenu == null) ? 0 : subMenu.hashCode());
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