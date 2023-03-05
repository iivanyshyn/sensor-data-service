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
                .temperature(iotSensorProcessedDto.getTemperature())
                .humidity(iotSensorProcessedDto.getHumidity())
                .isOn(iotSensorProcessedDto.isOn())
                .unitId(iotSensorProcessedDto.getUnitId())
                .timestamp(Date.from(iotSensorProcessedDto.getTimestamp().toInstant()))
                .build();
    }
}
