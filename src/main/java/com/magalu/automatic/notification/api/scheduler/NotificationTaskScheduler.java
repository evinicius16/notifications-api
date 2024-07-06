package com.magalu.automatic.notification.api.scheduler;

import com.magalu.automatic.notification.api.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


@Component
public class NotificationTaskScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationTaskScheduler.class);

    private final NotificationService notificationService;

    public NotificationTaskScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTask() {
        var dateTime = LocalDateTime.now();
        LOGGER.info("Running at {}", dateTime );

        notificationService.checkAndSend(dateTime);
    }
}
