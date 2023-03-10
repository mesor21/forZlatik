package com.example.practica.controller;

import com.example.practica.entity.Lighting;
import com.example.practica.service.AllList;
import com.example.practica.service.DeleteObject;
import com.example.practica.service.EditObject;
import com.example.practica.service.NewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AllRequest {
    @Autowired
    AllList allList = new AllList();
    NewObject x=new NewObject();
    EditObject editObject = new EditObject();
    @GetMapping("")
    public String test(Model model){
        model.addAttribute("list",allList.getList());
        return "mainPage";
    }
    @GetMapping("{id}")
    public String getLighting(@PathVariable("id")String id, Model model){
        EditObject editObject = new EditObject();
        List<Lighting> arr = new ArrayList<>();
        arr.add(editObject.getObjectByID(id));
        model.addAttribute("list",arr);
        return "editLighting";
    }
    @PostMapping("")
    public String createNewLighting(){
        x.saveNewObject();
        System.out.println("Create new object");
        return "redirect:/";
    }
    @PostMapping("{id}")
    public String edit_object(@PathVariable("id")String id, @RequestParam(value = "collor_red",required = false)String collor_red, @RequestParam(value = "collor_blue",required = false)String collor_blue, @RequestParam(value = "collor_green",required = false)String collor_green, @RequestParam(value = "power_Wat",required = false)String power_Wat, @RequestParam(value = "lux",required = false)String lux , @RequestParam(value = "uptime_days",required = false)String uptime_days){
        if(editObject.saveEdit(id,collor_red,collor_green,collor_blue,power_Wat,lux,uptime_days)){
            return "redirect:/ERROR";
        }
        System.out.println("Save object");
        return "redirect:/";
    }
    @GetMapping("ERROR")
    public String error(){
        return "test";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")String id){
        DeleteObject deleteObject=new DeleteObject();
        deleteObject.deleteObject(id);
        return "redirect:/";
    }
}
