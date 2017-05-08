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

public class NonProgressiveJournalEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2909451325609461426L;
	
	@Id
	@Column(name = "NON_PGRV_JRNL_DATA_ENTRY_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonPrgvEntryId;
	
	@Column(name = "NON_PGRV_JRNL_DATA_MAP_ID", nullable = false)
	private Integer nonPrgvMapId;
	
	@Column(name = "NON_PGRV_JRNL_DESIGN_ID", nullable = false)
	private Integer nonPrgvDesignId;
	
	@Column(name = "ROW_NO", nullable = false)
	private Integer rowNo;
	
	@Column(name = "ROW_VALUE")
	private String rowValue;
	
	@Column(name = "READ_ONLY", nullable = false)
	private Integer readOnly;
	
	@Column(name = "VALIDATOR_ROW_COMMENT")
	private String validatorRowCmt;
	
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

	public Integer getNonPrgvEntryId() {
		return nonPrgvEntryId;
	}

	public Integer getNonPrgvMapId() {
		return nonPrgvMapId;
	}

	public Integer getNonPrgvDesignId() {
		return nonPrgvDesignId;
	}

	public Integer getRowNo() {
		return rowNo;
	}

	public String getRowValue() {
		return rowValue;
	}

	public Integer getReadOnly() {
		return readOnly;
	}

	public String getValidatorRowCmt() {
		return validatorRowCmt;
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

	public void setNonPrgvEntryId(Integer nonPrgvEntryId) {
		this.nonPrgvEntryId = nonPrgvEntryId;
	}

	public void setNonPrgvMapId(Integer nonPrgvMapId) {
		this.nonPrgvMapId = nonPrgvMapId;
	}

	public void setNonPrgvDesignId(Integer nonPrgvDesignId) {
		this.nonPrgvDesignId = nonPrgvDesignId;
	}

	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}

	public void setRowValue(String rowValue) {
		this.rowValue = rowValue;
	}

	public void setReadOnly(Integer readOnly) {
		this.readOnly = readOnly;
	}

	public void setValidatorRowCmt(String validatorRowCmt) {
		this.validatorRowCmt = validatorRowCmt;
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
		return "NonProgressiveJournalEntry [nonPrgvEntryId=" + nonPrgvEntryId + ", nonPrgvMapId=" + nonPrgvMapId
				+ ", nonPrgvDesignId=" + nonPrgvDesignId + ", rowNo=" + rowNo + ", rowValue=" + rowValue + ", readOnly="
				+ readOnly + ", validatorRowCmt=" + validatorRowCmt + ", intCreatedBy=" + intCreatedBy
				+ ", dtDateCreated=" + dtDateCreated + ", intModifiedBy=" + intModifiedBy + ", dtDateModified="
				+ dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((nonPrgvDesignId == null) ? 0 : nonPrgvDesignId.hashCode());
		result = prime * result + ((nonPrgvEntryId == null) ? 0 : nonPrgvEntryId.hashCode());
		result = prime * result + ((nonPrgvMapId == null) ? 0 : nonPrgvMapId.hashCode());
		result = prime * result + ((readOnly == null) ? 0 : readOnly.hashCode());
		result = prime * result + ((rowNo == null) ? 0 : rowNo.hashCode());
		result = prime * result + ((rowValue == null) ? 0 : rowValue.hashCode());
		result = prime * result + ((validatorRowCmt == null) ? 0 : validatorRowCmt.hashCode());
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
		NonProgressiveJournalEntry other = (NonProgressiveJournalEntry) obj;
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
		if (nonPrgvDesignId == null) {
			if (other.nonPrgvDesignId != null)
				return false;
		} else if (!nonPrgvDesignId.equals(other.nonPrgvDesignId))
			return false;
		if (nonPrgvEntryId == null) {
			if (other.nonPrgvEntryId != null)
				return false;
		} else if (!nonPrgvEntryId.equals(other.nonPrgvEntryId))
			return false;
		if (nonPrgvMapId == null) {
			if (other.nonPrgvMapId != null)
				return false;
		} else if (!nonPrgvMapId.equals(other.nonPrgvMapId))
			return false;
		if (readOnly == null) {
			if (other.readOnly != null)
				return false;
		} else if (!readOnly.equals(other.readOnly))
			return false;
		if (rowNo == null) {
			if (other.rowNo != null)
				return false;
		} else if (!rowNo.equals(other.rowNo))
			return false;
		if (rowValue == null) {
			if (other.rowValue != null)
				return false;
		} else if (!rowValue.equals(other.rowValue))
			return false;
		if (validatorRowCmt == null) {
			if (other.validatorRowCmt != null)
				return false;
		} else if (!validatorRowCmt.equals(other.validatorRowCmt))
			return false;
		return true;
	}
}
