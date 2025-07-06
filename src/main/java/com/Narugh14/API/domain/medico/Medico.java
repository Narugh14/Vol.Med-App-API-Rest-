package com.Narugh14.API.domain.medico;

import com.Narugh14.API.domain.direccion.Direccion;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datos) {
        this.id = null;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documento = datos.documento();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public Medico(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public void actualizarInformacionMedico(@Valid DatosActualizarMedico datos) {
        if(datos.nombre() != null){
            this.nombre = datos.nombre();
        }
         if(datos.telefono() != null){
            this.telefono = datos.telefono();
         }
         if(datos.direccion() != null){
            this.direccion.actualizarDireccion(datos.direccion());
         }
    }
}
