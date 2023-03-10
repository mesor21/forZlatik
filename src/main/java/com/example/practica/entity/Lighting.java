package com.example.practica.entity;


public class Lighting {
    private Long id;

    private int collor_red;//
    private int collor_blue;//цветовой тон излучения
    private int collor_green;//

    private double power_Wat;
    private int lux;
    private int uptime_days;
    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public Lighting() {
        this.collor_red=0;
        this.collor_blue=0;
        this.collor_green=0;
        this.power_Wat=0;
        this.lux=0;
        this.uptime_days=0;
        this.status=false;
    }

    public Lighting(int collor_red, int collor_blue, int collor_green, double power_Wat, int lux, int uptime_days, boolean status) {
        this.collor_red = collor_red;
        this.collor_blue = collor_blue;
        this.collor_green = collor_green;
        this.power_Wat = power_Wat;
        this.lux = lux;
        this.uptime_days = uptime_days;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCollor_red(int collor_red) {
        this.collor_red = collor_red;
    }

    public void setCollor_blue(int collor_blue) {
        this.collor_blue = collor_blue;
    }

    public void setCollor_green(int collor_green) {
        this.collor_green = collor_green;
    }

    public void setPower_Wat(double power_Wat) {
        this.power_Wat = power_Wat;
    }

    public void setLux(int lux) {
        this.lux = lux;
    }

    public void setUptime_days(int uptime_days) {
        this.uptime_days = uptime_days;
    }

    public Long getId() {
        return id;
    }

    public int getCollor_red() {
        return collor_red;
    }

    public int getCollor_blue() {
        return collor_blue;
    }

    public int getCollor_green() {
        return collor_green;
    }

    public double getPower_Wat() {
        return power_Wat;
    }

    public int getLux() {
        return lux;
    }

    public int getUptime_days() {
        return uptime_days;
    }


}
