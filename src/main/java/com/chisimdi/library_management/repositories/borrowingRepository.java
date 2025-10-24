package com.chisimdi.library_management.repositories;
import com.chisimdi.library_management.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface borrowingRepository extends JpaRepository<borrowing,Integer> {
    public borrowing findByName(String name);
}
