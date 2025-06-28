package com.Narugh14.API.paciente;

import com.Narugh14.API.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroPaciente(
        @NotBlank String nombre,
        @NotBlank String email,
        @NotBlank String telefono,
        @NotBlank String documento,
        @NotNull @Valid DatosDireccion direccion
) {
}
