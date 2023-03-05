package com.smartfarm.sensordata.producer;

import com.smartfarm.sensordata.model.IotSensorProcessedDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class IotProcessedDataProducer {

    private final KafkaTemplate<String, IotSensorProcessedDto> kafkaTemplate;

    public void sendMessage(IotSensorProcessedDto msg) {
        kafkaTemplate.send("iot-processed-data", msg);
    }
}
