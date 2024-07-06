package com.magalu.automatic.notification.api.service;

import com.magalu.automatic.notification.api.dto.ScheduleNotificationDto;
import com.magalu.automatic.notification.api.entity.Notification;
import com.magalu.automatic.notification.api.enums.StatusEnum;
import com.magalu.automatic.notification.api.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public void scheduleNotification(ScheduleNotificationDto notification) {
        notificationRepository.save(notification.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(StatusEnum.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(StatusEnum.PENDING.toStatus(), StatusEnum.ERROR.toStatus()), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            //TODO: Send notification

            notification.setStatus(StatusEnum.SUCCESS.toStatus());
            notificationRepository.save(notification);
        };
    }

}
