package avlyakulov.timur.SpringRestMongo.service;

import avlyakulov.timur.SpringRestMongo.exceptions.ModelNotFoundException;
import avlyakulov.timur.SpringRestMongo.model.Device;
import avlyakulov.timur.SpringRestMongo.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DeviceService {

    private DeviceRepository deviceRepository;


    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    public Device findById(String deviceId) {
        return getOneById(deviceId);
    }


    private Device getOneById(String deviceId) {
        return deviceRepository.findById(deviceId).orElseThrow(() -> new ModelNotFoundException(HttpStatus.NOT_FOUND, String.format("Device with such an id %s wasn't found", deviceId)));
    }

}