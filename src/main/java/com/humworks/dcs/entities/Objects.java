package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_menu_sub")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Objects implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5245396969320722913L;
	
	@Id
	@Column(name = "MENU_SUB_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer intMenuSubId;
	
	@Column(name = "MENU_SUB_LABEL", unique = true, nullable = false)
	private String strMenuName;
	
	@Column(name = "URL_PATH")
	private String strUrlPath;
	
	@Column(name = "URL_ICON")
	private String strUrlIcon;
	
	@Column(name = "SEQ_NUMBER", nullable = false)
	private Integer intSeqNo;
	
	@Column(name = "IS_ENABLED", nullable = false)
	private Boolean boolIsEnabled;
	
	@Column(name = "IS_TYPE_SCREEN", nullable = false)
	private Boolean boolIsScreen;
	
	@Transient
	private Integer intMenuMasterId;
	
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
	
	@ManyToOne
    @JoinColumn(name="MENU_MASTER_ID", insertable = false, updatable = false)
    private ObjectsMaster menu;

	public Integer getIntMenuSubId() {
		return intMenuSubId;
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

	public Boolean getBoolIsEnabled() {
		return boolIsEnabled;
	}

	public Boolean getBoolIsScreen() {
		return boolIsScreen;
	}

	public Integer getIntMenuMasterId() {
		return intMenuMasterId;
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

	public ObjectsMaster getMenu() {
		return menu;
	}

	public void setIntMenuSubId(Integer intMenuSubId) {
		this.intMenuSubId = intMenuSubId;
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

	public void setBoolIsEnabled(Boolean boolIsEnabled) {
		this.boolIsEnabled = boolIsEnabled;
	}

	public void setBoolIsScreen(Boolean boolIsScreen) {
		this.boolIsScreen = boolIsScreen;
	}

	public void setIntMenuMasterId(Integer intMenuMasterId) {
		this.intMenuMasterId = intMenuMasterId;
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

	public void setMenu(ObjectsMaster menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Objects [intMenuSubId=" + intMenuSubId + ", strMenuName=" + strMenuName + ", strUrlPath=" + strUrlPath
				+ ", strUrlIcon=" + strUrlIcon + ", intSeqNo=" + intSeqNo + ", boolIsEnabled=" + boolIsEnabled
				+ ", boolIsScreen=" + boolIsScreen + ", intMenuMasterId=" + intMenuMasterId + ", intCreatedBy="
				+ intCreatedBy + ", dtDateCreated=" + dtDateCreated + ", intModifiedBy=" + intModifiedBy
				+ ", dtDateModified=" + dtDateModified + ", menu=" + menu + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boolIsEnabled == null) ? 0 : boolIsEnabled.hashCode());
		result = prime * result + ((boolIsScreen == null) ? 0 : boolIsScreen.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intMenuMasterId == null) ? 0 : intMenuMasterId.hashCode());
		result = prime * result + ((intMenuSubId == null) ? 0 : intMenuSubId.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((intSeqNo == null) ? 0 : intSeqNo.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((strMenuName == null) ? 0 : strMenuName.hashCode());
		result = prime * result + ((strUrlIcon == null) ? 0 : strUrlIcon.hashCode());
		result = prime * result + ((strUrlPath == null) ? 0 : strUrlPath.hashCode());
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
		Objects other = (Objects) obj;
		if (boolIsEnabled == null) {
			if (other.boolIsEnabled != null)
				return false;
		} else if (!boolIsEnabled.equals(other.boolIsEnabled))
			return false;
		if (boolIsScreen == null) {
			if (other.boolIsScreen != null)
				return false;
		} else if (!boolIsScreen.equals(other.boolIsScreen))
			return false;
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
		if (intMenuMasterId == null) {
			if (other.intMenuMasterId != null)
				return false;
		} else if (!intMenuMasterId.equals(other.intMenuMasterId))
			return false;
		if (intMenuSubId == null) {
			if (other.intMenuSubId != null)
				return false;
		} else if (!intMenuSubId.equals(other.intMenuSubId))
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
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
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
		return true;
	}
	
	
}
