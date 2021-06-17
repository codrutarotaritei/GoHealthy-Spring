package com.project.goHealthy.controller;

import com.project.goHealthy.entity.AuthRequest;
import com.project.goHealthy.entity.User;
import com.project.goHealthy.repository.UserRepository;
import com.project.goHealthy.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WelcomeController {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public WelcomeController(JwtUtil jwtUtil,
                             AuthenticationManager authenticationManager,
                             PasswordEncoder passwordEncoder,
                             UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to site!";
    }

    @PostMapping("/authenticate")
    public boolean generateToken(@RequestBody AuthRequest authRequest, HttpServletResponse response) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        }catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        String token = jwtUtil.generateToken(authRequest.getUsername());
        Cookie cookie = new Cookie("Token", token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        cookie.setSecure(false);
//        response.addHeader("Access-Control-Allow-Headers", "http://localhost:4200");
        response.addCookie(cookie);
        return true;
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        System.out.println("Register accessed");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        userRepository.save(user);
    }
}
