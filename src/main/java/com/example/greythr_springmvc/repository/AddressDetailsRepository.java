package com.example.greythr_springmvc.repository;

import com.example.greythr_springmvc.model.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDetailsRepository extends JpaRepository<AddressDetails,Integer> {
}
