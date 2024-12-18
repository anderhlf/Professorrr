package com.multiversa.demo.repositorio;

import com.multiversa.demo.modelo.InquilinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinoRepository extends JpaRepository<InquilinoModel, Long> {
}
