package com.humworks.dcs.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class JsonEntryRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4218424729133052276L;
	
	private Integer journalId;
	private boolean isPublish;
	private String dataDate;
	private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	
	public Integer getJournalId() {
		return journalId;
	}
	public boolean isPublish() {
		return isPublish;
	}
	public String getDataDate() {
		return dataDate;
	}
	public ArrayList<ArrayList<String>> getData() {
		return data;
	}
	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "JsonEntryRequest [journalId=" + journalId + ", isPublish=" + isPublish + ", dataDate=" + dataDate
				+ ", data=" + data + "]";
	}
	

}
