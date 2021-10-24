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

        @Override
        public String toString() {
            return "Resource{" +
                    "id=" + id +
                    ", resource_name='" + resource_name + '\'' +
                    ", resource_description='" + resource_description + '\'' +
                    '}';
        }
    }
