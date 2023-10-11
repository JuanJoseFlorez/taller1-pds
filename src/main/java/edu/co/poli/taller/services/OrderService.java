package edu.co.poli.taller.services;

import edu.co.poli.taller.persistence.entity.Order;
import edu.co.poli.taller.services.dto.OrderInDTO;

import java.util.List;

public interface OrderService {

    Order save(OrderInDTO order);

    List<Order> findAll();

    void delete(Order order);

    Order findById(Long id);

    Order update(Long id, OrderInDTO order);
}
