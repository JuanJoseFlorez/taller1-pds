package edu.co.poli.taller.controller;

import edu.co.poli.taller.exceptions.DeliveryException;
import edu.co.poli.taller.persistence.entity.Delivery;
import edu.co.poli.taller.services.DeliveryService;
import edu.co.poli.taller.services.dto.DeliveryInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> findAll(){return deliveryService.findAll();}

    @GetMapping("/{id}")
    public Delivery findById(@PathVariable("id") Long id){return deliveryService.findById(id);}

    @PostMapping
    public Delivery save(@RequestBody DeliveryInDTO delivery){
        if(delivery.getDuration() < 1 || delivery.getDuration() > 60) throw new DeliveryException("La duración debe ser un rango entre 1-60min", HttpStatus.NOT_ACCEPTABLE);
        return deliveryService.save(delivery);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        Delivery delivery = deliveryService.findById(id);
        deliveryService.delete(delivery);
    }

    @PutMapping("/{id}")
    public Delivery update(@PathVariable("id") Long id, @RequestBody Delivery delivery){
        if(delivery.getDuration() != null){
            if(delivery.getDuration() < 1 || delivery.getDuration() > 60) throw new DeliveryException("La duración debe ser un rango entre 1-60min", HttpStatus.NOT_ACCEPTABLE);
        }
        return deliveryService.update(id, delivery);
    }
}
