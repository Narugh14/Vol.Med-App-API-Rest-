package com.Narugh14.API.domain.paciente;

public record DatosListPaciente(
        Long id,
        String nombre,
        String email,
        String documento
) {
    public DatosListPaciente(Paciente paciente) {
        this(   paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getDocumento());
    }
}
