package com.projeto.seletinha.endpoint.service;


import com.projeto.seletinha.config.JwtService;
import com.projeto.seletinha.models.AuthenticationResponse;
import com.projeto.seletinha.models.Role;
import com.projeto.seletinha.models.TeachersModel;
import com.projeto.seletinha.repository.TeacherRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private final TeacherRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(final HttpServletRequest request) {
        var teacher = TeachersModel.builder()
                .registry(Integer.valueOf(request.getParameter("registry")))
                .name(request.getParameter("name"))
                .serie(Integer.valueOf(request.getParameter("serie")))
                .email(request.getParameter("email"))
                .password(passwordEncoder.encode(request.getParameter("password")))
                .role(Role.USER)
                .build();
        repository.save(teacher);
        var jwtToken = jwtService.generateToken(teacher);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse authenticate(final HttpServletRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getParameter("email"), request.getParameter("password")));
        var user = repository.findByEmail(request.getParameter("email")).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
