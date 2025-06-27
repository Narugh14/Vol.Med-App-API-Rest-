package com.Narugh14.API.paciente;

import com.Narugh14.API.direccion.DatosDireccion;

public record DatosRegistroPaciente(
        String nombre,
        String email,
        String documento,
        DatosDireccion datosDireccion
) {
}
