package com.joirv.springboot.app.controller;

import com.joirv.springboot.app.model.dto.ClienteListadoDto;
import com.joirv.springboot.app.model.dto.ClienteRegistroDto;
import com.joirv.springboot.app.model.dto.ClienteRespuestaDto;
import com.joirv.springboot.app.model.dto.ClienteUpdateDto;
import com.joirv.springboot.app.model.entity.Cliente;
import com.joirv.springboot.app.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody ClienteRegistroDto clienteRegistroDto){
       return clienteService.save(clienteRegistroDto);
    }

    @PutMapping("cliente")
    @Transactional // arreglo el problema, sin el no se guardaba la actualizacion del update en base de datos
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteRespuestaDto> update(@RequestBody ClienteUpdateDto clienteUpdateDto){
        Cliente cliente = clienteService.findById(clienteUpdateDto.idCliente());
        cliente.update(clienteUpdateDto);
       return ResponseEntity.ok(new ClienteRespuestaDto(cliente.getIdCliente(),cliente.getNombre(),
               cliente.getApellido(),cliente.getCorreo(),cliente.getFechaRegistro()));
    }

    @DeleteMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
       Cliente clienteDelete= clienteService.findById(id);
        clienteService.delete(clienteDelete);
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente showById(@PathVariable Long id){
       return clienteService.findById(id);
    }


    @GetMapping
    public ResponseEntity<Page<ClienteListadoDto>> listarClientes(@PageableDefault  Pageable page) {
        return ResponseEntity.ok(clienteService.listarClientes(page).map(ClienteListadoDto::new)) ;
    }
}
