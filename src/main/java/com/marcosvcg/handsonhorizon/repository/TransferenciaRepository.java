package com.marcosvcg.handsonhorizon.repository;

import com.marcosvcg.handsonhorizon.model.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, UUID> {
}
