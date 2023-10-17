package com.app.aspect;


import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public class PerformanceTrackerHandler implements ObservationHandler<Observation.Context> {

    @Override
    public void onStart(Observation.Context context) {
        log.info("execution started {}", context.getName());
        context.put("time", Instant.now());
    }

    @Override
    public void onError(Observation.Context context) {
        log.info("Error occurred {} ", context.getError().getMessage());
    }

    @Override
    public void onEvent(Observation.Event event, Observation.Context context) {
        ObservationHandler.super.onEvent(event, context);
    }

    @Override
    public void onScopeOpened(Observation.Context context) {
        ObservationHandler.super.onScopeOpened(context);
    }

    @Override
    public void onScopeClosed(Observation.Context context) {
        ObservationHandler.super.onScopeClosed(context);
    }

    @Override
    public void onScopeReset(Observation.Context context) {
        ObservationHandler.super.onScopeReset(context);
    }

    @Override
    public void onStop(Observation.Context context) {
        Instant finish = Instant.now();
        long time = Duration.between(context.get("time"), finish).toNanos();
        log.info("execution stopped " + context.getName() + " duration " + time + "ns");
    }


    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }
}