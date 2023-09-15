package io.miragon.example;

import io.miragon.miranum.connect.process.impl.StartProcessPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfiguration {

    @Bean
    public Worker myWorker() {
        return new Worker();
    }

    @Bean
    public ProcessStart myProcessStart(final StartProcessPort startProcessPort) {
        return new ProcessStart(startProcessPort);
    }
}