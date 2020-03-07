package com.shencangblue.design.icrs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "department")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;//部门ID
    private String departmentName;//部门名称

    public Department(){

    }
    public Department(long departmentId,String departmentName){
        this.departmentId=departmentId;
        this.departmentName=departmentName;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
