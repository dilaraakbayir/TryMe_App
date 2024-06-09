package com.dilara.TryMe_App.dto.response;

import com.dilara.TryMe_App.utility.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDto {
    private String name;
    private String surname;
    private String email;
    private State state;
}
