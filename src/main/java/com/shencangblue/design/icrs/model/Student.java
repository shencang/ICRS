package com.shencangblue.design.icrs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shencangblue.design.icrs.model.admin.AdminRole;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId; //学生Id
    private String studentIdName; //学生学号
    private String username;//学生名字
    private String phone;//手机号
    private String email;//电子邮件
    private int status;//状态
    private int departmentId;//部门Id
    private String password;//密码
    private int role;//角色
    private String RFIDid;//卡标签
    private String salt;//盐
    private boolean enabled;//账号是否启用
    @Transient
    private List<AdminRole> roles;//用户角色


    public Student(){

    }



    public Student(Long studentId, String studentIdName, String username, String phone, String email, int status,
                   int departmentId, String password, int role, String RFIDid){
        this.studentId =studentId;
        this.studentIdName=studentIdName;
        this.username= username;
        this.phone=phone;
        this.email=email;
        this.status=status;
        this.departmentId=departmentId;
        this.password=password;
        this.role=role;
        this.RFIDid=RFIDid;




    }

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

    public void setStudentIdName(String studentIdName) {
        this.studentIdName = studentIdName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AdminRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AdminRole> roles) {
        this.roles = roles;
    }
}
