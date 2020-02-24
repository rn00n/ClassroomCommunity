package com.team3.user.model;

public class UserDTO {
    private String id;
    private String name;
    private String pw;
    private String phone;

    public UserDTO() {}

    public UserDTO(String id, String name, String pw, String phone) {
        this.id = id;
        this.name = name;
        this.pw = pw;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pw='" + pw + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
