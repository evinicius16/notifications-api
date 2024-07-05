package com.magalu.automatic.notification.api.repository;

import com.magalu.automatic.notification.api.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
