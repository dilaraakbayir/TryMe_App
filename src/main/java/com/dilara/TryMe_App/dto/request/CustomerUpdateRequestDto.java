package com.dilara.TryMe_App.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateRequestDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
