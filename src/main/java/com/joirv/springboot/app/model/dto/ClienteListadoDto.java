package com.joirv.springboot.app.model.dto;

import com.joirv.springboot.app.model.entity.Cliente;

public record ClienteListadoDto(
        Long idCliente,
        String nombre,
        String apellido,
        String correo
        ) {

    public ClienteListadoDto(Cliente cliente){
        this(cliente.getIdCliente(), cliente.getNombre(), cliente.getApellido(), cliente.getCorreo());
    }

}
