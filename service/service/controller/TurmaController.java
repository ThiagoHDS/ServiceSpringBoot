package com.example.service.controller;

import java.util.List;
import java.util.Optional;

import com.example.service.model.Turma;
import com.example.service.repository.TurmaRepository;

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
@RequestMapping(value = "/turmas")
public class TurmaController {

    private TurmaRepository turmaRepository;

    @Autowired 
    public TurmaController(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @GetMapping
	public List<Turma> getTurmas() {
		return turmaRepository.findAll();
    }

	@GetMapping("/{id}")
	public Optional<Turma> getTurmaById(@PathVariable Long id) {
		return turmaRepository.findById(id);
	}

	@PostMapping
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}

	@PutMapping("/{id}")
	public Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}

	@DeleteMapping("/{id}")
	public void deleteTurma(@PathVariable Long id) {
		turmaRepository.delete(turmaRepository.findById(id).get());

	}

    
}
