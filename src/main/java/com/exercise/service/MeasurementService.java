package com.exercise.service;

import com.exercise.generated.public_.tables.records.MeasurementRecord;
import com.exercise.model.Measurement;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

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

    public Map<Long, List<BigDecimal>> getMeasurementValues(Timestamp timestampHourAgo) {
        return create.selectFrom(MEASUREMENT)
                .where(MEASUREMENT.TIMESTAMP.gt(timestampHourAgo))
                .orderBy(MEASUREMENT.VALUE.asc())
                .fetch()
                .intoGroups(MEASUREMENT.SENSOR_ID, MEASUREMENT.VALUE)
                ;
    }

}
