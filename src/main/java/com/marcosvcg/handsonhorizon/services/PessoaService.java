package com.marcosvcg.handsonhorizon.services;

import com.marcosvcg.handsonhorizon.exceptions.Exceptions;
import com.marcosvcg.handsonhorizon.model.entities.Pessoa;
import com.marcosvcg.handsonhorizon.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoaByID(UUID id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if(optionalPessoa.isEmpty()) throw new Exceptions.PessoaNotFoundException();
        return optionalPessoa.get();
    }

    public Pessoa getPessoaByNome(String nome) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findByNome(nome);
        if(optionalPessoa.isEmpty()) throw new Exceptions.PessoaNotFoundException();
        return optionalPessoa.get();
    }

    public void createPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }
}
