package io.miragon.example;

import io.miragon.miranum.connect.message.api.MessageApi;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfiguration {

    @Bean
    public ParallelWorker myWorker() {
        return new ParallelWorker();
    }

    @Bean
    public ProcessStart processStarter(final StartProcessPort startProcessPort) {
        return new ProcessStart(startProcessPort);
    }

    @Bean
    public MessageCorrelation messageCorrelation(final MessageApi messageApi) {
        return new MessageCorrelation(messageApi);
    }
}