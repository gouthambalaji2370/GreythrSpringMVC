package com.example.greythr_springmvc.service;

import com.example.greythr_springmvc.dao.AddressRequest;
import com.example.greythr_springmvc.dao.EmployeeRequest;
import com.example.greythr_springmvc.model.AddressDetails;
import com.example.greythr_springmvc.model.EmployeeDetails;
import com.example.greythr_springmvc.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDetailsService {

    @Autowired
    EmployeeDetailsRepository repo;
    @Autowired
    AddressDetailsService addressDetailsService;


    public Boolean save(EmployeeRequest employee){
        List<AddressDetails> addressSet=new ArrayList<>();
        List<AddressRequest> addressRequestSet= employee.getAddresses();
        EmployeeDetails updateEmployee= new EmployeeDetails();
        for (AddressRequest s : addressRequestSet) {
            AddressDetails address=new AddressDetails();
            address.setType(s.getType());
            address.setFlatName(s.getFlatName());
            address.setStreet(s.getStreet());
            address.setArea(s.getArea());
            address.setCountry(s.getCountry());
            address.setState(s.getState());
            address.setDistrict(s.getDistrict());
            address.setPincode(s.getPincode());
            address.setMapCoordinates(s.getMapCoordinates());
            addressDetailsService.save(address);
            addressSet.add(address);
        }
        updateEmployee.setAddresses(addressSet);
        updateEmployee.setName(employee.getName());
        updateEmployee.setPhoneNumber(employee.getPhoneNumber());
        updateEmployee.setGender(employee.getGender());
        updateEmployee.setEmailID(employee.getEmailID());
        updateEmployee.setEmployeeCode(employee.getEmployeeCode());
        updateEmployee.setAadharNumber(employee.getAadharNumber());
        updateEmployee.setBloodGroup(employee.getBloodGroup());
        updateEmployee.setMotherName(employee.getMotherName());
        updateEmployee.setFatherName(employee.getFatherName());
        updateEmployee.setDob(employee.getDob());
        updateEmployee.setSslcScore(employee.getSslcScore());
        updateEmployee.setHscScore(employee.getHscScore());
        updateEmployee.setUgScore(employee.getUgScore());
        updateEmployee.setEmergencyContactName(employee.getEmergencyContactName());
        updateEmployee.setEmergencyContactRelation(employee.getEmergencyContactRelation());
        updateEmployee.setEmergencyContactNumber(employee.getEmergencyContactNumber());
        repo.save(updateEmployee);
        return true;
    }
}
