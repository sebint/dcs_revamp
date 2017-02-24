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
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_non_pgrv_jrnl_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class NonProgressiveJournalMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5268253626969730107L;
	
	@Id
	@Column(name = "NON_PGRV_JRNL_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonProgressiveMasterId;
	
	@NotEmpty
	@Column(name = "PJCT_TEMPLATE_MASTER_ID")
	private Integer projectMasterId;
	
	@NotEmpty
	@Column(name = "JRNL_NAME")
	private String journalName;
	
	@NotEmpty
	@Column(name = "OWNER")
	private Integer jounralOwner;
	
	@NotEmpty
	@Column(name = "VAL_ID")
	private Integer validatorId;
	
	@NotEmpty
	@Column(name = "DTETR_OPERATOR_ID")
	private Integer dataEntryId;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "REMAINDER_FREQUENCY")
	private String reminderFreq;
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

	public Integer getNonProgressiveMasterId() {
		return nonProgressiveMasterId;
	}

	public Integer getProjectMasterId() {
		return projectMasterId;
	}

	public String getJournalName() {
		return journalName;
	}

	public Integer getJounralOwner() {
		return jounralOwner;
	}

	public Integer getValidatorId() {
		return validatorId;
	}

	public Integer getDataEntryId() {
		return dataEntryId;
	}

	public String getStatus() {
		return status;
	}

	public String getReminderFreq() {
		return reminderFreq;
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

	public void setNonProgressiveMasterId(Integer nonProgressiveMasterId) {
		this.nonProgressiveMasterId = nonProgressiveMasterId;
	}

	public void setProjectMasterId(Integer projectMasterId) {
		this.projectMasterId = projectMasterId;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public void setJounralOwner(Integer jounralOwner) {
		this.jounralOwner = jounralOwner;
	}

	public void setValidatorId(Integer validatorId) {
		this.validatorId = validatorId;
	}

	public void setDataEntryId(Integer dataEntryId) {
		this.dataEntryId = dataEntryId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setReminderFreq(String reminderFreq) {
		this.reminderFreq = reminderFreq;
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
		return "NonProgressiveJournalMaster [nonProgressiveMasterId=" + nonProgressiveMasterId + ", projectMasterId="
				+ projectMasterId + ", journalName=" + journalName + ", jounralOwner=" + jounralOwner + ", validatorId="
				+ validatorId + ", dataEntryId=" + dataEntryId + ", status=" + status + ", reminderFreq=" + reminderFreq
				+ ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated + ", intModifiedBy="
				+ intModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEntryId == null) ? 0 : dataEntryId.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((jounralOwner == null) ? 0 : jounralOwner.hashCode());
		result = prime * result + ((journalName == null) ? 0 : journalName.hashCode());
		result = prime * result + ((nonProgressiveMasterId == null) ? 0 : nonProgressiveMasterId.hashCode());
		result = prime * result + ((projectMasterId == null) ? 0 : projectMasterId.hashCode());
		result = prime * result + ((reminderFreq == null) ? 0 : reminderFreq.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		NonProgressiveJournalMaster other = (NonProgressiveJournalMaster) obj;
		if (dataEntryId == null) {
			if (other.dataEntryId != null)
				return false;
		} else if (!dataEntryId.equals(other.dataEntryId))
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
		if (jounralOwner == null) {
			if (other.jounralOwner != null)
				return false;
		} else if (!jounralOwner.equals(other.jounralOwner))
			return false;
		if (journalName == null) {
			if (other.journalName != null)
				return false;
		} else if (!journalName.equals(other.journalName))
			return false;
		if (nonProgressiveMasterId == null) {
			if (other.nonProgressiveMasterId != null)
				return false;
		} else if (!nonProgressiveMasterId.equals(other.nonProgressiveMasterId))
			return false;
		if (projectMasterId == null) {
			if (other.projectMasterId != null)
				return false;
		} else if (!projectMasterId.equals(other.projectMasterId))
			return false;
		if (reminderFreq == null) {
			if (other.reminderFreq != null)
				return false;
		} else if (!reminderFreq.equals(other.reminderFreq))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (validatorId == null) {
			if (other.validatorId != null)
				return false;
		} else if (!validatorId.equals(other.validatorId))
			return false;
		return true;
	}
	
	
}
