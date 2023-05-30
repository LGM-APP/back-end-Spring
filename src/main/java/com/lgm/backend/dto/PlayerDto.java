package com.lgm.backend.dto;

import com.lgm.backend.dto.TeamDto;
import com.lgm.backend.model.mainDb.Player;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
public class PlayerDto implements Serializable {
    Integer id;
    Integer age;
    String firstName;
    String imageUrl;
    String lastName;
    String name;
    String nationality;
    String role;
}