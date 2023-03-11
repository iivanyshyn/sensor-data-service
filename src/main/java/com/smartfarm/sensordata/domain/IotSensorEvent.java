package com.smartfarm.sensordata.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "iotSensorEvent")
public class IotSensorEvent {

    @Id
    private String id;
    private String sensorId;
    private String type;
    private double value;
    private String status;
    private Date timestamp;
    private String unit;
    private String farmUnitId;
}
