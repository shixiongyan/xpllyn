package com.xpllyn.pojo;

/**
 * User pojo created at 2019/7/22 by Peiliang Xie
 */
public class User {
    private String user_email;
    private String user_password;
    private String user_last_login;
    private String user_name;
    private String user_sex;
    private String user_phone;
    private String user_address;

    public User(String user_email, String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public User(String user_email, String user_password, String user_last_login, String user_name, String user_sex, String user_phone, String user_address) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_last_login = user_last_login;
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_phone = user_phone;
        this.user_address = user_address;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_last_login() {
        return user_last_login;
    }

    public void setUser_last_login(String user_last_login) {
        this.user_last_login = user_last_login;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
}
