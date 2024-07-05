package com.magalu.automatic.notification.api.repository;

import com.magalu.automatic.notification.api.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
