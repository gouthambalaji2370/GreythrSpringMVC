package com.example.greythr_springmvc.dao;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressRequest {
    @NotNull
    private String type;

    @NotNull
    private String flatName;

    @NotNull
    private String street;

    @NotNull
    private String area;

    @NotNull
    private String state;

    @NotNull
    private String country;

    @Override
    public String toString() {
        return "AddressRequest{" +
                "type='" + type + '\'' +
                ", flatName='" + flatName + '\'' +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", pincode=" + pincode +
                ", mapCoordinates='" + mapCoordinates + '\'' +
                '}';
    }

    @NotNull
    private String district;

    @NotNull
    private Integer pincode;

    @NotNull
    private String mapCoordinates;

}
