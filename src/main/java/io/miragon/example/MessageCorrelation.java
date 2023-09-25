package io.miragon.example;


import io.miragon.miranum.connect.message.api.CorrelateMessageCommand;
import io.miragon.miranum.connect.message.api.MessageApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MessageCorrelation {
    private final MessageApi messageApi;

    public void correlateMessage(final String message, final String key) {
        log.info("Received message: " + message);
        var command = new CorrelateMessageCommand("importantMessage", key);
        messageApi.correlateMessage(command);
        log.info("Correlated message: " + message + " with key: " + key + ".");
    }
}
