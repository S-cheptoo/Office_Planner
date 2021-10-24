package com.tracom.officeplanner.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @Column(name = "org_id", unique=true, nullable = false)
    private Long Id;
    @Column(name = "org_name", unique = true)
    private String org_name;
    @Column(name = "org_description", unique = true)
    private String org_description;

    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "org_id", referencedColumnName = "org_id")
    List<Employee> employees = new ArrayList<>();

    public Organization(){

    }

    public Organization(String org_name, String org_description) {
        super();
        this.org_name = org_name;
        this.org_description = org_description;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getOrg_description() {
        return org_description;
    }

    public void setOrg_description(String org_description) {
        this.org_description = org_description;
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    public void setEmployee(List<Employee> employee) {
        this.employees = employee;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "Id=" + Id +
                ", org_name='" + org_name + '\'' +
                ", org_description='" + org_description + '\'' +
                ", employees=" + employees +
                '}';
    }
}
