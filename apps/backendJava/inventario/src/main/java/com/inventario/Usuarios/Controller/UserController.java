package com.inventario.Usuarios.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.Respuestas.ApiResponse;
import com.inventario.Respuestas.ResponseUtility;
import com.inventario.Usuarios.Model.UserInsertDTO;
import com.inventario.Usuarios.Model.UserLogin;
import com.inventario.Usuarios.Service.UserService;

@RestController
@RequestMapping("/backend/users")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {{
        this.userService = userService;
    }}

    /*
     * With this endpoint we can create an user, the required fields are user's name, email, password and rol
     */
    @PostMapping("/createUser")
    public ResponseEntity<ApiResponse<String>> createUser(@RequestBody UserInsertDTO request){

        userService.createUser(request);

        return ResponseUtility.buildResponse("success", "User created successfully", null);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody UserLogin request) {

        String response = userService.login(request);

        return ResponseUtility.buildResponse("success", "login successful", response);

    }

}
