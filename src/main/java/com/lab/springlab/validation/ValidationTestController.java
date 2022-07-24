package com.lab.springlab.validation;

import com.lab.springlab.validation.dto.ValidationDto;
import com.lab.springlab.validation.dto.UserSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidationTestController {

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(final @Valid @RequestBody UserSaveRequest userSaveRequest) {
        return ResponseEntity.ok()
                .body("유저 검증 성공");
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(final @Valid @RequestBody ValidationDto validationDto) {
        return ResponseEntity.ok()
                .body("검증 통과");
    }
}
