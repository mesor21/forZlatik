package com.example.practica.controller;

import com.example.practica.service.LightingService;
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
    LightingService lightingService;
    @GetMapping("get")
    String get4Buisnes(Model model){
        model.addAttribute("list",lightingService.getList());
        return "list4Buisnes";
    }
    @GetMapping("turnOn/{id}")
    public String turnOn(@PathVariable("id")String id, Model model){
        lightingService.setStatus(id,true);
        System.out.println("TurnOn: "+id);
        return "redirect:/info/get";
    }
    @GetMapping("turnOff/{id}")
    public String turnOff(@PathVariable("id")String id, Model model){
        lightingService.setStatus(id, false);
        System.out.println("TurnOff: "+id);
        return "redirect:/info/get";
    }
}
