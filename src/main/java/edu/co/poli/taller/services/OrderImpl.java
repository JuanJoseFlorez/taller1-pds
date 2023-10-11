package edu.co.poli.taller.services;

import edu.co.poli.taller.maper.OrderInDTOToOrder;
import edu.co.poli.taller.persistence.entity.Customer;
import edu.co.poli.taller.persistence.entity.Delivery;
import edu.co.poli.taller.persistence.entity.Order;
import edu.co.poli.taller.persistence.repository.OrderRepository;
import edu.co.poli.taller.services.dto.OrderInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderInDTOToOrder orderInDTOToOrder;
    private final CustomerService customerService;
    private final DeliveryService deliveryService;

    @Override
    public Order save(OrderInDTO order) {
        return orderRepository.save(orderInDTOToOrder.mapper(order));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order update(Long id, OrderInDTO order) {
        Optional<Order> order1 = orderRepository.findById(id);
        if(order1.isEmpty()) return null;
        Order order2 = order1.get();
        if(order.getOrder_date() != null) order2.setOrderDate(order.getOrder_date());
        if(order.getCustomerId() != null){
            Customer customer = customerService.findById(order.getCustomerId());
            order2.setCustomer(customer);
        }
        if(order.getDeliveryId() != null){
            Delivery delivery = deliveryService.findById(order.getDeliveryId());
            order2.setDelivery(delivery);
        }
        return orderRepository.save(order2);
    }


}
