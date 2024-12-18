package com.multiversa.demo.repositorio;


import com.multiversa.demo.modelo.ProprietarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<ProprietarioModel, Long> {

}