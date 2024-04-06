package com.murask.customer.services;

import com.murask.customer.CustomerRepository;
import com.murask.customer.dto.CustomerRegistrationRequest;
import com.murask.customer.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void regiterCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail()).build();
        // todo проверка почта не используется , почта валидна
        customerRepository.save(customer);
    }
}
