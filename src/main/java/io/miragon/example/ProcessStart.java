package io.miragon.example;

import io.miragon.miranum.connect.process.api.StartProcessCommand;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
public class ProcessStart {

    private final StartProcessPort startProcessPort;

    public void startProcess(final String processKey) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("id", "myID1");
        variables.put("name", "myName");
        List<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("A");
        variables.put("collection", collection);

        log.info(variables.toString());

        log.info("Starting process: " + processKey);
        var command = new StartProcessCommand(processKey, variables);
        startProcessPort.startProcess(command);
        log.info("Started process: " + processKey + ".");
    }
}