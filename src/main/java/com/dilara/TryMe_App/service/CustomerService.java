package com.dilara.TryMe_App.service;

import com.dilara.TryMe_App.dto.request.LoginRequestDto;
import com.dilara.TryMe_App.dto.request.RegisterRequestDto;
import com.dilara.TryMe_App.dto.response.LoginResponseDto;
import com.dilara.TryMe_App.dto.response.RegisterResponseDto;
import com.dilara.TryMe_App.entity.BaseEntity;
import com.dilara.TryMe_App.entity.Customer;
import com.dilara.TryMe_App.exception.ErrorType;
import com.dilara.TryMe_App.exception.TryMeAppException;
import com.dilara.TryMe_App.mapper.CustomerMapper;
import com.dilara.TryMe_App.repository.CustomerRepository;
import com.dilara.TryMe_App.utility.ICrudService;
import com.dilara.TryMe_App.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CustomerService implements ICrudService<Customer,Long> {
    private final CustomerRepository customerRepository;

    public RegisterResponseDto register (RegisterRequestDto registerRequestDto){
        Customer customer1 = customerRepository.findByEmail(registerRequestDto.getEmail());
        if(customer1 != null){
            throw new TryMeAppException(ErrorType.USER_ALREADY_EXISTS);
        }
        Customer customer = CustomerMapper.INSTANCE.fromRegisterRequestDtoToCustomer(registerRequestDto);
        if (!customer.getPassword().equals(customer.getRePassword()) || customer.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password does not match!");
        }
        customerRepository.save(customer);
        return CustomerMapper.INSTANCE.fromCustomerToRegisterResponseDto(customer);

    }

    public RegisterResponseDto registerMapper(RegisterRequestDto dto) {
        Customer customer = CustomerMapper.INSTANCE.fromRegisterRequestDtoToCustomer(dto);

        if (!customerRepository.findAllByEmailContainingIgnoreCase(dto.getEmail()).isEmpty()) {
            throw new TryMeAppException(ErrorType.USER_ALREADY_EXISTS);
        }
        if (!customer.getPassword().equals(customer.getRePassword()) || customer.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password does not match!");
        }

        customerRepository.save(customer);
        return CustomerMapper.INSTANCE.fromCustomerToRegisterResponseDto(customer);
    }

    public LoginResponseDto login (LoginRequestDto loginRequestDto){
        Optional<Customer> customer = customerRepository.findByEmailAndPassword(loginRequestDto.getEmail(),loginRequestDto.getPassword());
        if(customer.isEmpty()){
            throw new TryMeAppException(ErrorType.USER_NOT_FOUND);
        }
        return CustomerMapper.INSTANCE.fromCustomerToLoginResponseDto(customer.get());
    }
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> saveAll(Iterable<Customer> t) {
        return customerRepository.saveAll(t);
    }

    @Override
    public Customer deleteById(Long aLong) {
        Optional<Customer> optionalCustomer= customerRepository.findById(aLong);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get(); // get -> Optional<User> converts to User
            customer.setBaseEntity(BaseEntity.builder()
                    .state(State.INACTIVE)
                    .build()); // Set the user to inactive
            customerRepository.save(customer);
            return customer;
        } else {
            throw new TryMeAppException(ErrorType.USER_NOT_FOUND);
        }
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return customerRepository.findById(aLong);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


}
