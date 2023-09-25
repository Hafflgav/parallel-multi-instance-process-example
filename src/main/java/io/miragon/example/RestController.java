package io.miragon.example;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    ProcessStart processStarter;
    MessageCorrelation messageCorrelation;

    @CrossOrigin
    @GetMapping
    @RequestMapping("/api/start")
    public ResponseEntity<Void> start() {
        processStarter.startProcess("parallel_multi_instance_process");
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/api/message")
    public ResponseEntity<Void> triggerMessage(@RequestBody String correlationKey) {
        messageCorrelation.correlateMessage("I've been correlated!", correlationKey);
        return ResponseEntity.ok().build();
    }
}