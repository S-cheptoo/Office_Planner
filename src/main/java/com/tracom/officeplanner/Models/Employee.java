package com.tracom.officeplanner.Models;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;
    @Column(name = "emp_id", unique = true)
    private Integer emp_id;
    @Column(name = "emp_firstname")
    private String emp_firstname;
    @Column(name = "emp_lastname")
    private String emp_lastname;
    @Column(name = "emp_email", unique = true, nullable = false)
    private String emp_email;
    @Column(name = "password", unique = true, nullable = false)
    private String password;
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phone_number;
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="org_id", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="d_id", nullable = false)
    private Department department;

    public Employee(){
    }

    public Employee(Integer emp_id, String emp_firstname, String emp_lastname, String emp_email, String password, Department department, String phone_number, String gender, Organization organization) {
        this.emp_id = emp_id;
        this.emp_firstname = emp_firstname;
        this.emp_lastname = emp_lastname;
        this.emp_email = emp_email;
        this.password = password;
        this.department = department;
        this.phone_number = phone_number;
        this.organization=organization;
        this.gender=gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_firstname() {
        return emp_firstname;
    }

    public void setEmp_firstname(String emp_firstname) {
        this.emp_firstname = emp_firstname;
    }

    public String getEmp_lastname() {
        return emp_lastname;
    }

    public void setEmp_lastname(String emp_lastname) {
        this.emp_lastname = emp_lastname;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", emp_id=" + emp_id +
                ", emp_firstname='" + emp_firstname + '\'' +
                ", emp_lastname='" + emp_lastname + '\'' +
                ", emp_email='" + emp_email + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", gender='" + gender + '\'' +
                ", organization=" + organization +
                ", department=" + department +
                '}';
    }
}
