package com.backend.Devices_Price_Classification_System.device;

import jakarta.persistence.*;


@Entity
@Table(name="device")
public class Device {
    @Id
    @SequenceGenerator(
     name = "device_sequence",
     sequenceName = "device_sequence",
     allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_Sequence"
    )
    private Integer id;
    private String name;
    private String model;
    private String description;

    private Float batteryPower ;
    private Float blue;
    private Float clockSpeed ;
    private Float dualSim;
    private Float internalMemory ;
    private Float mobileWeight;
    private Float screenHeight;
    private Float screenWidth;
    private Float ram ;

    private Float bluetooth;

    private Float frontCamera;
    private Float fourG;
    private Float rearCamera;
    private Float threeG;
    private Float touchScreen;
    private Float wifi ;
    private Float priceRange;
    private Float numberOfCores;
    private Float talkTime;
    private Float m_dep;

    @Column(nullable = true)
    private Float predictPrice;


    public Device(Integer id, String name, String model, String description, Float batteryPower, Float blue, Float clockSpeed, Float dualSim, Float internalMemory, Float mobileWeight, Float screenHeight, Float screenWidth, Float ram, Float bluetooth, Float frontCamera, Float fourG, Float rearCamera, Float threeG, Float touchScreen, Float wifi, Float priceRange, Float numberOfCores, Float talkTime, Float m_dep, Float predictPrice) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.description = description;
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.internalMemory = internalMemory;
        this.mobileWeight = mobileWeight;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.ram = ram;
        this.bluetooth = bluetooth;
        this.frontCamera = frontCamera;
        this.fourG = fourG;
        this.rearCamera = rearCamera;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
        this.priceRange = priceRange;
        this.numberOfCores = numberOfCores;
        this.talkTime = talkTime;
        this.m_dep = m_dep;
        this.predictPrice = predictPrice;
    }

      public Device() {

    }
    public Device(String name, String model, String description, Float batteryPower, Float clockSpeed, Float internalMemory, Float mobileWeight, Float screenHeight, Float screenWidth, Float ram, Float bluetooth, Float dualSim, Float frontCamera, Float fourG, Float rearCamera, Float threeG, Float touchScreen, Float wifi, Float priceRange, Float numberOfCores, Float talkTime) {
        this.name = name;
        this.model = model;
        this.description = description;
        this.batteryPower = batteryPower;
        this.clockSpeed = clockSpeed;
        this.internalMemory = internalMemory;
        this.mobileWeight = mobileWeight;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.ram = ram;
        this.bluetooth = bluetooth;
        this.dualSim = dualSim;
        this.frontCamera = frontCamera;
        this.fourG = fourG;
        this.rearCamera = rearCamera;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
        this.priceRange = priceRange;
        this.numberOfCores = numberOfCores;
        this.talkTime = talkTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getBlue() {
        return blue;
    }

    public void setBlue(Float blue) {
        this.blue = blue;
    }

    public Device(String name, String model, String description, Float batteryPower, Float blue, Float clockSpeed, Float dualSim, Float internalMemory, Float mobileWeight, Float screenHeight, Float screenWidth, Float ram, Float bluetooth, Float frontCamera, Float fourG, Float rearCamera, Float threeG, Float touchScreen, Float wifi, Float priceRange, Float numberOfCores, Float talkTime, Float m_dep) {
        this.name = name;
        this.model = model;
        this.description = description;
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.internalMemory = internalMemory;
        this.mobileWeight = mobileWeight;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.ram = ram;
        this.bluetooth = bluetooth;
        this.frontCamera = frontCamera;
        this.fourG = fourG;
        this.rearCamera = rearCamera;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
        this.priceRange = priceRange;
        this.numberOfCores = numberOfCores;
        this.talkTime = talkTime;
        this.m_dep = m_dep;
    }

    public Float getM_dep() {
        return m_dep;
    }

    public void setM_dep(Float m_dep) {
        this.m_dep = m_dep;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public Float getBatteryPower() {
        return batteryPower;
    }

    public Float getClockSpeed() {
        return clockSpeed;
    }

    public Float getInternalMemory() {
        return internalMemory;
    }

    public Float getMobileWeight() {
        return mobileWeight;
    }

    public Float getScreenHeight() {
        return screenHeight;
    }

    public Float getScreenWidth() {
        return screenWidth;
    }

    public Float getRam() {
        return ram;
    }

    public Float getBluetooth() {
        return bluetooth;
    }

    public Float getDualSim() {
        return dualSim;
    }

    public Float getFrontCamera() {
        return frontCamera;
    }

    public Float getFourG() {
        return fourG;
    }

    public Float getRearCamera() {
        return rearCamera;
    }

    public Float getThreeG() {
        return threeG;
    }

    public Float getTouchScreen() {
        return touchScreen;
    }

    public Float getWifi() {
        return wifi;
    }

    public Float getPriceRange() {
        return priceRange;
    }

    public Float getNumberOfCores() {
        return numberOfCores;
    }

    public Float getTalkTime() {
        return talkTime;
    }
    public Float getPredictPrice() {return predictPrice;}


    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBatteryPower(Float batteryPower) {
        this.batteryPower = batteryPower;
    }

    public void setClockSpeed(Float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public void setInternalMemory(Float internalMemory) {
        this.internalMemory = internalMemory;
    }

    public void setMobileWeight(Float mobileWeight) {
        this.mobileWeight = mobileWeight;
    }

    public void setScreenHeight(Float screenHeight) {
        this.screenHeight = screenHeight;
    }

    public void setScreenWidth(Float screenWidth) {
        this.screenWidth = screenWidth;
    }

    public void setRam(Float ram) {
        this.ram = ram;
    }

    public void setBluetooth(Float bluetooth) {
        this.bluetooth = bluetooth;
    }

    public void setDualSim(Float dualSim) {
        this.dualSim = dualSim;
    }

    public void setFrontCamera(Float frontCamera) {
        this.frontCamera = frontCamera;
    }

    public void setFourG(Float fourG) {
        this.fourG = fourG;
    }

    public void setRearCamera(Float rearCamera) {
        this.rearCamera = rearCamera;
    }

    public void setThreeG(Float threeG) {
        this.threeG = threeG;
    }

    public void setTouchScreen(Float touchScreen) {
        this.touchScreen = touchScreen;
    }

    public void setWifi(Float wifi) {
        this.wifi = wifi;
    }

    public void setPriceRange(Float priceRange) {
        this.priceRange = priceRange;
    }

    public void setNumberOfCores(Float numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public void setTalkTime(Float talkTime) {
        this.talkTime = talkTime;
    }
    public void setPredictPrice(Float predictPrice) {this.predictPrice = predictPrice;}


}
