package com.Narugh14.API.controller;

import com.Narugh14.API.medico.DatosListaMedico;
import com.Narugh14.API.medico.DatosRegistroMedico;
import com.Narugh14.API.medico.IMedicoRepository;
import com.Narugh14.API.medico.Medico;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DatosListaMedico> listar(@PageableDefault(size=10, sort = {"nombre"}) Pageable paginacion){
        return medicoRepository.findAll(paginacion)
                .map(DatosListaMedico::new);
    }
}
