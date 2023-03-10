package com.example.practica.service;

import com.example.practica.entity.Lighting;
import com.example.practica.repository.JSONRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    AllList {
    @Autowired
    JSONRepo jsonRepo=new JSONRepo();
    public List<Lighting> getList(){
        return jsonRepo.findAll();
    }

}
