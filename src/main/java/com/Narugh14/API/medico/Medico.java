package com.Narugh14.API.medico;

import com.Narugh14.API.direccion.DatosDireccion;
import com.Narugh14.API.direccion.Direccion;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
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
}
