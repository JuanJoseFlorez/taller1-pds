package edu.co.poli.taller.maper;

import edu.co.poli.taller.persistence.entity.Customer;
import edu.co.poli.taller.persistence.entity.Delivery;
import edu.co.poli.taller.persistence.entity.Order;
import edu.co.poli.taller.services.CustomerService;
import edu.co.poli.taller.services.DeliveryService;
import edu.co.poli.taller.services.dto.OrderInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderInDTOToOrder implements IMaper<OrderInDTO, Order> {
    private final DeliveryService deliveryService;
    private final CustomerService customerService;
    @Override
    public Order mapper(OrderInDTO in) {
        Order order = new Order();
        order.setOrderDate(in.getOrder_date());
        Delivery delivery = deliveryService.findById(in.getDeliveryId());
        order.setDelivery(delivery);
        Customer customer = customerService.findById(in.getCustomerId());
        order.setCustomer(customer);
        return order;
    }
}
