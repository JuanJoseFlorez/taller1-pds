package edu.co.poli.taller.services;

import edu.co.poli.taller.maper.CustomerInDTOToCustomer;
import edu.co.poli.taller.persistence.entity.Customer;
import edu.co.poli.taller.persistence.repository.CustomerRepository;
import edu.co.poli.taller.services.dto.CustomerInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerInDTOToCustomer customerInDTOToCustomer;
    @Override
    public Customer save(CustomerInDTO customerInDTO) {
        return customerRepository.save(customerInDTOToCustomer.mapper(customerInDTO));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Long id, CustomerInDTO customer) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        if(customer1.isEmpty())return null;
        Customer customer2 = customer1.get();
        if(customer.getName() != null) customer2.setName(customer.getName());
        if(customer.getEmail() != null) customer2.setEmail(customer.getEmail());
        if(customer.getBirthdate() != null) customer2.setBirthdate(customer.getBirthdate());
        return customerRepository.save(customer2);
    }


}
