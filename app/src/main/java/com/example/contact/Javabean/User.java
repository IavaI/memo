package com.example.contact.Javabean;

public class User {
    private String userAccount;//账号
    private String userPassword;//密码
    private String userName;//姓名
    private int sex;//性别，0是女，1是男
    private String userPhone;//电话号码

    public User(String userAccount,String userPassword,String userName, int sex, String userPhone) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.sex = sex;
        this.userPhone = userPhone;
    }


    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
