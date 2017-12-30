package com.exercise.service;

import com.exercise.generated.public_.tables.records.MeasurementRecord;
import com.exercise.model.Measurement;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.exercise.generated.public_.tables.Measurement.MEASUREMENT;

@Service
public class MeasurementService {

    @Autowired
    private DSLContext create;

    @Transactional
    public void addMeasurement(Measurement measurement) throws DataIntegrityViolationException {
        MeasurementRecord measurementRecord = create.newRecord(MEASUREMENT);
        measurementRecord.setSensorId(measurement.getSensorId());
        measurementRecord.setValue(measurement.getMeasurementValue());
        measurementRecord.setTimestamp(measurement.getMeasurementTime());
        measurementRecord.store();
    }

}
