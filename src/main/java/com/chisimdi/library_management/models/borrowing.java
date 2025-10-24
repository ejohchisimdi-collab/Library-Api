package com.chisimdi.library_management.models;
import java.time.*;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowID;

    private String name;
    private LocalDateTime dateTime=LocalDateTime.now();

    private String bookName;


    public borrowing(){}

    public borrowing(String name,String bookname){
        this.name=name;
        this.bookName=bookname;
        this.dateTime=LocalDateTime.now();

    }
    public String getName(){
        return this.name;
    }
    public void setName(String a){
        this.name=a;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


}
