package com.mvcjava.loginapp.repository;

import com.mvcjava.loginapp.Bill.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Integer>
{

}
