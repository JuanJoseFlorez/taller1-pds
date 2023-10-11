package edu.co.poli.taller.controller;

import edu.co.poli.taller.exceptions.DeliveryException;
import edu.co.poli.taller.persistence.entity.Customer;
import edu.co.poli.taller.services.CustomerService;
import edu.co.poli.taller.services.dto.CustomerInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Long id){return customerService.findById(id);}

    @PostMapping
    public Customer save(@RequestBody CustomerInDTO customer){
        LocalDate currentDate = LocalDate.now();
        Period ageDifference = Period.between(customer.getBirthdate(), currentDate);
        int age = ageDifference.getYears();
        if(age < 18) throw new DeliveryException("Solo se pueden agregar clientes con edad mayor o igual a 18 años.", HttpStatus.NOT_ACCEPTABLE);
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        Customer customer = customerService.findById(id);
        customerService.delete(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable("id") Long id, @RequestBody CustomerInDTO customer){
        if(customer.getBirthdate() != null){
            LocalDate currentDate = LocalDate.now();
            Period ageDifference = Period.between(customer.getBirthdate(), currentDate);
            int age = ageDifference.getYears();
            if(age < 18) throw new DeliveryException("Solo se pueden agregar clientes con edad mayor o igual a 18 años.", HttpStatus.NOT_ACCEPTABLE);
        }
        return customerService.update(id, customer);
    }
}
