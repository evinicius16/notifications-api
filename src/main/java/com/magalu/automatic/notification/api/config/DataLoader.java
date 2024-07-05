package com.magalu.automatic.notification.api.config;

import com.magalu.automatic.notification.api.entity.Channel;
import com.magalu.automatic.notification.api.enums.ChannelEnum;
import com.magalu.automatic.notification.api.enums.StatusEnum;
import com.magalu.automatic.notification.api.repository.ChannelRepository;
import com.magalu.automatic.notification.api.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(ChannelEnum.values())
                .map(ChannelEnum::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(StatusEnum.values())
                .map(StatusEnum::toStatus)
                .forEach(statusRepository::save);
    }
}
