package com.gvc.echodev_newsletter.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class NewsletterRequestDTO {
    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
