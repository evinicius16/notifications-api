package com.magalu.automatic.notification.api.enums;

import com.magalu.automatic.notification.api.entity.Channel;

public enum ChannelEnum {
    EMAIL(1L, "email"),
    SMS(2L, "sms"),
    PUSH(3L, "push"),
    WHATSAPP(4L, "whatsapp");

    private final Long id;
    private final String description;

    ChannelEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Channel toChannel() {
        return new Channel(id, description);
    }

    public static Channel getChannelByDescription(String description) {
        for (ChannelEnum item : ChannelEnum.values()) {
            if (item.description.equals(description)) {
                return item.toChannel();
            }
        }

        return getDefaultChannel();
    }

    public static Channel getDefaultChannel() { return ChannelEnum.WHATSAPP.toChannel(); }
}
