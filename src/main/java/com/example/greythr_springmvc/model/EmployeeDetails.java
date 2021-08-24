package com.example.greythr_springmvc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee_demographics")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @NotNull
    private String employeeCode;

    @NotNull
    @NotBlank(message = "Name is mandatory")
    @Column
    private String name;


    @NotNull
    @Column
    private String phoneNumber;

    @NotNull
    @Email(message = "invalid Email")
    @NotBlank(message = "email is mandatory")
    @Column
    private String emailID;

    @NotNull
    @NotBlank(message = "blood group is mandatory")
    @Column
    private String bloodGroup;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Pattern(regexp="^[2-9][0-9]{11}$", message="Invalid aadhar number!")
    @Column
    private String aadharNumber;

    @NotNull
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
    @Column
    private Date dob;


    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "gender is mandatory")
    @Column
    private String gender;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Column
    private Double sslcScore;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Column
    private Double hscScore;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Column
    private Double ugScore;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "Father Name is mandatory")
    @Column
    private String fatherName;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "Mother Name is mandatory")
    @Column
    private String motherName;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "emergency contact name is mandatory")
    @Column
    private String emergencyContactName;

    @NotNull
    @Column
    private String emergencyContactNumber;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    @NotBlank(message = "emergency contact relation is mandatory")
    @Column
    private String emergencyContactRelation;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private List<AddressDetails> addresses;

}
