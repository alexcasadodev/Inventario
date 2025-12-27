package com.inventario.Usuarios.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInsertDTO {

    private String nombre;
    private String email;
    private String contraseña;
    private String rol;
    
}
