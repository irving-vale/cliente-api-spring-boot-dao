package com.joirv.springboot.app.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record ClienteRespuestaDto(

        @NotBlank
        Long idCliente,
        @NotBlank
        String nombre,

        @NotBlank
        String apellido,

        @NotBlank
        @Email
        String correo,
        @NotBlank
        Date fechaRegistro) {
}
