package ru.flamehander.spring.securityjwt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flamehander.spring.securityjwt.models.Role;
import ru.flamehander.spring.securityjwt.repositories.RoleRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<Role> findByName(String name){
        return roleRepository.findByName(name);
    }
}
