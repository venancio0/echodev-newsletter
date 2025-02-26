package com.gvc.echodev_newsletter.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsletterRequestDTO {
    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
