package com.smartfarm.sensordata.mapper;

import com.smartfarm.sensordata.domain.IotSensorEvent;
import com.smartfarm.sensordata.model.IotSensorProcessedDto;

import java.sql.Date;
import java.util.UUID;

public class IotSensorEventMapper {

    public static IotSensorEvent iotSensorProcessedDtoToSensorEvent(IotSensorProcessedDto iotSensorProcessedDto) {
        return IotSensorEvent.builder()
                .id(UUID.randomUUID().toString())
                .sensorId(iotSensorProcessedDto.getSensorId())
                .type(iotSensorProcessedDto.getType())
                .value(iotSensorProcessedDto.getValue())
                .status(iotSensorProcessedDto.getStatus())
                .unit(iotSensorProcessedDto.getUnit())
                .timestamp(Date.from(iotSensorProcessedDto.getTimestamp().toInstant()))
                .farmUnitId(iotSensorProcessedDto.getFarmUnitId())
                .build();
    }
}
