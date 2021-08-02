package com.example.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    private AlunoRepository alunoRepository;
    
    @Autowired 
    public AlunoController(AlunoRepository alunoRepository) {
         this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> getCoffeeById(@PathVariable Long id) {
        return alunoRepository.findById(id);
    }

    @PostMapping
    public Aluno createCoffee(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno updateCoffee(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable Long id) {
        alunoRepository.delete(alunoRepository.findById(id).get());
    }
    
}