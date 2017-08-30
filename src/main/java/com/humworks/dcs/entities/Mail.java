package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbl_mail_master")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Mail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -133594705576086841L;
	
	@Id
	@Column(name = "MAIL_MASTER_ID", updatable = false)
	private Integer mailId;
	
	@NotEmpty
	@Column(name = "MAIL_TYPE", nullable = false)
	private String mailType;
	
	@NotEmpty
	@Column(name = "MAIL_TARGET_ID", nullable = false)
	private String mailTargetId;
	
	@NotEmpty
	@Column(name = "MAIL_SOURCE_ID", nullable = false)
	private String mailSourceId;
	
	@Column(name = "MAIL_STATUS", updatable = false)
	private Integer mailStatus;
	
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
	

}
