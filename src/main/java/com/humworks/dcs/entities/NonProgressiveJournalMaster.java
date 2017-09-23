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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_non_pgrv_jrnl_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class NonProgressiveJournalMaster extends  AuditMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5268253626969730107L;
	
	@Id
	@Column(name = "NON_PGRV_JRNL_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nonProgressiveMasterId;
	
	@NotNull
	@Column(name = "PJCT_TEMPLATE_MASTER_ID")
	private Long projectMasterId;
	
	@NotEmpty
	@Column(name = "JRNL_NAME", nullable = false)
	private String journalName;
	
	@NotNull
	@Column(name = "OWNER")
	private Long jounralOwner;
	
	@NotNull
	@Column(name = "VAL_ID")
	private Long validatorId;
	
	@NotNull
	@Column(name = "DTETR_OPERATOR_ID")
	private Long dataEntryId;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "REMAINDER_FREQUENCY")
	private Integer reminderFreq;	
	
	@ManyToOne
    @JoinColumn(name="PJCT_TEMPLATE_MASTER_ID", insertable = false, updatable = false)
    private ProjectMaster project;
	
	@ManyToOne
    @JoinColumn(name="OWNER", insertable = false, updatable = false)
    private User user;
	
	@ManyToOne
    @JoinColumn(name="VAL_ID", insertable = false, updatable = false)
    private User validator;
	
	@ManyToOne
    @JoinColumn(name="DTETR_OPERATOR_ID", insertable = false, updatable = false)
    private User dataentry;
	
	@ManyToOne
    @JoinColumn(name="CREATED_BY", insertable = false, updatable = false)
    private User createdUser;
	
	@ManyToOne
    @JoinColumn(name="MODIFIED_BY", insertable = false, updatable = false)
    private User modifiedUser;

	public Long getNonProgressiveMasterId() {
		return nonProgressiveMasterId;
	}

	public Long getProjectMasterId() {
		return projectMasterId;
	}

	public String getJournalName() {
		return journalName;
	}

	public Long getJounralOwner() {
		return jounralOwner;
	}

	public Long getValidatorId() {
		return validatorId;
	}

	public Long getDataEntryId() {
		return dataEntryId;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getReminderFreq() {
		return reminderFreq;
	}

	public String getIntCreatedBy() {
		return intCreatedBy;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public String getIntModifiedBy() {
		return intModifiedBy;
	}

	public Date getDtDateModified() {
		return dtDateModified;
	}

	public ProjectMaster getProject() {
		return project;
	}

	public User getUser() {
		return user;
	}

	public User getValidator() {
		return validator;
	}

	public User getDataentry() {
		return dataentry;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public User getModifiedUser() {
		return modifiedUser;
	}

	public void setNonProgressiveMasterId(Long nonProgressiveMasterId) {
		this.nonProgressiveMasterId = nonProgressiveMasterId;
	}

	public void setProjectMasterId(Long projectMasterId) {
		this.projectMasterId = projectMasterId;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public void setJounralOwner(Long jounralOwner) {
		this.jounralOwner = jounralOwner;
	}

	public void setValidatorId(Long validatorId) {
		this.validatorId = validatorId;
	}

	public void setDataEntryId(Long dataEntryId) {
		this.dataEntryId = dataEntryId;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setReminderFreq(Integer reminderFreq) {
		this.reminderFreq = reminderFreq;
	}

	public void setIntCreatedBy(String intCreatedBy) {
		this.intCreatedBy = intCreatedBy;
	}

	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}

	public void setIntModifiedBy(String intModifiedBy) {
		this.intModifiedBy = intModifiedBy;
	}

	public void setDtDateModified(Date dtDateModified) {
		this.dtDateModified = dtDateModified;
	}

	public void setProject(ProjectMaster project) {
		this.project = project;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setValidator(User validator) {
		this.validator = validator;
	}

	public void setDataentry(User dataentry) {
		this.dataentry = dataentry;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

	public void setModifiedUser(User modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	@Override
	public String toString() {
		return "NonProgressiveJournalMaster [nonProgressiveMasterId=" + nonProgressiveMasterId + ", projectMasterId="
				+ projectMasterId + ", journalName=" + journalName + ", jounralOwner=" + jounralOwner + ", validatorId="
				+ validatorId + ", dataEntryId=" + dataEntryId + ", status=" + status + ", reminderFreq=" + reminderFreq
				+ ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated + ", intModifiedBy="
				+ intModifiedBy + ", dtDateModified=" + dtDateModified + ", project=" + project + ", user=" + user
				+ ", validator=" + validator + ", dataentry=" + dataentry + ", createdUser=" + createdUser
				+ ", modifiedUser=" + modifiedUser + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + ((dataEntryId == null) ? 0 : dataEntryId.hashCode());
		result = prime * result + ((dataentry == null) ? 0 : dataentry.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((jounralOwner == null) ? 0 : jounralOwner.hashCode());
		result = prime * result + ((journalName == null) ? 0 : journalName.hashCode());
		result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
		result = prime * result + ((nonProgressiveMasterId == null) ? 0 : nonProgressiveMasterId.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((projectMasterId == null) ? 0 : projectMasterId.hashCode());
		result = prime * result + ((reminderFreq == null) ? 0 : reminderFreq.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((validator == null) ? 0 : validator.hashCode());
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
		if (createdUser == null) {
			if (other.createdUser != null)
				return false;
		} else if (!createdUser.equals(other.createdUser))
			return false;
		if (dataEntryId == null) {
			if (other.dataEntryId != null)
				return false;
		} else if (!dataEntryId.equals(other.dataEntryId))
			return false;
		if (dataentry == null) {
			if (other.dataentry != null)
				return false;
		} else if (!dataentry.equals(other.dataentry))
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
		if (modifiedUser == null) {
			if (other.modifiedUser != null)
				return false;
		} else if (!modifiedUser.equals(other.modifiedUser))
			return false;
		if (nonProgressiveMasterId == null) {
			if (other.nonProgressiveMasterId != null)
				return false;
		} else if (!nonProgressiveMasterId.equals(other.nonProgressiveMasterId))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (validator == null) {
			if (other.validator != null)
				return false;
		} else if (!validator.equals(other.validator))
			return false;
		if (validatorId == null) {
			if (other.validatorId != null)
				return false;
		} else if (!validatorId.equals(other.validatorId))
			return false;
		return true;
	}
	
	
	
}
