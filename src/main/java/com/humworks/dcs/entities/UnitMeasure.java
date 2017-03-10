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
@Table(name = "tbl_uom_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class UnitMeasure implements Serializable {

	private static final long serialVersionUID = 2375203054880770790L;
	
	@Id
	@Column(name = "UOM_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uomId;
	
	@Column(name = "UOM_LABEL")
	private String uomLabel;
	
	@Column(name = "UOM_DESC")
	private String uomDesc;
	
	@Column(name = "STATUS")
	private String status;

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

	public Integer getUomId() {
		return uomId;
	}

	public String getUomLabel() {
		return uomLabel;
	}

	public String getUomDesc() {
		return uomDesc;
	}

	public String getStatus() {
		return status;
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

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public void setUomLabel(String uomLabel) {
		this.uomLabel = uomLabel;
	}

	public void setUomDesc(String uomDesc) {
		this.uomDesc = uomDesc;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "UnitMeasure [uomId=" + uomId + ", uomLabel=" + uomLabel + ", uomDesc=" + uomDesc + ", status=" + status
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
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((uomDesc == null) ? 0 : uomDesc.hashCode());
		result = prime * result + ((uomId == null) ? 0 : uomId.hashCode());
		result = prime * result + ((uomLabel == null) ? 0 : uomLabel.hashCode());
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
		UnitMeasure other = (UnitMeasure) obj;
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (uomDesc == null) {
			if (other.uomDesc != null)
				return false;
		} else if (!uomDesc.equals(other.uomDesc))
			return false;
		if (uomId == null) {
			if (other.uomId != null)
				return false;
		} else if (!uomId.equals(other.uomId))
			return false;
		if (uomLabel == null) {
			if (other.uomLabel != null)
				return false;
		} else if (!uomLabel.equals(other.uomLabel))
			return false;
		return true;
	}
	
}
