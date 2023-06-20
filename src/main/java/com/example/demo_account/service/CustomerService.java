package com.example.demo_account.service;

import com.example.demo_account.dto.CustomerDto;
import com.example.demo_account.dto.CustomerDtoConverter;
import com.example.demo_account.exception.CustomerNotFoundException;
import com.example.demo_account.model.Customer;
import com.example.demo_account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;
    public  CustomerService(CustomerRepository customerRepository,
                            CustomerDtoConverter converter){
        this.customerRepository = customerRepository;
        this.converter = converter;
    }
    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found By Id" + id));

    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }

    public List<CustomerDto> getAllCustomer() {

        return customerRepository.findAll()
                .stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
