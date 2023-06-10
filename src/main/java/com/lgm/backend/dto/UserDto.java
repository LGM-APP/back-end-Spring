package com.lgm.backend.dto;


import lombok.Data;

@Data
public class UserDto {

    Integer id ;
    String firstName ;
    String lastName ;
    String email;
    Integer point;
    String description;
    byte[] profilePhoto;


}
