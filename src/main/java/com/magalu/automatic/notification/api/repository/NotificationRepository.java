package com.magalu.automatic.notification.api.repository;

import com.magalu.automatic.notification.api.entity.Notification;
import com.magalu.automatic.notification.api.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
