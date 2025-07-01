package com.Narugh14.API.paciente;

import com.Narugh14.API.direccion.DatosDireccion;

public record DatosActualizarPaciente(
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
