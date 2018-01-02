package com.exercise.rest;

import com.exercise.model.MeasurementMedian;
import com.exercise.service.MeasurementMedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Collection;

@RequestMapping("/medians")
@Controller
public class MeasurementMedianResource {

    @Autowired
    private MeasurementMedianService measurementMedianService;

    @RequestMapping(path = "{sensorId}/{fromTimestamp}/{toTimestamp}")
    ResponseEntity getMeasurementMedians(@PathVariable Long sensorId, @PathVariable Timestamp fromTimestamp, @PathVariable Timestamp toTimestamp) {
        Collection<MeasurementMedian> measurementMedians = measurementMedianService.getMeasurementMedians(sensorId, fromTimestamp, toTimestamp);
        return ResponseEntity.ok(measurementMedians);
    }

}
