package com.bank.app.repository.com.bank.app.repository;

import com.bank.app.model.customerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<customerModel, Long> {

}
