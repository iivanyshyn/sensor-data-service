package com.smartfarm.sensordata.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IotSensorProcessedDto {

    private String sensorId;
    private String type;
    private double temperature;
    private double humidity;
    private boolean isOn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSx")
    private OffsetDateTime timestamp;
    private String unitId;
}
