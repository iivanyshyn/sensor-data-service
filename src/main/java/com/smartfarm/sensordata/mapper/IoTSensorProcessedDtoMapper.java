package com.smartfarm.sensordata.mapper;

import com.smartfarm.sensordata.model.*;

import java.time.ZoneOffset;

public class IoTSensorProcessedDtoMapper {

    public static IotSensorProcessedDto iotSensorToSensorProcessedDto(AirHumiditySensor airHumiditySensor){
        return IotSensorProcessedDto.builder()
                .sensorId(airHumiditySensor.getId())
                .type(SensorType.AIR_HUMIDITY.name())
                .value(Double.parseDouble(airHumiditySensor.getValue()))
                .status(SensorStatus.ON.name())
                //TODO Have to be replaced with real unit id after integration
                .farmUnitId("testUnitId")
                .unit(airHumiditySensor.getUnit())
                .timestamp(airHumiditySensor.getTimestamp().toInstant().atOffset(ZoneOffset.UTC))
                .build();
    }

    public static IotSensorProcessedDto iotSensorToSensorProcessedDto(LightSensor lightSensor){
        return IotSensorProcessedDto.builder()
                .sensorId(lightSensor.getId())
                .type(SensorType.LIGHT.name())
                .value(lightSensor.getLightIntensity())
                .status(SensorStatus.ON.name())
                //TODO Have to be replaced with real unit id after integration
                .farmUnitId("testUnitId")
                .unit(lightSensor.getUnit())
                .timestamp(lightSensor.getTimestamp().toInstant().atOffset(ZoneOffset.UTC))
                .build();
    }

    public static IotSensorProcessedDto iotSensorToSensorProcessedDto(PhSoilSensor phSoilSensor){
        return IotSensorProcessedDto.builder()
                .sensorId(phSoilSensor.getId())
                .type(SensorType.PH_SOIL.name())
                .value(phSoilSensor.getPhLevel())
                .status(SensorStatus.ON.name())
                //TODO Have to be replaced with real unit id after integration
                .farmUnitId("testUnitId")
                .unit(phSoilSensor.getUnit())
                .timestamp(phSoilSensor.getTimestamp().toInstant().atOffset(ZoneOffset.UTC))
                .build();
    }

    public static IotSensorProcessedDto iotSensorToSensorProcessedDto(SoilHumiditySensor soilHumiditySensor){
        return IotSensorProcessedDto.builder()
                .sensorId(soilHumiditySensor.getId())
                .type(SensorType.SOIL_HUMIDITY.name())
                .value(soilHumiditySensor.getHumidity())
                .status(SensorStatus.ON.name())
                //TODO Have to be replaced with real unit id after integration
                .farmUnitId("testUnitId")
                .unit(soilHumiditySensor.getUnit())
                .timestamp(soilHumiditySensor.getTimestamp().toInstant().atOffset(ZoneOffset.UTC))
                .build();
    }

    public static IotSensorProcessedDto iotSensorToSensorProcessedDto(TemperatureSensor temperatureSensor){
        return IotSensorProcessedDto.builder()
                .sensorId(temperatureSensor.getId())
                .type(SensorType.TEMPERATURE.name())
                .value(temperatureSensor.getTemperature())
                .status(SensorStatus.ON.name())
                //TODO Have to be replaced with real unit id after integration
                .farmUnitId("testUnitId")
                .unit(temperatureSensor.getUnit())
                .timestamp(temperatureSensor.getTimestamp().toInstant().atOffset(ZoneOffset.UTC))
                .build();
    }

}
