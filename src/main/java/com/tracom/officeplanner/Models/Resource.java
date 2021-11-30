package com.tracom.officeplanner.Models;

import javax.persistence.*;

@Entity
@Table(name="resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rsc_id")
    private Long id;
    private String resource_name;
    private String resource_description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Resource() {
    }

    public Resource(Long id) {
        this.id = id;
    }

    public Resource(Long id, String resource_name, String resource_description, Room room) {
        this.id = id;
        this.resource_name = resource_name;
        this.resource_description = resource_description;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public String getResource_description() {
        return resource_description;
    }

    public void setResource_description(String resource_description) {
        this.resource_description = resource_description;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", resource_name='" + resource_name + '\'' +
                ", resource_description='" + resource_description + '\'' +
                ", room=" + room +
                '}';
    }
}
