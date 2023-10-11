package edu.co.poli.taller.services.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerInDTO {
    private String name;
    private String email;
    private LocalDate birthdate;
}
