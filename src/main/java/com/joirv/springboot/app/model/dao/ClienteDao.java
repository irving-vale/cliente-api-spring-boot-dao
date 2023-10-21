package com.joirv.springboot.app.model.dao;

import com.joirv.springboot.app.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Long> {
    Page<Cliente> findAll(Pageable pageable);
}
