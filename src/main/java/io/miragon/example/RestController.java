package io.miragon.example;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@Api(tags = "start")
@RequestMapping("/api/start")
public class RestController {
    ProcessStart processStarter;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Void> starten() {
        processStarter.startProcess("parallel_multi_instance_process");
        return ResponseEntity.ok().build();
    }
}