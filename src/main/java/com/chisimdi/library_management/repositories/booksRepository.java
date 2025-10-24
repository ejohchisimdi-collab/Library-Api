package com.chisimdi.library_management.repositories;
import com.chisimdi.library_management.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface booksRepository extends JpaRepository<books,Integer> {

    @Query(value = "SELECT id, book_name,author,availability,category" +
            " FROM books",nativeQuery = true)
    public List<Object[]> showAllBooks();

    @Query(value = "select id,book_name,author,availability,category from" +
            " books where book_name = :bookName",nativeQuery = true)
    public Object[]  showBooksByName(@Param("bookName") String bookName);

    @Query(value = "select id,book_name,author,availability,category " +
            "from books where availability = :availability",nativeQuery = true)
    public List<Object[]>showBooksByAvailability(@Param("availability")String availability);

}
