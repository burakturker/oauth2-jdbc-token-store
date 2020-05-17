package com.example.authorization.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
class UserController {

    private final UserService userService;
    private final ConsumerTokenServices consumerTokenServices;

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader(value = "Authorization") String authHeader) {

        if (authHeader == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        final String tokenValue = authHeader.replace("Bearer", "").trim();
        consumerTokenServices.revokeToken(tokenValue);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
