package com.tracom.officeplanner.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "capacity")
    private Long capacity;

//    @OneToMany(mappedBy = "room", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set <Meeting> meetings;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "room_resources",
//            joinColumns = @JoinColumn(name = "room_id"),
//            inverseJoinColumns = @JoinColumn(name="rsc_id"))
//
//    private Set<Resource> resources=new HashSet<>();

//    public void addResource(Resource resource){
//        this.resources.add(resource);
//    }

    public Room(){}

    public Room(String name, Long capacity){
        this.name= name;
        this.capacity= capacity;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
//
//    public Set<Resource> getResources() {
//        return resources;
//    }
//
//    public void setResources(Set<Resource> resources) {
//        this.resources = resources;
//    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", organization=" + organization +
//                ", resources=" + resources +
                '}';
    }
}
