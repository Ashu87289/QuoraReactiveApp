package com.ashu.JavaConcept;

public class ConstructorExample {

    ConstructorExample(){
        System.out.println("Constructor");
    }

    void ConstructorExample(){
        System.out.println("Method");
    }

    public static void main(String[] args) {
        ConstructorExample e = new ConstructorExample();
        e.ConstructorExample();
    }
}
