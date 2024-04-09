package com.backend.Devices_Price_Classification_System.device;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import java.lang.reflect.Field;
import java.util.*;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
    public Device addNewDevice(Device device) {
        return deviceRepository.save(device);
    }
    public Optional<Device> getDeviceById(Integer id){return  deviceRepository.findById(id);}
    @Transactional
    public Map<String, Object> getFeatures(Integer deviceId) throws Exception {

        Device device = getDeviceById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id: " + deviceId));

        Map<String, Object> features = new HashMap<>();

        // Create a list to hold device features
        List<Object> featureList = new ArrayList<>();

        // Add all device features to the list
        featureList.add(device.getBatteryPower());
        featureList.add(device.getClockSpeed());
        featureList.add(device.getInternalMemory());
        featureList.add(device.getMobileWeight());
        featureList.add(device.getScreenHeight());
        featureList.add(device.getScreenWidth());
        featureList.add(device.getRam());
        featureList.add(device.getBluetooth());
        featureList.add(device.getDualSim());
        featureList.add(device.getFrontCamera());
        featureList.add(device.getFourG());
        featureList.add(device.getRearCamera());
        featureList.add(device.getThreeG());
        featureList.add(device.getTouchScreen());
        featureList.add(device.getWifi());
        featureList.add(device.getPriceRange());
        featureList.add(device.getNumberOfCores());
        featureList.add(device.getTalkTime());
        featureList.add(device.getBlue());
        featureList.add(device.getM_dep());

        // Add the feature list to the features map under the key "features"
        features.put("features", featureList);

        return  features;

    }
    public Device savePredictPrice(Integer deviceId, Map<String, Object> response) {
        Device device = getDeviceById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id: " + deviceId));
        if (response != null && response.containsKey("price")) {
            Double price = (Double) response.get("price");
            device.setPredictPrice(price.floatValue());
            return deviceRepository.save(device);
        } else {
            // Handle the case where the "price" key is not found
            throw new RuntimeException("Missing 'price' key in API response");
        }
    }
}
