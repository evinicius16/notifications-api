package com.magalu.automatic.notification.api.dto;

import com.magalu.automatic.notification.api.entity.Notification;
import com.magalu.automatic.notification.api.enums.ChannelEnum;
import com.magalu.automatic.notification.api.enums.StatusEnum;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                     String destination,
                                     String message,
                                     String channel) {

    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                ChannelEnum.getChannelByDescription(channel),
                StatusEnum.PENDING.toStatus()
        );
    }
}
