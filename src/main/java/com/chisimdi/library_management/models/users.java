package com.chisimdi.library_management.models;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String name;
    private String role;


    public users(){}

    public users(String name,String role){
        this.name=name;
        this.role=role;
    }

    public int getId(){
        return this.id;
    }
    public void setID(int a){
        this.id=a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
