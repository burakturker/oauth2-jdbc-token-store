package com.example.authorization.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUserName(String userName) {

        final Optional<User> optionalUser = userRepository.findUserByUserName(userName);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException(userName + " Not Found"));

        return optionalUser.get();
    }

    private User getCurrentUser() {

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final Object principal = auth.getPrincipal();

        if (principal instanceof UserDetails) {
            final String username = ((UserDetails) principal).getUsername();
            return findByUserName(username);
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User bulunamadı.");
    }
}
