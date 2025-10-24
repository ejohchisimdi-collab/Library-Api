package com.chisimdi.library_management.services;
import com.chisimdi.library_management.repositories.*;
import com.chisimdi.library_management.models.*;
import org.springframework.stereotype.Service;
import java.time.*;

import java.util.List;

@Service
public class userService {
    final private  booksRepository booksRepository;
    final private userRepository userRepository;
    final private borrowingRepository borrowingRepository;


    public userService(booksRepository booksRepository,
                       userRepository userRepository,
                       borrowingRepository borrowingRepository){
        this.booksRepository=booksRepository;
        this.userRepository=userRepository;
        this.borrowingRepository=borrowingRepository;
    }
    public List<Object[]> showAllBooks(){
        return booksRepository.showAllBooks();
    }
    public Object[] showBooksByTitle(String title){
        return booksRepository.showBooksByName(title);
    }
    public List<Object[]>showBooksByAvailability(String availability){
        return booksRepository.showBooksByAvailability(availability);
    }


    public String borrowBooks(int a,int userId){
        books books= booksRepository.findById(a).orElseThrow(
                ()->new RuntimeException("book not found"));
        users user= userRepository.findById(userId).orElseThrow(
                ()->new RuntimeException("user not found"));
       if(books.getAvailability().trim().equalsIgnoreCase("borrowed")){
           return "this book has already been borrowed";
       }
       else{
           borrowingRepository.save(new borrowing(user.getName(),books.getBookName()));
           books.setAvailability("borrowed");
           LocalDateTime bookingTime=LocalDateTime.now();
           books.setDateofReturn(bookingTime.plusDays(4));
           booksRepository.save(books);
           return "borrow successful";

       }


    }
    public String returnBooks(int a){
        books b=booksRepository.findById( a).orElseThrow(()->new RuntimeException("book not found"));
        if( b.getAvailability().trim().equalsIgnoreCase("available")){
            return "this book is already available";
        }
        else{
            b.setAvailability("available");
            booksRepository.save(b);
            if(b.getDateofReturn().isBefore(LocalDateTime.now())){
                return "late return late fee is $"+b.getLateFee();
            }
            else{
            return "book is now available";
        }
        }
    }

}
