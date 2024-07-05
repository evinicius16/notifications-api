package com.magalu.automatic.notification.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private long statusId;

    private String description;

    public Status() {
    }

    public Status(long statusId, String description) {
        this.statusId = statusId;
        this.description = description;
    }

    public long getId() {
        return statusId;
    }

    public void setId(long id) {
        this.statusId = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
