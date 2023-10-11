package edu.co.poli.taller.services.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderInDTO {
    private LocalDate order_date;
    private Long deliveryId;
    private Long customerId;
}
