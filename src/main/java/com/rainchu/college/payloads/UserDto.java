package com.rainchu.college.payloads;

public class UserDto {
    private int uId;
    private String name;
    private String email;
    private String password;
    private String about;

    public UserDto() {
    }

    public UserDto(int uId, String name, String email, String password, String about) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "uId=" + uId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
