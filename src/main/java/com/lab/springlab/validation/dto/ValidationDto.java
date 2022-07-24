package com.lab.springlab.validation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class ValidationDto {

    @NotNull
    private String notNull;

    @NotEmpty
    private String notEmpty;

    @NotBlank
    private String notBlank;
}
