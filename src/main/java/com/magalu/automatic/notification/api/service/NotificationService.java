package com.magalu.automatic.notification.api.service;

import com.magalu.automatic.notification.api.dto.ScheduleNotificationDto;
import com.magalu.automatic.notification.api.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto notification) {
        notificationRepository.save(notification.toNotification());
    }
}
