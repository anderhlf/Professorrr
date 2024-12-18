package com.multiversa.demo.servico;


import com.multiversa.demo.modelo.ImovelModel;
import com.multiversa.demo.repositorio.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ImovelService{

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public List<ImovelModel> listarTodas() {
        return imovelRepository.findAll();
    }

    public Optional<ImovelModel> buscarPorId(Long id) {
        return imovelRepository.findById(id);
    }

    public ImovelModel salvar(ImovelModel imovel) {
        return imovelRepository.save(imovel);
    }

    public ImovelModel update(Long imovelId, ImovelModel imovel) {
        ImovelModel discipliExistente = imovelRepository.findById(imovelId)
                .orElseThrow(() -> new RuntimeException("Disciplina: não encontrada"));

        discipliExistente.setEndereco(imovel.getEndereco());
        discipliExistente.setValor_Aluguel(imovel.getValor_Aluguel());


        return imovelRepository.save(discipliExistente);
    }

    public void deleteById(Long id) {imovelRepository.deleteById(id);
    }
}