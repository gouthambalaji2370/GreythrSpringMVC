package com.example.greythr_springmvc.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class AddressDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;


    @Column
    @NotNull
    private String type;

    @Column
    @NotNull
    private String flatName;

    @Column
    @NotNull
    private String street;

    @Column
    @NotNull
    private String area;

    @Column
    @NotNull
    private String state;

    @Column
    @NotNull
    private String country;


    @Column
    @NotNull
    private String district;

    @Column
    @NotNull
    private Integer pincode;

    @Column
    @NotNull
    private String mapCoordinates;
}
