package com.ashu.Builder;

import java.util.Locale;

class Employee{
    private final String name;
    private final int id;
    private final String address;
    private final String email;
    private final String password;

    private Employee(Builder b){
        this.name = b.name;
        this.id = b.id;
        this.address = b.address;
        this.email = b.email;
        this.password = b.password;
    }

    public static Builder builder(String name, int id, String address){
        return new Builder(name,id,address);
    }

    //public static Builder

    public static class Builder{
        //----Required Fields------
        private final String name;
        private final int id;
        private final String address;

        //-----Optional Fields----
        private String email =  "N/A";
        private String password = "N/A";

        public Builder(String name, int id, String address){

            if(name == null || id < 0 || address.isEmpty()){
                throw new IllegalArgumentException("Name,Id and Address cannot be null zero and empty.");
            }
            this.name = name;
            this.id = id;
            this.address = address;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }


        public Employee build(){
            return new Employee(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

public class builderExample {
    public static void main(String[] args) {
        Employee emp = Employee.builder("Ashu",1,"Sector 38")
                .email("ashutosh87289@gmail.com")
                .password("vEn_m990@#$")
                .build();
        System.out.println("Name : " + emp.getName() + " Id :" + emp.getId() + " Address :" + emp.getAddress());
        System.out.println("Email :" + emp.getEmail());
    }
}
