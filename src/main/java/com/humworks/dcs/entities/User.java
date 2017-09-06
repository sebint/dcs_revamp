package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_user_master")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_MASTER_ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer intUserId;

	@NotEmpty
	@Pattern(regexp="[^0-9<>'\"/;`%~@#$^*()_+={}|\\,.?: -]*")
	@Column(name = "FIRST_NAME")
	private String strFirstName;

	@Pattern(regexp="[^0-9<>'\"/;`%~@#$^*()_+={}|\\,.?: -]*")
	@Column(name = "LAST_NAME")
	private String strLastName;

	@NotEmpty
	@Pattern(regexp="[^0-9<>'\"/;`%~@#$^*()_+={}|\\,.?: -]*")
	@Column(name = "USER_NAME")
	private String strUserName;
	
	@Column(name = "USER_PASS")
	private String strPassword;

	@NotEmpty 
	@Email
	@Column(name = "EMAIL")
	private String strEmail;

	// @ManyToOne(optional = false)
	// @JoinColumn(name="ROLE_MASTER_ID")
	// private Role roles;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_user_role_master", joinColumns = { @JoinColumn(name = "USER_MASTER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_MASTER_ID") })
	private Set<Role> role = new HashSet<Role>();

	@NotEmpty
	@Pattern(regexp="[^0-9<>'\"/;`%~@#$^*()_+={}|\\,.?: ]*")
	@Column(name = "USER_DEPT_NAME")
	private String strDeptName;

	@Column(name = "NEXT_LOGIN_PWD_CHNG")
	private Integer boolPwdChange;

	@Column(name = "PWD_LOCK_STATUS")
	private Integer boolLockPwd;

	@Column(name = "PWD_ATTEMPT_COUNT")
	private Integer intPwdAttempt;
	
	@OneToOne
    @JoinColumn(name="USER_MASTER_ID")
    private UserStatus userStatus;

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

	@Transient
	private String strRePassword;
	
	@Transient
	private Integer intRoleId;

	public User() {
		// this form used by Hibernate
	}

	public Integer getIntUserId() {
		return intUserId;
	}

	public void setIntUserId(Integer intUserId) {
		this.intUserId = intUserId;
	}

	public String getStrFirstName() {
		return strFirstName;
	}

	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	public String getStrLastName() {
		return strLastName;
	}

	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public String getStrDeptName() {
		return strDeptName;
	}

	public void setStrDeptName(String strDeptName) {
		this.strDeptName = strDeptName;
	}

	public Integer getBoolPwdChange() {
		return boolPwdChange;
	}

	public void setBoolPwdChange(Integer boolPwdChange) {
		this.boolPwdChange = boolPwdChange;
	}

	public Integer getBoolLockPwd() {
		return boolLockPwd;
	}

	public void setBoolLockPwd(Integer boolLockPwd) {
		this.boolLockPwd = boolLockPwd;
	}

	public Integer getIntPwdAttempt() {
		return intPwdAttempt;
	}

	public void setIntPwdAttempt(Integer intPwdAttempt) {
		this.intPwdAttempt = intPwdAttempt;
	}
	
	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getIntCreatedBy() {
		return intCreatedBy;
	}

	public void setIntCreatedBy(Integer intCreatedBy) {
		this.intCreatedBy = intCreatedBy;
	}

	public Date getDtDateCreated() {
		return dtDateCreated;
	}

	public void setDtDateCreated(Date dtDateCreated) {
		this.dtDateCreated = dtDateCreated;
	}

	public Integer getIntModifiedBy() {
		return intModifiedBy;
	}

	public void setIntModifiedBy(Integer intModifiedBy) {
		this.intModifiedBy = intModifiedBy;
	}

	public Date getDtDateModified() {
		return dtDateModified;
	}

	public void setDtDateModified(Date dtDateModified) {
		this.dtDateModified = dtDateModified;
	}

	public String getStrRePassword() {
		return strRePassword;
	}

	public void setStrRePassword(String strRePassword) {
		this.strRePassword = strRePassword;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
	

	public Integer getIntRoleId() {
		return intRoleId;
	}

	public void setIntRoleId(Integer intRoleId) {
		this.intRoleId = intRoleId;
	}

	@Override
	public String toString() {
		return "User [intUserId=" + intUserId + ", strFirstName=" + strFirstName + ", strLastName=" + strLastName
				+ ", strUserName=" + strUserName + ", strPassword=" + strPassword + ", strEmail=" + strEmail + ", role="
				+ role + ", strDeptName=" + strDeptName + ", boolPwdChange=" + boolPwdChange + ", boolLockPwd="
				+ boolLockPwd + ", intPwdAttempt=" + intPwdAttempt + ", userStatus=" + userStatus + ", intCreatedBy="
				+ intCreatedBy + ", dtDateCreated=" + dtDateCreated + ", intModifiedBy=" + intModifiedBy
				+ ", dtDateModified=" + dtDateModified + ", strRePassword=" + strRePassword + ", intRoleId=" + intRoleId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boolLockPwd == null) ? 0 : boolLockPwd.hashCode());
		result = prime * result + ((boolPwdChange == null) ? 0 : boolPwdChange.hashCode());
		result = prime * result + ((dtDateCreated == null) ? 0 : dtDateCreated.hashCode());
		result = prime * result + ((dtDateModified == null) ? 0 : dtDateModified.hashCode());
		result = prime * result + ((intCreatedBy == null) ? 0 : intCreatedBy.hashCode());
		result = prime * result + ((intModifiedBy == null) ? 0 : intModifiedBy.hashCode());
		result = prime * result + ((intPwdAttempt == null) ? 0 : intPwdAttempt.hashCode());
		result = prime * result + ((intRoleId == null) ? 0 : intRoleId.hashCode());
		result = prime * result + ((intUserId == null) ? 0 : intUserId.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((strDeptName == null) ? 0 : strDeptName.hashCode());
		result = prime * result + ((strEmail == null) ? 0 : strEmail.hashCode());
		result = prime * result + ((strFirstName == null) ? 0 : strFirstName.hashCode());
		result = prime * result + ((strLastName == null) ? 0 : strLastName.hashCode());
		result = prime * result + ((strPassword == null) ? 0 : strPassword.hashCode());
		result = prime * result + ((strRePassword == null) ? 0 : strRePassword.hashCode());
		result = prime * result + ((strUserName == null) ? 0 : strUserName.hashCode());
		result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
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
		User other = (User) obj;
		if (boolLockPwd == null) {
			if (other.boolLockPwd != null)
				return false;
		} else if (!boolLockPwd.equals(other.boolLockPwd))
			return false;
		if (boolPwdChange == null) {
			if (other.boolPwdChange != null)
				return false;
		} else if (!boolPwdChange.equals(other.boolPwdChange))
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
		if (intPwdAttempt == null) {
			if (other.intPwdAttempt != null)
				return false;
		} else if (!intPwdAttempt.equals(other.intPwdAttempt))
			return false;
		if (intRoleId == null) {
			if (other.intRoleId != null)
				return false;
		} else if (!intRoleId.equals(other.intRoleId))
			return false;
		if (intUserId == null) {
			if (other.intUserId != null)
				return false;
		} else if (!intUserId.equals(other.intUserId))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (strDeptName == null) {
			if (other.strDeptName != null)
				return false;
		} else if (!strDeptName.equals(other.strDeptName))
			return false;
		if (strEmail == null) {
			if (other.strEmail != null)
				return false;
		} else if (!strEmail.equals(other.strEmail))
			return false;
		if (strFirstName == null) {
			if (other.strFirstName != null)
				return false;
		} else if (!strFirstName.equals(other.strFirstName))
			return false;
		if (strLastName == null) {
			if (other.strLastName != null)
				return false;
		} else if (!strLastName.equals(other.strLastName))
			return false;
		if (strPassword == null) {
			if (other.strPassword != null)
				return false;
		} else if (!strPassword.equals(other.strPassword))
			return false;
		if (strRePassword == null) {
			if (other.strRePassword != null)
				return false;
		} else if (!strRePassword.equals(other.strRePassword))
			return false;
		if (strUserName == null) {
			if (other.strUserName != null)
				return false;
		} else if (!strUserName.equals(other.strUserName))
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
			return false;
		return true;
	}
	
	

}
