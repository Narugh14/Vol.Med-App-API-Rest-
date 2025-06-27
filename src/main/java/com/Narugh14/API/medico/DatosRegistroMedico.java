package com.Narugh14.API.medico;

import com.Narugh14.API.direccion.DatosDireccion;


public record DatosRegistroMedico(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DatosDireccion datosDireccion
) {
}
