package com.magalu.automatic.notification.api.repository;

import com.magalu.automatic.notification.api.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
