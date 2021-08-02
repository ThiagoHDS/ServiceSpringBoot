package com.example.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {

    private TurmaRepository turmaRepository;

    @Autowired 
    public TurmaController(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
}

    
}
