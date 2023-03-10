package com.example.practica.service;

import com.example.practica.entity.Lighting;
import com.example.practica.repository.JSONRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditObject {
    @Autowired
    JSONRepo jsonRepo = new JSONRepo();
    public Lighting getObjectByID(String id){
        return jsonRepo.findByID(Long.parseLong(id));
    }
    public boolean saveEdit(String id, String red, String green, String blue,String power, String lux, String uptime){
        Lighting lighting = jsonRepo.findByID(Long.parseLong(id));
        jsonRepo.delete(Long.parseLong(id));
        if(red.equals("")){
            lighting.setCollor_red(lighting.getCollor_red());
        }
        else{
            if(Integer.parseInt(red)>255 | Integer.parseInt(red)<0){
                return true;
            }
            lighting.setCollor_red(Integer.parseInt(red));
        }

        if(green.equals("")){
            lighting.setCollor_green(lighting.getCollor_green());
        }
        else{
            if(Integer.parseInt(green)>255 | Integer.parseInt(green)<0){
                return true;
            }
            lighting.setCollor_green(Integer.parseInt(green));
        }

        if(blue.equals("")){
            lighting.setCollor_blue(lighting.getCollor_blue());
        }
        else{
            if(Integer.parseInt(blue)>255 | Integer.parseInt(blue)<0){
                return true;
            }
            lighting.setCollor_blue(Integer.parseInt(blue));
        }

        if(power.equals("")){
            lighting.setPower_Wat(lighting.getPower_Wat());
        }
        else{
            if(Integer.parseInt(power)<0){
                return true;
            }
            lighting.setPower_Wat(Integer.parseInt(power));
        }

        if(lux.equals("")){
            lighting.setLux(lighting.getLux());
        }
        else{
            if(Integer.parseInt(lux)<0){
                return true;
            }
            lighting.setLux(Integer.parseInt(lux));
        }

        if(uptime.equals("")){
            lighting.setUptime_days(lighting.getUptime_days());
        }
        else{
            if(Integer.parseInt(uptime)<0){
                return true;
            }
            lighting.setUptime_days(Integer.parseInt(uptime));
        }
        jsonRepo.save(lighting,0);
        return false;
    }
}
