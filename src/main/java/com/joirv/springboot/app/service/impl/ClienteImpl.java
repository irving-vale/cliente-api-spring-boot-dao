package com.joirv.springboot.app.service.impl;

import com.joirv.springboot.app.model.dao.ClienteDao;
import com.joirv.springboot.app.model.dto.ClienteRegistroDto;
import com.joirv.springboot.app.model.entity.Cliente;
import com.joirv.springboot.app.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class ClienteImpl implements ICliente {

    @Autowired
    private ClienteDao clienteDao;

    @Transactional
    @Override
    public Cliente save(ClienteRegistroDto clienteRegistroDto) {
        return clienteDao.save(new Cliente(clienteRegistroDto));
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }


    public Page<Cliente> listarClientes(Pageable paginacion) {
        return clienteDao.findAll(paginacion);
    }

}
