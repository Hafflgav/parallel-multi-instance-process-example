package io.miragon.example;

import io.miragon.miranum.connect.worker.api.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Slf4j
public class ParallelWorker {

    @Worker(type = "myWorker")
    public DoSomethingResult doSomething(DoSomethingCommand doSomethingCommand) {
        log.info("Received command: " + doSomethingCommand);
        var result = doSomethingCommand.getItem() + " result";
        log.info("Returning result: " + result);
        return new DoSomethingResult(result);
    }
}
