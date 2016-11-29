package com.humworks.dcs.entities;

public enum UserType {
	IM("Information Manager"),
    GK("Gate Keeper"),
    ADMIN("DCS Administrator"),
	PDO("PDO");
	
	String userType;
    
    private UserType(String userType){
        this.userType = userType;
    }
     
    public String getUserProfileType(){
        return userType;
    }
}
