package com.inventario.Usuarios.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventario.Usuarios.Model.UserInsertDTO;
import com.inventario.Usuarios.Repository.UserRepository;

@Service
public class UserService {

    public UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /*
     * Service used to hash the password using Argon2id
     */
    public String createUser(UserInsertDTO request) {

        String hashedPassword = passwordEncoder.encode(request.getContraseña());

        userRepository.createUser(request, hashedPassword);

        return null;
    }

    public String login(String username, String password) {

        String response = userRepository.login(username, password);

        return response;

    }
    
}
