package ru.flamehander.spring.securityjwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.flamehander.spring.securityjwt.dtos.*;
import ru.flamehander.spring.securityjwt.models.User;
import ru.flamehander.spring.securityjwt.services.UserService;
import ru.flamehander.spring.securityjwt.util.JwtTokenUtils;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),
                    authRequest.getPassword()
            ));
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),
                    "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token= jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@RequestBody RegistrationUserDto registrationUserDto){
        System.out.println(registrationUserDto);
        if (!(registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword()))){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
        }else if(userService.loadUserByUsername(registrationUserDto.getUsername()) != null){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "Пользователь с таким именем уже существует"), HttpStatus.BAD_REQUEST);
        }

        User newUser = userService.createNewUser(registrationUserDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return new ResponseEntity<>(new UserDto(newUser.getId(), newUser.getUsername(), newUser.getEmail()), HttpStatus.CREATED);
    }
}
