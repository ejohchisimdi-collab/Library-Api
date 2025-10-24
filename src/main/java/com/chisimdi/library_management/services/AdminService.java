package com.chisimdi.library_management.services;
import java.util.*;
import com.chisimdi.library_management.models.*;
import com.chisimdi.library_management.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public booksRepository booksRepository;
    public borrowingRepository borrowingRepository;
    public userRepository userRepository;

    public AdminService(booksRepository booksRepository,borrowingRepository borrowingRepository,
                        userRepository userRepository){
        this.booksRepository=booksRepository;
        this.borrowingRepository=borrowingRepository;
        this.userRepository=userRepository;
    }
    public String addUser(users user){
        userRepository.save(user);
        return "user saved";
    }
    public String addBooks(books books){
        booksRepository.save(books);
        return "book saved";
    }
    public List<users>viewAllUsers(){
        return userRepository.findAll();
    }
    public users viewSpecificUser(int a){
        return userRepository.findById(a).orElseThrow(()->new RuntimeException());
    }
    public List<books>viewAllBooks(){
        return booksRepository.findAll();
    }
    public books viewSpecificBooks(int a){
        return booksRepository.findById(a).orElseThrow(()->new RuntimeException());
    }
    public List<borrowing>viewBorrowHistory(){
        return borrowingRepository.findAll();
    }
    public borrowing viewSpecificBorrowingHistory(int a){
        return borrowingRepository.findById(a).orElseThrow(()->new RuntimeException());
    }

}
