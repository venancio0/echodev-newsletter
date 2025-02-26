package com.gvc.echodev_newsletter.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
