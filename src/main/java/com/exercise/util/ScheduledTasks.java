package com.exercise.util;

import com.exercise.model.MeasurementMedian;
import com.exercise.service.MeasurementMedianService;
import com.exercise.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledTasks {

    private MeasurementService measurementService;
    private MeasurementMedianService measurementMedianService;

    public ScheduledTasks() {
    }

    @Autowired
    public ScheduledTasks(MeasurementService measurementService, MeasurementMedianService measurementMedianService) {
        this.measurementService = measurementService;
        this.measurementMedianService = measurementMedianService;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void storeCalculatedMedianMeasurements() {
        Timestamp medianTimestamp = Timestamp.valueOf(LocalDateTime.now());
        Timestamp timestampHourAgo = Timestamp.valueOf(LocalDateTime.now().minusHours(1));

        Map<Long, List<BigDecimal>> sensorMeasurements = measurementService.getMeasurementValues(timestampHourAgo);

        for (Map.Entry<Long, List<BigDecimal>> sensorMeasurement : sensorMeasurements.entrySet()) {
            BigDecimal medianValue = calculateMedianValue(sensorMeasurement.getValue());
            measurementMedianService.addMeasurementMedian(new MeasurementMedian(sensorMeasurement.getKey(), medianValue, medianTimestamp));
        }
    }

    public BigDecimal calculateMedianValue(List<BigDecimal> values) {
        int middle = values.size() / 2;

        if (values.size() % 2 == 1) {
            return values.get(middle);
        } else {
            return (values.get(middle - 1).add(values.get(middle))).divide(new BigDecimal(2));
        }
    }
}
