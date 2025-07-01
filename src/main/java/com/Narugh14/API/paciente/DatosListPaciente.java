package com.Narugh14.API.paciente;

public record DatosListPaciente(
        String nombre,
        String email,
        String documento
) {
    public DatosListPaciente(Paciente paciente) {
        this(paciente.getNombre(),
                paciente.getEmail(),
                paciente.getDocumento());
    }
}
