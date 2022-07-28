package com.yangchd.week13.homework06.core.messagequeue;

import com.yangchd.week13.homework06.core.messagequeue.queue.CustomQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class Broker {

    private Map<String, CustomQueue> queueMap = new HashMap<>();

    public boolean send(String topic, String content) {
        CustomQueue queue = queueMap.getOrDefault(topic, new CustomQueue());
        queue.put(content);
        queueMap.put(topic, queue);
        return true;
    }

    public List<String> poll(String topic, String group, int rate) {
        CustomQueue queue = queueMap.get(topic);

        List<String> messages = new ArrayList<>();
        if (queue == null) {
            return messages;
        }

        log.info("queue message amount : " + queue.size());
        while (!queue.isEmpty() || rate > 0) {
            String message = queue.get(group);
            if (message == null) {
                break;
            }
            messages.add(message);
            rate -= 1;
        }

        return messages;
    }
}
