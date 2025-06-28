package com.Narugh14.API.controller;

import com.Narugh14.API.medico.DatosRegistroMedico;
import com.Narugh14.API.medico.IMedicoRepository;
import com.Narugh14.API.medico.Medico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private IMedicoRepository medicoRepository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos){
        medicoRepository.save(new Medico(datos));
    }
}
