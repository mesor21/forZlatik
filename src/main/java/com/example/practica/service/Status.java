package com.example.practica.service;

import com.example.practica.entity.Lighting;
import com.example.practica.repository.JSONRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Status {
    @Autowired
    JSONRepo jsonRepo = new JSONRepo();
    public void setStatus(String id,boolean status){
        Lighting lighting = jsonRepo.findByID(Long.parseLong(id));
        jsonRepo.delete(lighting.getId());
        lighting.setStatus(status);
        jsonRepo.save(lighting,1);
    }
}
