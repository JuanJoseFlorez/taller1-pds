package edu.co.poli.taller.controller;

import edu.co.poli.taller.persistence.entity.Order;
import edu.co.poli.taller.services.OrderService;
import edu.co.poli.taller.services.dto.OrderInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Order> findAll(){return orderService.findAll();}

    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") Long id){return orderService.findById(id);}

    @PostMapping
    public Order save(@RequestBody OrderInDTO order){return orderService.save(order);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        Order order = orderService.findById(id);
        orderService.delete(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable("id") Long id, @RequestBody OrderInDTO order){return orderService.update(id, order);}

}
