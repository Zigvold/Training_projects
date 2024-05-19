package ru.flamehander.spring.securityjwt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.flamehander.spring.securityjwt.dtos.RegistrationUserDto;
import ru.flamehander.spring.securityjwt.models.User;
import ru.flamehander.spring.securityjwt.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleService roleService;


    Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", username)));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role ->
                        new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    public User createNewUser(RegistrationUserDto registrationUserDto){
        User user = new User(
                registrationUserDto.getUsername(),
                registrationUserDto.getPassword(),
                registrationUserDto.getEmail()
        );
        user.setRoles(List.of(roleService.findByName("USER_ROLE").get()));
        return userRepository.save(user);
    }

}
