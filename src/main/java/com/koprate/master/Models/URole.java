package com.koprate.master.Models;

public enum URole {
    ADMIN("Administrator");
    USER("Normal User");
    MANAGER("Manager");
    HR("HR");

    private String role;

    void Role(String role){
        this.role = role;
    }

    public String getValue(){
        return role;
    }
}
