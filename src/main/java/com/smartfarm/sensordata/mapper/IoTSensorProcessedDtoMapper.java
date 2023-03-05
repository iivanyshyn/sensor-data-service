package com.smartfarm.sensordata.mapper;

import com.smartfarm.sensordata.model.IoTSensorDto;
import com.smartfarm.sensordata.model.IotSensorProcessedDto;

import java.time.ZoneOffset;

public class IoTSensorProcessedDtoMapper {

    public static IotSensorProcessedDto iotSensorToSensorProcessedDto(IoTSensorDto ioTSensorDto){
        return IotSensorProcessedDto.builder()
                .sensorId(ioTSensorDto.getSensorId())
                .type(ioTSensorDto.getType())
                .temperature(ioTSensorDto.getTemperature())
                .humidity(ioTSensorDto.getHumidity())
                .isOn(ioTSensorDto.isOn())
                //TODO Have to be replaced with real unit id after integration
                .unitId("testUnit")
                .timestamp(ioTSensorDto.getTimestamp().toInstant().atOffset(ZoneOffset.UTC))
                .build();
    }
}
