package com.exercise.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Measurement {

    private Long sensorId;
    private BigDecimal measurementValue;
    private Timestamp measurementTime;

    public Measurement() {
    }

    public Measurement(Long sensorId, BigDecimal measurementValue, Timestamp measurementTime) {
        this.sensorId = sensorId;
        this.measurementValue = measurementValue;
        this.measurementTime = measurementTime;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public BigDecimal getMeasurementValue() {
        return measurementValue;
    }

    public Timestamp getMeasurementTime() {
        return measurementTime;
    }
}
