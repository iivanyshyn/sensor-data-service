package com.smartfarm.sensordata.consumer;

import com.smartfarm.sensordata.domain.IotSensorEvent;
import com.smartfarm.sensordata.mapper.IoTSensorProcessedDtoMapper;
import com.smartfarm.sensordata.mapper.IotSensorEventMapper;
import com.smartfarm.sensordata.model.*;
import com.smartfarm.sensordata.producer.IotProcessedDataProducer;
import com.smartfarm.sensordata.repository.IotSensorEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(topics = "iot-data-event", groupId = "group_id")
@RequiredArgsConstructor
public class IotDataEventConsumer {

    private final IotProcessedDataProducer iotProcessedDataProducer;
    private final IotSensorEventRepository iotSensorEventRepository;

    @KafkaHandler
    public void airHumidity(AirHumiditySensor message) {
        IotSensorProcessedDto iotSensorProcessedDto = IoTSensorProcessedDtoMapper.iotSensorToSensorProcessedDto(message);
        iotProcessedDataProducer.sendMessage(iotSensorProcessedDto);
        IotSensorEvent iotSensorEvent = IotSensorEventMapper.iotSensorProcessedDtoToSensorEvent(iotSensorProcessedDto);
        iotSensorEventRepository.save(iotSensorEvent).subscribe();
        log.info("AirHumidity sensor event was saved: " + iotSensorEvent);
    }

    @KafkaHandler
    public void light(LightSensor message) {
        IotSensorProcessedDto iotSensorProcessedDto = IoTSensorProcessedDtoMapper.iotSensorToSensorProcessedDto(message);
        iotProcessedDataProducer.sendMessage(iotSensorProcessedDto);
        IotSensorEvent iotSensorEvent = IotSensorEventMapper.iotSensorProcessedDtoToSensorEvent(iotSensorProcessedDto);
        iotSensorEventRepository.save(iotSensorEvent).subscribe();
        log.info("Light sensor event was saved: " + iotSensorEvent);
    }

    @KafkaHandler
    public void soilPh(PhSoilSensor message) {
        IotSensorProcessedDto iotSensorProcessedDto = IoTSensorProcessedDtoMapper.iotSensorToSensorProcessedDto(message);
        iotProcessedDataProducer.sendMessage(iotSensorProcessedDto);
        IotSensorEvent iotSensorEvent = IotSensorEventMapper.iotSensorProcessedDtoToSensorEvent(iotSensorProcessedDto);
        iotSensorEventRepository.save(iotSensorEvent).subscribe();
        log.info("SoilPh sensor event was saved: " + iotSensorEvent);
    }

    @KafkaHandler
    public void soilHumidity(SoilHumiditySensor message) {
        IotSensorProcessedDto iotSensorProcessedDto = IoTSensorProcessedDtoMapper.iotSensorToSensorProcessedDto(message);
        iotProcessedDataProducer.sendMessage(iotSensorProcessedDto);
        IotSensorEvent iotSensorEvent = IotSensorEventMapper.iotSensorProcessedDtoToSensorEvent(iotSensorProcessedDto);
        iotSensorEventRepository.save(iotSensorEvent).subscribe();
        log.info("SoilHumidity sensor event was saved: " + iotSensorEvent);
    }

    @KafkaHandler
    public void temperature(TemperatureSensor message) {
        IotSensorProcessedDto iotSensorProcessedDto = IoTSensorProcessedDtoMapper.iotSensorToSensorProcessedDto(message);
        iotProcessedDataProducer.sendMessage(iotSensorProcessedDto);
        IotSensorEvent iotSensorEvent = IotSensorEventMapper.iotSensorProcessedDtoToSensorEvent(iotSensorProcessedDto);
        iotSensorEventRepository.save(iotSensorEvent).subscribe();
        log.info("Temperature sensor event was saved: " + iotSensorEvent);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        log.info("Unkown type event received: " + object);
    }
}
