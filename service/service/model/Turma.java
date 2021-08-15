package com.example.service.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", unique = true)
    private String nome;

    @ManyToMany(mappedBy = "turmas_aluno")
    private Set<Aluno> alunos;

    @ManyToMany(mappedBy = "turmas_professor")
    private Set<Professor> professores;

    public Turma(String nome){
        this.nome = nome;

    }

    
}
