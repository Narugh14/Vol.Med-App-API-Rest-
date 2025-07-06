package com.Narugh14.API.domain.paciente;

import com.Narugh14.API.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarPaciente(
        @NotNull Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
