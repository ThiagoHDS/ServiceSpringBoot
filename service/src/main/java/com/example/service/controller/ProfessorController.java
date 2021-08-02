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
@RequestMapping(value = "/professores")
public class ProfessorController {

    private ProfessorRepository professorRepository;
    
    @Autowired 
    public ProfessorController(ProfessorRepository professorRepository) {
         this.professorRepository = professorRepository;
    }
    
    @GetMapping
    public List<Professor> getAlunos() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Professor> getCoffeeById(@PathVariable Long id) {
        return professorRepository.findById(id);
    }

    @PostMapping
    public Professor createCoffee(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor updateCoffee(@PathVariable("id") Long id, @RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable Long id) {
         professorRepository.delete(professorRepository.findById(id).get());

    }
    
}
