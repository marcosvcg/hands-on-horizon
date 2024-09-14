package com.marcosvcg.handsonhorizon.repository;

import com.marcosvcg.handsonhorizon.model.entities.Conta;
import com.marcosvcg.handsonhorizon.util.TipoContaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContaRepository extends JpaRepository<Conta, UUID> {
    @Query("SELECT c FROM Conta c WHERE c.pessoa.id = ?1")
    Optional<Conta> findByPessoaId(UUID id);

    @Query("SELECT c FROM Conta c WHERE c.pessoa.id = :pessoaId AND c.tipoConta = :tipoConta")
    Optional<Conta> findByPessoaIdAndTipoConta(UUID pessoaId, TipoContaEnum tipoConta);
}
