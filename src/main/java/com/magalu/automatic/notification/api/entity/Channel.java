package com.magalu.automatic.notification.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_channel")
public class Channel {

    @Id
    private long channelId;

    private String description;

    public Channel() {
    }

    public Channel(long channelId, String description) {
        this.channelId = channelId;
        this.description = description;
    }


    public long getId() {
        return channelId;
    }

    public void setId(long id) {
        this.channelId = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
