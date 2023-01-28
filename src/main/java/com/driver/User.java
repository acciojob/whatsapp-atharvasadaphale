package com.driver;

public class User {
    private String name;
    private String mobile;
    private String mobileNumber;

    public User(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGroupName() {
        return this.getGroupName();
    }

    public Object getGroup() {
        return this.getGroup();
    }

    public void setGroup(Group group) {
    }
}
