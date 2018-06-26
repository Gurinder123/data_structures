package com.prac.collection;


import java.io.*;

class Master {

    private int a = 5;
    private int b = 5;

    public Master() {
        this.a = 111;
        this.b = 111;
    }

    public Master(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}


public class LinkedListCheck  extends Master implements Externalizable{

    public LinkedListCheck() {
        super(10 ,10);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        LinkedListCheck truck = new LinkedListCheck();
        truck.setA(1);
        truck.setB(1);
        FileOutputStream fileOutputStream = new FileOutputStream("/home/gurinder/Desktop/Serial.txt");

        FileInputStream fileInputStream;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            truck.writeExternal(objectOutputStream);
        }

        fileInputStream = new FileInputStream("/home/gurinder/Desktop/Serial.txt");

        try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            truck.readExternal(objectInputStream);
        }


    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        LinkedListCheck truck = new LinkedListCheck();
        truck.setA(1);
        truck.setB(1);

        out.writeObject(truck);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        LinkedListCheck linkedListCheck = (LinkedListCheck) in.readObject();

    }
}
