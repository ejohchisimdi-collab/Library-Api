package com.chisimdi.library_management.models;
import java.time.*;
import jakarta.persistence.*;

@Entity
public class books {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String bookName;
    private String author;
    private String availability="Available";
    private String category;
    private double lateFee;
   private LocalDateTime DateofReturn;

    public books(){}

    public books(String bookName,String author,String category,double lateFee){
        this.bookName=bookName;
        this.author=author;
        this.availability="Available";
        this.category=category;
        this.lateFee=lateFee;
    }
    public String getBookName(){
        return this.bookName;
    }
    public void setBookName(String a){
        this.bookName=a;
    }
    public String getAuthor(String a){
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String a) {
        this.availability=a;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    public LocalDateTime getDateofReturn(){
        return this.DateofReturn;
    }

    public void setReturnDateTime(int year, int month,int day,int hour,int minuite) {
        this.DateofReturn = LocalDateTime.of(year,month,day,hour,minuite);
    }
    public void setDateofReturn(LocalDateTime dateofReturn){
        this.DateofReturn = dateofReturn;
    }

    public double getLateFee() {
        return lateFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }
}
