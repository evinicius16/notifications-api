package com.magalu.automatic.notification.api.controller;

import com.magalu.automatic.notification.api.dto.ScheduleNotificationDto;
import com.magalu.automatic.notification.api.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto request)  {
        notificationService.scheduleNotification(request);

        return ResponseEntity.accepted().build();
    }
}
