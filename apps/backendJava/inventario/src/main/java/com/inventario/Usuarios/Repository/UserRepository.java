package com.inventario.Usuarios.Repository;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.inventario.Usuarios.Model.UserInsertDTO;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;    
    private final PasswordEncoder passwordEncoder;


    public UserRepository(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    public String createUser(UserInsertDTO request, String hashedPassword) {
        LocalDateTime fechaActual = LocalDateTime.now();
        String sql = """
                INSERT INTO public.usuarios (nombre_usuario, email_usuario, contraseña_usuario, rol_usuario, created_at) 
                VALUES (?,?,?,?,?)
                """;
        System.out.println("la query es " + sql);
        System.out.println("la contraseña es " + hashedPassword);
        System.out.println("el dto es " + request);
        jdbcTemplate.update(sql, request.getNombre(), request.getEmail(), hashedPassword, request.getRol(), fechaActual);
        return null;
    }


    public String login(String username, String password) {

        String sql = """
                SELECT contraseña_usuario FROM public.usuarios WHERE nombre_usuario = ?
                """;

        try {

            String hashedPassword = jdbcTemplate.queryForObject(sql, String.class, username);
    
            if (passwordEncoder.matches(password, hashedPassword)) {
                return "success";
            } else {
                return "forbidden";
            }

        } catch (Exception e) {
            return "El usuario y/o la contraseña son incorrectos";
        }

    }
}
