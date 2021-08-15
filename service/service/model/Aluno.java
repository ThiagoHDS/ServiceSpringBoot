package com.example.service.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "aluno")
public class Aluno {

    @ManyToMany
    @JoinTable(
        name = "turma_aluno", 
        joinColumns = @JoinColumn(name = "aluno_id"), 
        inverseJoinColumns = @JoinColumn(name = "turma_id"))
    private Set<Turma> turmas_aluno;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula", unique = true)
    private String matricula;

    @Column(name = "email", unique = true)
    private String email;

    public Aluno(String nome, String matricula, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
    }
}