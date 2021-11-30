package com.tracom.officeplanner.Models;

import javax.persistence.*;
import java.security.PublicKey;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dp_id")
    private Long id;

    @Column(name="dname")
    private String name;

    @ManyToOne(fetch= FetchType.LAZY, optional =false)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    public Department(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organization=" + organization +
                '}';
    }
}
