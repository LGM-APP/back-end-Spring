package com.lgm.backend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDto {

    Integer id ;
    String firstName ;
    String lastName ;
    String email;
    Integer point;


}
