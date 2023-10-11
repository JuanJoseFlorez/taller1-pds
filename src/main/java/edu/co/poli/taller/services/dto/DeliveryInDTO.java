package edu.co.poli.taller.services.dto;

import edu.co.poli.taller.persistence.entity.Company;
import lombok.Data;

@Data
public class DeliveryInDTO {
    private Company company;
    private Integer duration;
}
