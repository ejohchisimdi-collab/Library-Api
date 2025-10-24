package com.chisimdi.library_management.controllers;
import com.chisimdi.library_management.services.*;
import com.chisimdi.library_management.repositories.*;
import com.chisimdi.library_management.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class adminController {
    private final AdminService adminService;

    public adminController(AdminService adminService){
        this.adminService=adminService;
    }

    @PostMapping("/users")
    public String addUser(@RequestBody users user){
       return adminService.addUser(user);
    }
    @GetMapping("/users")
    public List<users> getUser(){
        return adminService.viewAllUsers();
    }
    @GetMapping("/users/{userID}")
    public users getUser(@PathVariable("userID") int userId){
        return adminService.viewSpecificUser(userId);
    }
    @PostMapping ("/admin/books")
    public String addBooks(@RequestBody books books){
        return adminService.addBooks(books);
    }
    @GetMapping("/admin/books")
    public List<books>getBooks(){
        return adminService.viewAllBooks();
    }
    @GetMapping("/admin/books/{bookID}")
    public books getSpecificBook(@PathVariable("bookID") int bookId){
        return adminService.viewSpecificBooks(bookId);
    }
    @GetMapping("/borrow-history")
    public List<borrowing>getBorrowHistory(){
        return adminService.viewBorrowHistory();
    }
    @GetMapping("/borrow-history/{borrowID}")
    public borrowing getSpecificBorrowHistory(@PathVariable("borrowID") int a){
        return adminService.viewSpecificBorrowingHistory(a);
    }

}
