package com.multiversa.demo.servico;

import com.multiversa.demo.modelo.ProprietarioModel;
import com.multiversa.demo.repositorio.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository professorRepository;

    public ProprietarioService(ProprietarioRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProprietarioModel> listarTodos() {
        return professorRepository.findAll();
    }


    public Optional<ProprietarioModel> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }


    public ProprietarioModel salvar(ProprietarioModel professor) {
        return professorRepository.save(professor);
    }


    public ProprietarioModel atualizar(Long professorId, ProprietarioModel professor) {

        ProprietarioModel professorExistente = professorRepository.findById(professorId)
                .orElseThrow(() -> new IllegalArgumentException("não encontrado"));

        professorExistente.setNome(professor.getNome());
        professorExistente.setEmail(professor.getEmail());
        professorExistente.setImoveis(professor.getImoveis());

        return professorRepository.save(professorExistente);
    }

    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

}