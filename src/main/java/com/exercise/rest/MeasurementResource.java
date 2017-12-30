package com.exercise.rest;

import com.exercise.model.Measurement;
import com.exercise.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/measurements")
@Controller
public class MeasurementResource {

    @Autowired
    private MeasurementService measurementService;

    @PostMapping
    ResponseEntity addMeasurement(@RequestBody Measurement measurement) {
        try {
            measurementService.addMeasurement(measurement);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().build().toUri();
            return ResponseEntity.created(location).build();
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

}
