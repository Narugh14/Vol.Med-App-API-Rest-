package com.Narugh14.API.controller;

import com.Narugh14.API.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/pacientes")
public class PacienteController {

    @Autowired
    IPacienteRepository pacienteRepository;

    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroPaciente datos){
        pacienteRepository.save(new Paciente(datos));
    }

    @GetMapping
    public Page<DatosListPaciente> listar(@PageableDefault(size=10, sort = {"nombre"}) Pageable paginacion){
        return pacienteRepository.findAll(paginacion)
                .map(DatosListPaciente::new);
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizarPaciente datos){
        var paciente = pacienteRepository.getReferenceById(datos.id());
        paciente.actualizarInformacionPaciente(datos);
    }
}
