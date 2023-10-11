package edu.co.poli.taller.maper;

import edu.co.poli.taller.persistence.entity.Customer;
import edu.co.poli.taller.services.dto.CustomerInDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerInDTOToCustomer implements IMaper<CustomerInDTO, Customer> {


    @Override
    public Customer mapper(CustomerInDTO in) {
        Customer customer = new Customer();
        customer.setName(in.getName());
        customer.setEmail(in.getEmail());
        customer.setBirthdate(in.getBirthdate());
        return customer;
    }
}
