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
@Table(name = "professor")
public class Professor {

    @ManyToMany
    @JoinTable(
        name = "turma_professor", 
        joinColumns = @JoinColumn(name = "professor_id"), 
        inverseJoinColumns = @JoinColumn(name = "turma_id"))
    private Set<Turma> turmas_professor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name =  "matricula", unique = true)
    private String matricula;

    public Professor(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }
    
}
