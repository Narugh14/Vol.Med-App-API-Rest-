package com.Narugh14.API.controller;

import com.Narugh14.API.paciente.DatosRegistroPaciente;
import com.Narugh14.API.paciente.IPacienteRepository;
import com.Narugh14.API.paciente.Paciente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/pacientes")
public class PacienteController {

    @Autowired
    IPacienteRepository pacienteRepository;

    public void registrar(@RequestBody @Valid DatosRegistroPaciente datos){
        pacienteRepository.save(new Paciente(datos));
    }
}
