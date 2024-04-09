package com.backend.Devices_Price_Classification_System.device;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class DeviceConfig {
    @Bean
    CommandLineRunner commandLineRunner(DeviceRepository deviceRepository){
        return args -> {
            Device device1 = new Device(
                    "Test Device 1", "XT-1234", "This is a test device",
                    100.0f, 2.4f, 128.0f, 150.0f, 6.5f, 3.0f, 8.0f,
                    1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 500.0f,
                    4f, 24f,1f,1f);
            Device device2 = new Device(
                    "Test Device 12", "XT-4321", "This is a test device",
                    200.0f, 2.4f, 128.0f, 150.0f, 6.5f, 3.0f, 8.0f,
                    0f, 1f, 0f, 1f, 1f, 1f, 1f, 1f, 500.0f,
                    4f, 20f,1f,1f);
            deviceRepository.saveAll(List.of(device1,device2));
        };
    }
}
