package edu.co.poli.taller.services;


import edu.co.poli.taller.persistence.entity.Delivery;
import edu.co.poli.taller.services.dto.DeliveryInDTO;

import java.util.List;

public interface DeliveryService {

    Delivery save(DeliveryInDTO delivery);

    List<Delivery> findAll();

    void delete(Delivery delivery);

    Delivery findById(Long id);

    Delivery update(Long id, Delivery delivery);

}
