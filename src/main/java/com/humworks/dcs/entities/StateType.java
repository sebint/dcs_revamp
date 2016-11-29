package com.humworks.dcs.entities;

public enum StateType {
	ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");
     
	private String stateType;
	
	private StateType(final String stateType){
		this.stateType = stateType;
	}
	
	public String getStateType(){
		return this.stateType;
	}
	
	@Override
    public String toString(){
        return this.stateType;
    }
 
 
    public String getName(){
        return this.name();
    }
}
