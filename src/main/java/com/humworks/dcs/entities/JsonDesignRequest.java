package com.humworks.dcs.entities;

import java.io.Serializable;

public class JsonDesignRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2238635605329001343L;
	
	private Long config_no;
	private String header;
	private String type;
	private Long uom;
	private Integer width;
	private Integer order;
	private Long lookup_id;
	private Integer progressive_link;
	private String non_progressive_link;
	private boolean readonly; 
	private String formula;
	private Long journalId;
	private Integer validate_pending;
	private Integer validate_revision;
	

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Long getConfig_no() {
		return config_no;
	}

	public void setConfig_no(Long config_no) {
		this.config_no = config_no;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getType() {
		return type;
	}

	public Long getUom() {
		return uom;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getOrder() {
		return order;
	}

	public Long getLookup_id() {
		return lookup_id;
	}

	public Integer getProgressive_link() {
		return progressive_link;
	}

	public String getNon_progressive_link() {
		return non_progressive_link;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUom(Long uom) {
		this.uom = uom;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public void setLookup_id(Long lookup_id) {
		this.lookup_id = lookup_id;
	}

	public void setProgressive_link(Integer progressive_link) {
		this.progressive_link = progressive_link;
	}

	public void setNon_progressive_link(String non_progressive_link) {
		this.non_progressive_link = non_progressive_link;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public Long getJournalId() {
		return journalId;
	}

	public void setJournalId(Long journalId) {
		this.journalId = journalId;
	}

	public Integer getValidate_pending() {
		return validate_pending;
	}

	public Integer getValidate_revision() {
		return validate_revision;
	}

	public void setValidate_pending(Integer validate_pending) {
		this.validate_pending = validate_pending;
	}

	public void setValidate_revision(Integer validate_revision) {
		this.validate_revision = validate_revision;
	}
	
	

}
