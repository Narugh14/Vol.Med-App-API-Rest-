package com.Narugh14.API.medico;

import com.Narugh14.API.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosActualizarMedico(
        @NotNull  Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
