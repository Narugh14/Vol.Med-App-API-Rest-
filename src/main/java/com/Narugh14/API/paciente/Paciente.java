package com.Narugh14.API.paciente;


import com.Narugh14.API.direccion.Direccion;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Embedded
    private Direccion direccion;

    public Paciente(@Valid DatosRegistroPaciente datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documento = datos.documento();
        this.direccion = new Direccion(datos.direccion());
    }

    public Paciente() {
    }

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

    public Direccion getDireccion() {
        return direccion;
    }
}
