package com.example.authorization.user_detail;

import com.example.authorization.privilege.Privilege;
import com.example.authorization.privilege.PrivilegeService;
import com.example.authorization.role.Role;
import com.example.authorization.user.User;
import com.example.authorization.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ApplicationUserService implements UserDetailsService {

    private final UserService userService;
    private final PrivilegeService privilegeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final User user = userService.findByUserName(username);
        final Role role = user.getRole();

        final List<Privilege> privileges = privilegeService.getPrivilegesByRoleId(role.getId());

        return new ApplicationUser(user, privileges);
    }
}
