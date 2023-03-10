package com.example.practica.service;

import com.example.practica.repository.JSONRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteObject {
    @Autowired
    JSONRepo jsonRepo = new JSONRepo();
    public void deleteObject(String id){
        jsonRepo.delete(Long.parseLong(id));
    }
}
