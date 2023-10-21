package com.joirv.springboot.app.service;

import com.joirv.springboot.app.model.dto.ClienteRegistroDto;
import com.joirv.springboot.app.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICliente {

    Cliente save(ClienteRegistroDto cliente);

    Cliente findById(Long id);

    void delete(Cliente cliente);

    Page<Cliente> listarClientes(Pageable paginacion);
}
