package edu.co.poli.taller.services;

import edu.co.poli.taller.persistence.entity.Customer;
import edu.co.poli.taller.services.dto.CustomerInDTO;

import java.util.List;

public interface CustomerService {

    Customer save (CustomerInDTO customer);

    List<Customer> findAll();

    void delete(Customer customer);

    Customer findById(Long id);

    Customer update(Long id,CustomerInDTO customer);
}
