package com.example.greythr_springmvc.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class EmployeeRequest {

    @NotNull
    @NotBlank(message = "last Name is mandatory")
    private String name;

    @NotNull
    private String employeeCode;


    @NotNull
    private String phoneNumber;

    @NotNull
    @Email(message = "invalid Email")
    @NotBlank(message = "email is mandatory")
    private String emailID;

    @NotNull
    @NotBlank(message = "blood group is mandatory")
    private String bloodGroup;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Pattern(regexp="^[2-9][0-9]{11}$", message="Invalid aadhar number!")
    private String aadharNumber;

    @Override
    public String toString() {
        return "EmployeeRequest{" +

                ", Name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailID='" + emailID + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", sslcScore=" + sslcScore +
                ", hscScore=" + hscScore +
                ", ugScore=" + ugScore +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", emergencyContactName='" + emergencyContactName + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", emergencyContactRelation='" + emergencyContactRelation + '\'' +
                ", addresses=" + addresses +
                '}';
    }

    @NotNull
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
    private Date dob;


    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "gender is mandatory")
    private String gender;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private Double sslcScore;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private Double hscScore;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private Double ugScore;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "Father Name is mandatory")
    private String fatherName;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "Mother Name is mandatory")
    private String motherName;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "emergency contact name is mandatory")
    private String emergencyContactName;

    @NotNull
    private String emergencyContactNumber;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "emergency contact relation is mandatory")
    private String emergencyContactRelation;


    private List<AddressRequest> addresses;
}

