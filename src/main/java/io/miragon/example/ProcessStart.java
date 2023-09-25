package io.miragon.example;

import io.miragon.miranum.connect.process.api.StartProcessCommand;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
public class ProcessStart {

    private final StartProcessPort startProcessPort;

    public void startProcess(final String processKey) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("id", "myID1");
        variables.put("name", "myName");
        List<Object> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("A");
        variables.put("collection", collection);
        Random random = new Random();
        var correlationKey = "myCorrelationKey" + random.nextInt(1000);
        variables.put("key", correlationKey);

        log.info(variables.toString());

        log.info("Starting process: " + processKey);
        var command = new StartProcessCommand(processKey, variables);
        startProcessPort.startProcess(command);
        log.info("Started process: " + processKey + ".");
    }
}