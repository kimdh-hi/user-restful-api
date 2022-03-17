package com.devblog.mobileappws.security;

import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("존재하지 않는 이메일 입니다. email: " + username);
                }
        );

        return new CustomUserDetails(user);
    }
}
