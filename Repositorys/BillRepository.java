package com.example.demo.Repositorys;

import com.example.demo.Entitys.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query( value = "select * from bills  where payment=false and user_id= :userId" ,nativeQuery = true)
    List<Bill> findAllFalseByUserId(@Param("userId") Long userId);


}
