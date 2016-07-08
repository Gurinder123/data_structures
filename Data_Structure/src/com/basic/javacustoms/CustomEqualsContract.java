package com.basic.javacustoms;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Gurinder on 6/26/2016.
 */
public class CustomEqualsContract extends Thread{
    public void run(){
        for(int i =0; i < 2; i++){
            System.out.println(i);
        }}


    public static void main(String[] args) {
        ArrayList<Bike> bikeArrayList = new ArrayList<>();
        Bike myBike = new Bike("silver", "classic 350", new Date());
        Bike anotherBike = new Bike("black", "classic 350", new Date());
        Bike anotherBike2 = new Bike("silver", "classic 35023", new Date());
        bikeArrayList.add(myBike);
        bikeArrayList.add(anotherBike);
        boolean contains = bikeArrayList.contains(anotherBike2);
        System.out.println(contains);
        check(new CustomEqualsContract());
    }
    public static void check(CustomEqualsContract a){
        a.start();
    }
}

class Bike {
    private String color;
    private String bikeName;
    private Date year;

    public Bike(String color, String bikeName, Date year) {
        this.color = color;
        this.bikeName = bikeName;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "color=" + color +
                ", bikeName='" + bikeName + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return this.color.equals(((Bike) obj).color);
    }
}
