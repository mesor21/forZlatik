package com.example.practica.service;

import com.example.practica.entity.Lighting;
import com.example.practica.repository.JSONRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NewObject {
    @Autowired
    JSONRepo jsonRepo = new JSONRepo();
    public void saveNewObject(){
        Lighting newL =new Lighting();
        jsonRepo.save(newL,1);
        System.out.println("Create new empty object");
    }
}
