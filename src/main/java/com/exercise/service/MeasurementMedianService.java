package com.exercise.service;

import com.exercise.generated.public_.tables.records.MeasurementMedianRecord;
import com.exercise.model.MeasurementMedian;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.exercise.generated.public_.tables.MeasurementMedian.MEASUREMENT_MEDIAN;

@Service
public class MeasurementMedianService {

    @Autowired
    private DSLContext create;

    @Transactional
    public void addMeasurementMedian(MeasurementMedian measurementMedian) throws DataIntegrityViolationException {
        MeasurementMedianRecord measurementMedianRecord = create.newRecord(MEASUREMENT_MEDIAN);
        measurementMedianRecord.setSensorId(measurementMedian.getSensorId());
        measurementMedianRecord.setMedianValue(measurementMedian.getMeasurementMedianValue());
        measurementMedianRecord.setMedianTimestamp(measurementMedian.getMeasurementMedianTime());
        measurementMedianRecord.store();
    }

}
