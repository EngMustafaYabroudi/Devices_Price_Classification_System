package com.backend.Devices_Price_Classification_System.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    @Autowired
    private  DeviceService deviceService;


    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping
    public Device createDevice(@RequestBody Device device) {
        return deviceService.addNewDevice(device);
    }

    @GetMapping("/{id}")
    public Optional<Device> getDeviceById(@PathVariable Integer id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping("predict/{deviceId}")
       public Device predictPriceForDevice(@PathVariable Integer deviceId) throws Exception {

        Map<String, Object> features = deviceService.getFeatures(deviceId);

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://127.0.0.1:5000/predict";

        Map<String, Object> response = restTemplate.postForObject(url, features, Map.class);

        Device device = deviceService.savePredictPrice(deviceId,response);

        return device;
    }
    @PostMapping("/predict")
    public Double inputFromUser(@RequestBody Map<String, Object> features) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:5000/predict";
        // Send POST request and get the response
        Map<String, Object> response = restTemplate.postForObject(url, features, Map.class);
        // Assuming the Flask API returns a JSON with a key "price"
        if (response != null && response.containsKey("price")) {
            Double price = (Double) response.get("price");
            return price;
        } else {
            // Handle the case where the "price" key is not found
            throw new RuntimeException("Missing 'price' key in API response");
        }
    }

}
