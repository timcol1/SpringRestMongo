package avlyakulov.timur.SpringRestMongo.controller;

import avlyakulov.timur.SpringRestMongo.model.Device;
import avlyakulov.timur.SpringRestMongo.model.Student;
import avlyakulov.timur.SpringRestMongo.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/devices")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    @GetMapping
    public List<Device> getAllDevices() {
        int a = 12;
        return deviceService.findAll();
    }

    @GetMapping("/{id}")
    public Device findById(@PathVariable String id) {
        return deviceService.findById(id);
    }
}
