package com.mind.over.machines.business.rule.processor.service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;
@Slf4j
@Service
public class TelemetryService {

    private final Timer requestTimer;
    private final Random random = new Random();

    public TelemetryService(MeterRegistry meterRegistry) {
        this.requestTimer = meterRegistry.timer("application.request.timer");
    }

    @Scheduled(fixedRate = 15000) // Every 15 seconds
    public void simulateTelemetryData() {
        long startTime = System.currentTimeMillis();

        try {
            int processingTime = random.nextInt(500);
            Thread.sleep(processingTime);
            log.info("Processed request in {} ms", processingTime);
        } catch (InterruptedException e) {
            log.error("Error during request processing: ", e);
        } finally {
            long endTime = System.currentTimeMillis();
            requestTimer.record(endTime - startTime, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
    }
}
