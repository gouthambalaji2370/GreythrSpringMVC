package com.example.greythr_springmvc.controller;

import com.example.greythr_springmvc.dao.BasicResponse;
import com.example.greythr_springmvc.dao.EmployeeRequest;
import com.example.greythr_springmvc.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class EmployeeDetailsController {

    @Autowired
    EmployeeDetailsService employeeDetailsService;



    @CrossOrigin
    @PostMapping(value = "/approved",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addEmployee(@RequestBody @Valid EmployeeRequest employee)  {
        boolean result;
        result=employeeDetailsService.save(employee);
        BasicResponse response= new BasicResponse();
        if(result){
            response.setSuccess(true);
            response.setMessage("Employee details updated Successfully");
        }
            return new ResponseEntity<>(response,HttpStatus.OK);

    }


}
