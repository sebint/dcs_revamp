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
@Table(name="tbl_permission_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Permission implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9087028440174186303L;
	
	@Id
	@Column(name = "PERMISSION_MASTER_ID", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pmsionMasterId;
	
	@Column(name = "ROLE_MASTER_ID", nullable = false)
	private Integer roleMasterId;
	
	@Column(name = "MENU_SUB_ID", nullable = false)
	private Integer menuId;
	
	@Column(name = "VIEW", nullable = false)
	private Integer view;
	
	@Column(name = "ADD", nullable = false)
	private Integer add;
	
	@Column(name = "DELETE", nullable = false)
	private Integer delete;
	
	@Column(name = "EMAIL", nullable = false)
	private Integer email;
	
	@Column(name = "EXPORT", nullable = false)
	private Integer export;
	
	@Column(name = "PRINT", nullable = false)
	private Integer print;
	
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

	public Integer getPmsionMasterId() {
		return pmsionMasterId;
	}

	public Integer getRoleMasterId() {
		return roleMasterId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public Integer getView() {
		return view;
	}

	public Integer getAdd() {
		return add;
	}

	public Integer getDelete() {
		return delete;
	}

	public Integer getEmail() {
		return email;
	}

	public Integer getExport() {
		return export;
	}

	public Integer getPrint() {
		return print;
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

	public void setPmsionMasterId(Integer pmsionMasterId) {
		this.pmsionMasterId = pmsionMasterId;
	}

	public void setRoleMasterId(Integer roleMasterId) {
		this.roleMasterId = roleMasterId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public void setAdd(Integer add) {
		this.add = add;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	public void setEmail(Integer email) {
		this.email = email;
	}

	public void setExport(Integer export) {
		this.export = export;
	}

	public void setPrint(Integer print) {
		this.print = print;
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
		return "Permission [pmsionMasterId=" + pmsionMasterId + ", roleMasterId=" + roleMasterId + ", menuId=" + menuId
				+ ", view=" + view + ", add=" + add + ", delete=" + delete + ", email=" + email + ", export=" + export
				+ ", print=" + print + ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated
				+ ", intModifiedBy=" + intModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((add == null) ? 0 : add.hashCode());
		result = prime * result + ((delete == null) ? 0 : delete.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((export == null) ? 0 : export.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result + ((pmsionMasterId == null) ? 0 : pmsionMasterId.hashCode());
		result = prime * result + ((print == null) ? 0 : print.hashCode());
		result = prime * result + ((roleMasterId == null) ? 0 : roleMasterId.hashCode());
		result = prime * result + ((view == null) ? 0 : view.hashCode());
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
		Permission other = (Permission) obj;
		if (add == null) {
			if (other.add != null)
				return false;
		} else if (!add.equals(other.add))
			return false;
		if (delete == null) {
			if (other.delete != null)
				return false;
		} else if (!delete.equals(other.delete))
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (export == null) {
			if (other.export != null)
				return false;
		} else if (!export.equals(other.export))
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
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		if (pmsionMasterId == null) {
			if (other.pmsionMasterId != null)
				return false;
		} else if (!pmsionMasterId.equals(other.pmsionMasterId))
			return false;
		if (print == null) {
			if (other.print != null)
				return false;
		} else if (!print.equals(other.print))
			return false;
		if (roleMasterId == null) {
			if (other.roleMasterId != null)
				return false;
		} else if (!roleMasterId.equals(other.roleMasterId))
			return false;
		if (view == null) {
			if (other.view != null)
				return false;
		} else if (!view.equals(other.view))
			return false;
		return true;
	}
		
}
