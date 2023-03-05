package com.smartfarm.sensordata.consumer;

import com.smartfarm.sensordata.domain.IotSensorEvent;
import com.smartfarm.sensordata.mapper.IoTSensorProcessedDtoMapper;
import com.smartfarm.sensordata.mapper.IotSensorEventMapper;
import com.smartfarm.sensordata.model.IoTSensorDto;
import com.smartfarm.sensordata.model.IotSensorProcessedDto;
import com.smartfarm.sensordata.producer.IotProcessedDataProducer;
import com.smartfarm.sensordata.repository.IotSensorEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class IotDataEventConsumer {

    private final IotProcessedDataProducer iotProcessedDataProducer;
    private final IotSensorEventRepository iotSensorEventRepository;

    @KafkaListener(topics = "iot-data-event", groupId = "group_id")
    public void consume(IoTSensorDto message) {
        IotSensorProcessedDto iotSensorProcessedDto = IoTSensorProcessedDtoMapper.iotSensorToSensorProcessedDto(message);
        iotProcessedDataProducer.sendMessage(iotSensorProcessedDto);
        IotSensorEvent iotSensorEvent = IotSensorEventMapper.iotSensorProcessedDtoToSensorEvent(iotSensorProcessedDto);
        iotSensorEventRepository.save(iotSensorEvent).subscribe();
        log.info("Sensor event was saved: " + iotSensorEvent);
    }
}
