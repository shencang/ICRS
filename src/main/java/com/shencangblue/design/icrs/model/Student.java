package com.shencangblue.design.icrs.model;

public class Student {
    private long studentId;
    private String studentIdName;
    private String username;
    private String phone;
    private String email;
    private int status;
    private int departmentId;
    private String password;
    private int role;
    private String RFIDid;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentIdName() {
        return studentIdName;
    }

    public void setEmployeeName(String studentIdName) {
        this.studentIdName = studentIdName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getRFIDid() {
        return RFIDid;
    }

    public void setRFIDid(String RFIDid) {
        this.RFIDid = RFIDid;
    }
}
