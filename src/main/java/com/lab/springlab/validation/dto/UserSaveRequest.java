package com.lab.springlab.validation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserSaveRequest {

    @NotNull(message = "이름을 입력해 주세요.")
    private String name;

    @Email
    private String email;
}
