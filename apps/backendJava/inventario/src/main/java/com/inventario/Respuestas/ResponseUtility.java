package com.inventario.Respuestas;

import org.springframework.http.ResponseEntity;

public class ResponseUtility {
    public static <T> ResponseEntity<ApiResponse<T>> buildResponse (String status, String message, T data) {
        ApiResponse<T> response = new ApiResponse<>(status, message, data);
        return ResponseEntity.ok(response);
    }
}
