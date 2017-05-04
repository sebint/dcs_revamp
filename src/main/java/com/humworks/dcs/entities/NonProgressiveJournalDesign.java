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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_non_pgrv_jrnl_design")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class NonProgressiveJournalDesign implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1544585251585507618L;
	
	@Id
	@Column(name = "NON_PGRV_JRNL_DESIGN_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonPrgvDesignId;
	
	@Column(name = "NON_PGRV_JRNL_MASTER_ID")
	private Integer nonProgressiveMasterId;
	
	@Column(name = "UOM_MASTER_ID")
	private Integer uomId;
	
	@Column(name = "COL_HEAD_TEXT")
	private String colHeaderText;
	
	@Column(name = "COL_HEAD_WIDTH")
	private Integer colHeaderWidth;
	
	@Column(name = "COL_TYPE")
	private String colType;
	
	@Column(name = "COL_ORDER")
	private Integer colOrder;
	
	@Column(name = "IS_VALIDATE_PENDING")
	private Integer isValidPending;
	
	@Column(name = "VALIDATE_REVISION")
	private Integer validRevision;
	
	@Column(name = "LOOKUP_MASTER_ID")
	private Integer lookupMasterId;
	
	@Column(name = "IS_READ_ONLY")
	private Integer isReadOnly;
	
	@Column(name = "PGRV_LINK_ID")
	private Integer prgvLinkId;
	
	@Column(name = "NON_PRGV_LINK_IDS")
	private String nonPrgvLinkId;
	
	@Column(name = "FORMULA_APPLIED")
	private String formula;
	
	@Column(name = "STATUS")
	private Integer status;

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
    @JoinColumn(name="NON_PGRV_JRNL_MASTER_ID", insertable = false, updatable = false)
    private NonProgressiveJournalMaster nonProgressive;
	
	public NonProgressiveJournalDesign(){	
	}

	public NonProgressiveJournalDesign(Integer nonProgressiveMasterId, NonProgressiveJournalMaster nonProgressive) {
		super();
		this.nonProgressiveMasterId = nonProgressiveMasterId;
		this.nonProgressive = nonProgressive;
	}

	public Integer getNonPrgvDesignId() {
		return nonPrgvDesignId;
	}

	public Integer getNonProgressiveMasterId() {
		return nonProgressiveMasterId;
	}

	public Integer getUomId() {
		return uomId;
	}

	public String getColHeaderText() {
		return colHeaderText;
	}

	public Integer getColHeaderWidth() {
		return colHeaderWidth;
	}

	public String getColType() {
		return colType;
	}

	public Integer getColOrder() {
		return colOrder;
	}

	public Integer getIsValidPending() {
		return isValidPending;
	}

	public Integer getValidRevision() {
		return validRevision;
	}

	public Integer getLookupMasterId() {
		return lookupMasterId;
	}

	public Integer getIsReadOnly() {
		return isReadOnly;
	}

	public Integer getPrgvLinkId() {
		return prgvLinkId;
	}

	public String getNonPrgvLinkId() {
		return nonPrgvLinkId;
	}

	public String getFormula() {
		return formula;
	}

	public Integer getStatus() {
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

	public void setNonPrgvDesignId(Integer nonPrgvDesignId) {
		this.nonPrgvDesignId = nonPrgvDesignId;
	}

	public void setNonProgressiveMasterId(Integer nonProgressiveMasterId) {
		this.nonProgressiveMasterId = nonProgressiveMasterId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public void setColHeaderText(String colHeaderText) {
		this.colHeaderText = colHeaderText;
	}

	public void setColHeaderWidth(Integer colHeaderWidth) {
		this.colHeaderWidth = colHeaderWidth;
	}

	public void setColType(String colType) {
		this.colType = colType;
	}

	public void setColOrder(Integer colOrder) {
		this.colOrder = colOrder;
	}

	public void setIsValidPending(Integer isValidPending) {
		this.isValidPending = isValidPending;
	}

	public void setValidRevision(Integer validRevision) {
		this.validRevision = validRevision;
	}

	public void setLookupMasterId(Integer lookupMasterId) {
		this.lookupMasterId = lookupMasterId;
	}

	public void setIsReadOnly(Integer isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	public void setPrgvLinkId(Integer prgvLinkId) {
		this.prgvLinkId = prgvLinkId;
	}

	public void setNonPrgvLinkId(String nonPrgvLinkId) {
		this.nonPrgvLinkId = nonPrgvLinkId;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public void setStatus(Integer status) {
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
	
	public NonProgressiveJournalMaster getNonProgressive() {
		return nonProgressive;
	}

	public void setNonProgressive(NonProgressiveJournalMaster nonProgressive) {
		this.nonProgressive = nonProgressive;
	}

	@Override
	public String toString() {
		return "NonProgressiveJournalDesign [nonPrgvDesignId=" + nonPrgvDesignId + ", nonProgressiveMasterId="
				+ nonProgressiveMasterId + ", uomId=" + uomId + ", colHeaderText=" + colHeaderText + ", colHeaderWidth="
				+ colHeaderWidth + ", colType=" + colType + ", colOrder=" + colOrder + ", isValidPending="
				+ isValidPending + ", validRevision=" + validRevision + ", lookupMasterId=" + lookupMasterId
				+ ", isReadOnly=" + isReadOnly + ", prgvLinkId=" + prgvLinkId + ", nonPrgvLinkId=" + nonPrgvLinkId
				+ ", formula=" + formula + ", status=" + status + ", intCreatedBy=" + intCreatedBy + ", dtDateCreated="
				+ dtDateCreated + ", intModifiedBy=" + intModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colHeaderText == null) ? 0 : colHeaderText.hashCode());
		result = prime * result + ((colHeaderWidth == null) ? 0 : colHeaderWidth.hashCode());
		result = prime * result + ((colOrder == null) ? 0 : colOrder.hashCode());
		result = prime * result + ((colType == null) ? 0 : colType.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((formula == null) ? 0 : formula.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((isReadOnly == null) ? 0 : isReadOnly.hashCode());
		result = prime * result + ((isValidPending == null) ? 0 : isValidPending.hashCode());
		result = prime * result + ((lookupMasterId == null) ? 0 : lookupMasterId.hashCode());
		result = prime * result + ((nonPrgvDesignId == null) ? 0 : nonPrgvDesignId.hashCode());
		result = prime * result + ((nonPrgvLinkId == null) ? 0 : nonPrgvLinkId.hashCode());
		result = prime * result + ((nonProgressiveMasterId == null) ? 0 : nonProgressiveMasterId.hashCode());
		result = prime * result + ((prgvLinkId == null) ? 0 : prgvLinkId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((uomId == null) ? 0 : uomId.hashCode());
		result = prime * result + ((validRevision == null) ? 0 : validRevision.hashCode());
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
		NonProgressiveJournalDesign other = (NonProgressiveJournalDesign) obj;
		if (colHeaderText == null) {
			if (other.colHeaderText != null)
				return false;
		} else if (!colHeaderText.equals(other.colHeaderText))
			return false;
		if (colHeaderWidth == null) {
			if (other.colHeaderWidth != null)
				return false;
		} else if (!colHeaderWidth.equals(other.colHeaderWidth))
			return false;
		if (colOrder == null) {
			if (other.colOrder != null)
				return false;
		} else if (!colOrder.equals(other.colOrder))
			return false;
		if (colType == null) {
			if (other.colType != null)
				return false;
		} else if (!colType.equals(other.colType))
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
		if (formula == null) {
			if (other.formula != null)
				return false;
		} else if (!formula.equals(other.formula))
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
		if (isReadOnly == null) {
			if (other.isReadOnly != null)
				return false;
		} else if (!isReadOnly.equals(other.isReadOnly))
			return false;
		if (isValidPending == null) {
			if (other.isValidPending != null)
				return false;
		} else if (!isValidPending.equals(other.isValidPending))
			return false;
		if (lookupMasterId == null) {
			if (other.lookupMasterId != null)
				return false;
		} else if (!lookupMasterId.equals(other.lookupMasterId))
			return false;
		if (nonPrgvDesignId == null) {
			if (other.nonPrgvDesignId != null)
				return false;
		} else if (!nonPrgvDesignId.equals(other.nonPrgvDesignId))
			return false;
		if (nonPrgvLinkId == null) {
			if (other.nonPrgvLinkId != null)
				return false;
		} else if (!nonPrgvLinkId.equals(other.nonPrgvLinkId))
			return false;
		if (nonProgressiveMasterId == null) {
			if (other.nonProgressiveMasterId != null)
				return false;
		} else if (!nonProgressiveMasterId.equals(other.nonProgressiveMasterId))
			return false;
		if (prgvLinkId == null) {
			if (other.prgvLinkId != null)
				return false;
		} else if (!prgvLinkId.equals(other.prgvLinkId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (uomId == null) {
			if (other.uomId != null)
				return false;
		} else if (!uomId.equals(other.uomId))
			return false;
		if (validRevision == null) {
			if (other.validRevision != null)
				return false;
		} else if (!validRevision.equals(other.validRevision))
			return false;
		return true;
	}
	
	

}