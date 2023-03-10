package com.example.practica.controller;

import com.example.practica.entity.Lighting;
import com.example.practica.service.AllList;
import com.example.practica.service.EditObject;
import com.example.practica.service.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/info/")
public class Buisnes {
    @Autowired
    AllList allList = new AllList();
    EditObject editObject = new EditObject();
    @GetMapping("get")
    String get4Buisnes(Model model){
        model.addAttribute("list",allList.getList());
        return "list4Buisnes";
    }
    @GetMapping("turnOn/{id}")
    public String turnOn(@PathVariable("id")String id, Model model){
        Status x = new Status();
        x.setStatus(id,true);
        System.out.println("TurnOn: "+id);
        return "redirect:/info/get";
    }
    @GetMapping("turnOff/{id}")
    public String turnOff(@PathVariable("id")String id, Model model){
        Status x = new Status();
        x.setStatus(id, false);
        return "redirect:/info/get";
    }
}
