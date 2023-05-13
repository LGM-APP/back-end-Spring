package com.lgm.backend.dto;

import lombok.Data;

@Data
public class RegisterDto {
    //it's a Data Trasfer Object for registration
    String firstName ;
    String lastName ;
    String email;
    String password ;
}
