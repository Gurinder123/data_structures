package com.prac;

// Before C and Pascal Procedural languages
// Chairs, Person, Counter, Bike, Scooter everything object which is noun.
// Object oriented programming

// Major pillars of OOP's

// Encapsulation
// Data hiding
// Abstraction
// Polymorphism (a) static (compile time) a.k.a overloading (b) dynamic (run time time) a.k.a overriding
// Inheritance

/* Bonus part */
// Association
// Composition
// Aggregation

// overloading => method name should be same but different arguements. atleast 2 methods
// overriding => method name and arguement should be same. atleast 2 classes.


class Animal{

    public String item = "Chicken";

    public void eat(){
        System.out.println("Anything");
    }

}

// single level
class Dog extends Animal{

}

class Boxer extends Dog{

    void food(){
        eat();
        System.out.println(item);
    }
}


class Main {

    public static void main(String[] args) {

    }
}