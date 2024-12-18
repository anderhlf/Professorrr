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
    private ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    public List<ProprietarioModel> listarTodos() {
        return proprietarioRepository.findAll();
    }


    public Optional<ProprietarioModel> buscarPorId(Long id) {
        return proprietarioRepository.findById(id);
    }


    public ProprietarioModel salvar(ProprietarioModel proprietario) {
        return proprietarioRepository.save(proprietario);
    }


    public ProprietarioModel atualizar(Long proprietarioId, ProprietarioModel proprietario) {

        ProprietarioModel proprietarioExistente = proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new IllegalArgumentException("não encontrado"));

        proprietarioExistente.setNome(proprietario.getNome());
        proprietarioExistente.setEmail(proprietario.getEmail());
        proprietarioExistente.setImoveis(proprietario.getImoveis());

        return proprietarioRepository.save(proprietarioExistente);
    }

    public void deleteById(Long id) {
        proprietarioRepository.deleteById(id);
    }

}