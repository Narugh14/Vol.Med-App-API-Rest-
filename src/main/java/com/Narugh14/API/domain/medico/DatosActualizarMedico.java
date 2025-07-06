package com.Narugh14.API.domain.medico;

import com.Narugh14.API.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(
        @NotNull  Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
