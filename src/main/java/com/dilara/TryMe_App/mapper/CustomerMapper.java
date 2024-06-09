package com.dilara.TryMe_App.mapper;

import com.dilara.TryMe_App.dto.request.CustomerUpdateRequestDto;
import com.dilara.TryMe_App.dto.request.RegisterRequestDto;
import com.dilara.TryMe_App.dto.response.LoginResponseDto;
import com.dilara.TryMe_App.dto.response.RegisterResponseDto;
import com.dilara.TryMe_App.entity.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    LoginResponseDto fromCustomerToLoginResponseDto(final Customer customer);
    Customer fromRegisterRequestDtoToCustomer(final RegisterRequestDto dto);
    RegisterResponseDto fromCustomerToRegisterResponseDto(final Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(CustomerUpdateRequestDto dto, @MappingTarget Customer customer);
}
