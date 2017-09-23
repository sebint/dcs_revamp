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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "tbl_menu_sub")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Objects extends AuditMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5245396969320722913L;
	
	@Id
	@Column(name = "MENU_SUB_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="menu_sub_seq")
	@SequenceGenerator(name="menu_sub_seq", sequenceName="tbl_menu_sub_menu_sub_id_seq")
	private Long intMenuSubId;
	
	@Column(name = "MENU_SUB_LABEL", unique = true, nullable = false)
	private String strMenuName;
	
	@Column(name = "URL_PATH")
	private String strUrlPath;
	
	@Column(name = "URL_ICON")
	private String strUrlIcon;
	
	@Column(name = "SEQ_NUMBER", nullable = false)
	private Integer intSeqNo;
	
	@Column(name = "IS_ENABLED", nullable = false)
	private Integer isEnabled;
	
	@Column(name = "IS_TYPE_SCREEN", nullable = false)
	private Integer isScreen;
	
	@Transient
	private Long intMenuMasterId;
	
	@ManyToOne
    @JoinColumn(name="MENU_MASTER_ID", nullable = false, insertable = false, updatable = false)
    private ObjectsMaster menu;

	public Long getIntMenuSubId() {
		return intMenuSubId;
	}

	public void setIntMenuSubId(Long intMenuSubId) {
		this.intMenuSubId = intMenuSubId;
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

	public Integer getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Integer getIsScreen() {
		return isScreen;
	}

	public void setIsScreen(Integer isScreen) {
		this.isScreen = isScreen;
	}

	public Long getIntMenuMasterId() {
		return intMenuMasterId;
	}

	public void setIntMenuMasterId(Long intMenuMasterId) {
		this.intMenuMasterId = intMenuMasterId;
	}

	public ObjectsMaster getMenu() {
		return menu;
	}

	public void setMenu(ObjectsMaster menu) {
		this.menu = menu;
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
		return "Objects [intMenuSubId=" + intMenuSubId + ", strMenuName=" + strMenuName + ", strUrlPath=" + strUrlPath
				+ ", strUrlIcon=" + strUrlIcon + ", intSeqNo=" + intSeqNo + ", isEnabled=" + isEnabled + ", isScreen="
				+ isScreen + ", intMenuMasterId=" + intMenuMasterId + ", intCreatedBy=" + intCreatedBy
				+ ", dtDateCreated=" + dtDateCreated + ", intModifiedBy=" + intModifiedBy + ", dtDateModified="
				+ dtDateModified + "]";
	}
}
