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
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_pjct_template_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class ProjectMaster extends AuditMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5886243011187938594L;
	
	@Id
	@Column(name = "PJCT_TEMPLATE_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectMasterId;
	
	@NotEmpty
	@Size(min = 2, max = 50)
	@Column(name = "PJCT_NAME", unique = true, nullable = false)
	private String projectName;
	
	@NotEmpty
	@Size(min = 2, max = 200)
	@Column(name = "PJCT_DESC", nullable = false)
	private String projectDesc;
	
	@NotNull
	@Column(name = "USER_MASTER_ID", nullable = false)
	private Long userMasterId;
	
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "END_DATE")
	private Date endDate;
	
	@ManyToOne
    @JoinColumn(name="USER_MASTER_ID", insertable = false, updatable = false)
    private User user;
	
	@ManyToOne
    @JoinColumn(name="MODIFIED_BY", insertable = false, updatable = false)
    private User modifiedUser;
	
	@ManyToOne
    @JoinColumn(name="CREATED_BY", insertable = false, updatable = false)
    private User createdUser;

	public Long getProjectMasterId() {
		return projectMasterId;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public Long getUserMasterId() {
		return userMasterId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getStrCreatedBy() {
		return strCreatedBy;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public String getStrModifiedBy() {
		return strModifiedBy;
	}

	public Date getDtDateModified() {
		return dtDateModified;
	}

	public User getUser() {
		return user;
	}

	public User getModifiedUser() {
		return modifiedUser;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setProjectMasterId(Long projectMasterId) {
		this.projectMasterId = projectMasterId;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public void setUserMasterId(Long userMasterId) {
		this.userMasterId = userMasterId;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStrCreatedBy(String strCreatedBy) {
		this.strCreatedBy = strCreatedBy;
	}

	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}

	public void setStrModifiedBy(String strModifiedBy) {
		this.strModifiedBy = strModifiedBy;
	}

	public void setDtDateModified(Date dtDateModified) {
		this.dtDateModified = dtDateModified;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setModifiedUser(User modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

	@Override
	public String toString() {
		return "ProjectMaster [projectMasterId=" + projectMasterId + ", projectName=" + projectName + ", projectDesc="
				+ projectDesc + ", userMasterId=" + userMasterId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", user=" + user + ", modifiedUser=" + modifiedUser + ", createdUser=" + createdUser
				+ ", strCreatedBy=" + strCreatedBy + ", dtDateCreated=" + dtDateCreated + ", strModifiedBy="
				+ strModifiedBy + ", dtDateModified=" + dtDateModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((strCreatedBy == null) ? 0 : strCreatedBy.hashCode());
		result = prime * result + ((strModifiedBy == null) ? 0 : strModifiedBy.hashCode());
		result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
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
		if (createdUser == null) {
			if (other.createdUser != null)
				return false;
		} else if (!createdUser.equals(other.createdUser))
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
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (strCreatedBy == null) {
			if (other.strCreatedBy != null)
				return false;
		} else if (!strCreatedBy.equals(other.strCreatedBy))
			return false;
		if (strModifiedBy == null) {
			if (other.strModifiedBy != null)
				return false;
		} else if (!strModifiedBy.equals(other.strModifiedBy))
			return false;
		if (modifiedUser == null) {
			if (other.modifiedUser != null)
				return false;
		} else if (!modifiedUser.equals(other.modifiedUser))
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
