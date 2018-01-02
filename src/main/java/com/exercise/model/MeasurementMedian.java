package com.exercise.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class MeasurementMedian {

    private Long sensorId;
    private BigDecimal measurementMedianValue;
    private Timestamp measurementMedianTime;

    public MeasurementMedian() {
    }

    public MeasurementMedian(Long sensorId, BigDecimal measurementValue, Timestamp measurementTime) {
        this.sensorId = sensorId;
        this.measurementMedianValue = measurementValue;
        this.measurementMedianTime = measurementTime;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public BigDecimal getMeasurementMedianValue() {
        return measurementMedianValue;
    }

    public Timestamp getMeasurementMedianTime() {
        return measurementMedianTime;
    }
}
