package com.joirv.springboot.app.model.entity;

import com.joirv.springboot.app.model.dto.ClienteRegistroDto;
import com.joirv.springboot.app.model.dto.ClienteUpdateDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clientes")
@EqualsAndHashCode(of = "id")
public class Cliente implements Serializable {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public Cliente(ClienteRegistroDto clienteRegistroDto) {
        this.nombre = clienteRegistroDto.nombre();
        this.apellido = clienteRegistroDto.apellido();
        this.correo = clienteRegistroDto.correo();
        this.fechaRegistro = clienteRegistroDto.fechaRegistro();
    }

    public void update(ClienteUpdateDto clienteUpdateDto){
        if (clienteUpdateDto.nombre() !=null){
            this.nombre = clienteUpdateDto.nombre();
        }
        if (clienteUpdateDto.apellido() !=null){
            this.apellido = clienteUpdateDto.apellido();
        }
        if (clienteUpdateDto.correo() != null){
            this.correo = clienteUpdateDto.correo();
        }
    }
}




