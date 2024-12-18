package com.multiversa.demo.servico;

import com.multiversa.demo.modelo.InquilinoModel;
import com.multiversa.demo.modelo.ImovelModel;
import com.multiversa.demo.repositorio.InquilinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class InquilinoService {

    private final InquilinoRepository alunoRepository;

    public InquilinoService(InquilinoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<InquilinoModel> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<InquilinoModel> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public InquilinoModel salvar(InquilinoModel aluno) {
        return alunoRepository.save(aluno);
    }

    public InquilinoModel update(Long alunoId, InquilinoModel aluno) {
        InquilinoModel alunoExistente = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Inquilino: não encontrada"));

        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setEmail(aluno.getEmail());

        return alunoRepository.save(alunoExistente);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

}