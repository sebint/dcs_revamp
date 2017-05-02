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
    @JoinColumn(name="MENU_MASTER_ID", nullable = false, insertable = false, updatable = false)
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
	
}
