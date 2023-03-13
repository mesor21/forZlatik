package com.example.practica.repository;

import com.example.practica.entity.Lighting;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class JSONRepo {
    private final static String fileName ="/home/lol/university/23.02-23.07/Pract/practica/src/main/resources/file.json";
    public static Lighting getByID(Long myClassId) {
        List<Lighting> myClassList= new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            Gson gson = new Gson();
            myClassList = gson.fromJson(bufferedReader, new TypeToken<List<Lighting>>() {}.getType());
            bufferedReader.close();
            System.out.println("Lighting objects have been read from " + fileName + " file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int classId=-1;
        for (int i = 0; i < myClassList.size(); i++) {
            if (myClassList.get(i).getId().equals(myClassId)) {
                classId=i;
                break;
            }
        }
        return myClassList.get(classId);
    }
    public static void delete(Long myClassId) {
        List<Lighting> myClassList= new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            Gson gson = new Gson();
            myClassList = gson.fromJson(bufferedReader, new TypeToken<List<Lighting>>() {}.getType());
            bufferedReader.close();
            System.out.println("Lighting objects have been read from " + fileName + " file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Comparator<Lighting> idComparator = new Comparator<Lighting>() {
            @Override
            public int compare(Lighting o1, Lighting o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        myClassList.sort(idComparator);
        myClassList.remove(Integer.parseInt(myClassId.toString())-1);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            Gson gson = new Gson();
            gson.toJson(myClassList, fileWriter);
            fileWriter.close();
            System.out.println("Lighting object with id=" + myClassId + " has been removed from " + fileName + " file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void save(Lighting x, int plus){
        List<Lighting> myClassList= new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            Gson gson = new Gson();
            myClassList = gson.fromJson(bufferedReader, new TypeToken<List<Lighting>>() {}.getType());
            bufferedReader.close();
            System.out.println("Lighting objects have been read from " + fileName + " file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Comparator<Lighting> idComparator = new Comparator<Lighting>() {
            @Override
            public int compare(Lighting o1, Lighting o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        myClassList.sort(idComparator);
        if(plus==1){
            x.setId(Long.valueOf(myClassList.size() + plus));
        }
        myClassList.add(x);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            Gson gson = new Gson();
            gson.toJson(myClassList, fileWriter);
            fileWriter.close();
            System.out.println("Lighting objects have been saved to " + fileName + " file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Lighting> findAll(){
        List<Lighting> myClassList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            Gson gson = new Gson();
            myClassList = gson.fromJson(bufferedReader, new TypeToken<List<Lighting>>() {}.getType());
            bufferedReader.close();
            System.out.println("Lighting objects have been read from " + fileName + " file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Comparator<Lighting> idComparator = new Comparator<Lighting>() {
            @Override
            public int compare(Lighting o1, Lighting o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        myClassList.sort(idComparator);
        return myClassList;
    }
}