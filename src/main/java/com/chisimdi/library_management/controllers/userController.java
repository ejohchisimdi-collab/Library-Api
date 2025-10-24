package com.chisimdi.library_management.controllers;
import com.chisimdi.library_management.models.*;
import com.chisimdi.library_management.controllers.*;
import com.chisimdi.library_management.services.*;
import com.chisimdi.library_management.repositories.*;
import com.chisimdi.library_management.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {
    private final userService userService;

    public userController(userService userService){
        this.userService=userService;
    }

    @GetMapping("/user/books")
    public List<Object[]> showAllBooks(){
        return userService.showAllBooks();
    }
    @GetMapping("/user/books/{name}")
    public Object[] showBooksByName(@PathVariable("name")String name){
        return userService.showBooksByTitle(name);
    }
    @GetMapping("/users/books/{availability}")
    public List<Object[]> showBooksByAvailability(@PathVariable("availability")String availability){
        return userService.showBooksByAvailability(availability);
    }
    @PostMapping("/users/{userId}/book/{bookId}")
    public String operation(@PathVariable("userId")int userId,
                            @PathVariable("bookId")int bookId,
                            @RequestBody userDTO dto ) {

        if (dto.getOperation().trim().equalsIgnoreCase("borrow")) {
            return userService.borrowBooks(bookId, userId);
        }
        if (dto.getOperation().trim().equalsIgnoreCase("return")) {
            return userService.returnBooks(bookId);
        }
        else {
            return "null";
        }
    }

}
