package com.multiversa.demo.repositorio;

import com.multiversa.demo.modelo.ImovelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelModel, Long> {
}