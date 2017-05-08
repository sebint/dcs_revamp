package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class NonProgressiveJournalMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5417173876672356752L;
	
	@Id
	@Column(name = "NON_PGRV_JRNL_DATA_MAP_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonPrgvMapId;
	
	@Column(name = "NON_PGRV_JRNL_MASTER_ID")
	private Integer nonProgressiveMasterId;
	
	@Column(name = "REV")
	private Integer revNo;
	
	@Column(name = "VALIDATOR_ID")
	private Integer validatorId;
	
	@Column(name = "VALIDATE_STATUS")
	private Integer validateStatus;
	
	@Column(name = "VALIDATE_COMMENT")
	private String validateComment;
	
	@Column(name = "DATA_DATE")
	private String dataDate;
	
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

	public Integer getNonPrgvMapId() {
		return nonPrgvMapId;
	}

	public Integer getNonProgressiveMasterId() {
		return nonProgressiveMasterId;
	}

	public Integer getRevNo() {
		return revNo;
	}

	public Integer getValidatorId() {
		return validatorId;
	}

	public Integer getValidateStatus() {
		return validateStatus;
	}

	public String getValidateComment() {
		return validateComment;
	}

	public String getDataDate() {
		return dataDate;
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

	public void setNonPrgvMapId(Integer nonPrgvMapId) {
		this.nonPrgvMapId = nonPrgvMapId;
	}

	public void setNonProgressiveMasterId(Integer nonProgressiveMasterId) {
		this.nonProgressiveMasterId = nonProgressiveMasterId;
	}

	public void setRevNo(Integer revNo) {
		this.revNo = revNo;
	}

	public void setValidatorId(Integer validatorId) {
		this.validatorId = validatorId;
	}

	public void setValidateStatus(Integer validateStatus) {
		this.validateStatus = validateStatus;
	}

	public void setValidateComment(String validateComment) {
		this.validateComment = validateComment;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
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
		return "NonProgressiveJournalMap [nonPrgvMapId=" + nonPrgvMapId + ", nonProgressiveMasterId="
				+ nonProgressiveMasterId + ", revNo=" + revNo + ", validatorId=" + validatorId + ", validateStatus="
				+ validateStatus + ", validateComment=" + validateComment + ", dataDate=" + dataDate + ", intCreatedBy="
				+ intCreatedBy + ", dtDateCreated=" + dtDateCreated + ", intModifiedBy=" + intModifiedBy
				+ ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDate == null) ? 0 : dataDate.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((nonPrgvMapId == null) ? 0 : nonPrgvMapId.hashCode());
		result = prime * result + ((nonProgressiveMasterId == null) ? 0 : nonProgressiveMasterId.hashCode());
		result = prime * result + ((revNo == null) ? 0 : revNo.hashCode());
		result = prime * result + ((validateComment == null) ? 0 : validateComment.hashCode());
		result = prime * result + ((validateStatus == null) ? 0 : validateStatus.hashCode());
		result = prime * result + ((validatorId == null) ? 0 : validatorId.hashCode());
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
		NonProgressiveJournalMap other = (NonProgressiveJournalMap) obj;
		if (dataDate == null) {
			if (other.dataDate != null)
				return false;
		} else if (!dataDate.equals(other.dataDate))
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
		if (intModifiedBy == null) {
			if (other.intModifiedBy != null)
				return false;
		} else if (!intModifiedBy.equals(other.intModifiedBy))
			return false;
		if (nonPrgvMapId == null) {
			if (other.nonPrgvMapId != null)
				return false;
		} else if (!nonPrgvMapId.equals(other.nonPrgvMapId))
			return false;
		if (nonProgressiveMasterId == null) {
			if (other.nonProgressiveMasterId != null)
				return false;
		} else if (!nonProgressiveMasterId.equals(other.nonProgressiveMasterId))
			return false;
		if (revNo == null) {
			if (other.revNo != null)
				return false;
		} else if (!revNo.equals(other.revNo))
			return false;
		if (validateComment == null) {
			if (other.validateComment != null)
				return false;
		} else if (!validateComment.equals(other.validateComment))
			return false;
		if (validateStatus == null) {
			if (other.validateStatus != null)
				return false;
		} else if (!validateStatus.equals(other.validateStatus))
			return false;
		if (validatorId == null) {
			if (other.validatorId != null)
				return false;
		} else if (!validatorId.equals(other.validatorId))
			return false;
		return true;
	}
}
