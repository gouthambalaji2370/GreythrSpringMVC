package com.example.greythr_springmvc.service;

import com.example.greythr_springmvc.model.AddressDetails;
import com.example.greythr_springmvc.model.EmployeeDetails;
import com.example.greythr_springmvc.repository.AddressDetailsRepository;
import com.example.greythr_springmvc.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressDetailsService {
    @Autowired
    AddressDetailsRepository repo;


    public List<AddressDetails> listAll() {
        return repo.findAll();
    }
    public Boolean save(AddressDetails product){
        repo.save(product);
        return true;
    }
}
