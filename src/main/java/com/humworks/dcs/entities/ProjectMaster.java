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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_pjct_template_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class ProjectMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5886243011187938594L;
	
	@Id
	@Column(name = "PJCT_TEMPLATE_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectMasterId;
	
	@NotEmpty
	@Column(name = "PJCT_NAME", unique = true, nullable = false)
	private String projectName;
	
	@NotEmpty
	@Column(name = "PJCT_DESC", nullable = false)
	private String projectDesc;
	
	@NotNull
	@Column(name = "USER_MASTER_ID", nullable = false)
	private Integer userMasterId;
	
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "END_DATE")
	private Date endDate;
	
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
    @JoinColumn(name="USER_MASTER_ID", insertable = false, updatable = false)
    private User user;

	public Integer getProjectMasterId() {
		return projectMasterId;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public Integer getUserMasterId() {
		return userMasterId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
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

	public void setProjectMasterId(Integer projectMasterId) {
		this.projectMasterId = projectMasterId;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public void setUserMasterId(Integer userMasterId) {
		this.userMasterId = userMasterId;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ProjectMaster [projectMasterId=" + projectMasterId + ", projectName=" + projectName + ", projectDesc="
				+ projectDesc + ", userMasterId=" + userMasterId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", intCreatedBy=" + intCreatedBy + ", dtDateCreated=" + dtDateCreated + ", intModifiedBy="
				+ intModifiedBy + ", dtDateModified=" + dtDateModified + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((projectDesc == null) ? 0 : projectDesc.hashCode());
		result = prime * result + ((projectMasterId == null) ? 0 : projectMasterId.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userMasterId == null) ? 0 : userMasterId.hashCode());
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
		ProjectMaster other = (ProjectMaster) obj;
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
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
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
		if (projectDesc == null) {
			if (other.projectDesc != null)
				return false;
		} else if (!projectDesc.equals(other.projectDesc))
			return false;
		if (projectMasterId == null) {
			if (other.projectMasterId != null)
				return false;
		} else if (!projectMasterId.equals(other.projectMasterId))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userMasterId == null) {
			if (other.userMasterId != null)
				return false;
		} else if (!userMasterId.equals(other.userMasterId))
			return false;
		return true;
	}
	
	
	
}
