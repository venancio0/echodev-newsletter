package com.gvc.echodev_newsletter.application.service;

import com.gvc.echodev_newsletter.application.repository.UserRepository;
import com.gvc.echodev_newsletter.domain.entity.User;
import com.gvc.echodev_newsletter.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String authenticate(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}
