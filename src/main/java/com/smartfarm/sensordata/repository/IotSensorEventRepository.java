package com.smartfarm.sensordata.repository;

import com.smartfarm.sensordata.domain.IotSensorEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotSensorEventRepository extends ReactiveMongoRepository<IotSensorEvent, String> {

}
