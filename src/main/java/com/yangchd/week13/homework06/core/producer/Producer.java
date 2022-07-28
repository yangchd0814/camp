package com.yangchd.week13.homework06.core.producer;

public interface Producer {

    /**
     * Send message to broker
     * @param topic topic
     * @param message message
     * @return send success
     */
    boolean send(String topic, String message);
}
