package com.multiversa.demo.controle;


import com.multiversa.demo.servico.ImovelService;
import com.multiversa.demo.modelo.ImovelModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imoveis")
public class ImovelController{

    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @PostMapping("/create")
    public ResponseEntity<ImovelModel> create(@RequestBody ImovelModel imovel) {
        return ResponseEntity.ok(imovelService.salvar(imovel));
    }

    @GetMapping
    public ResponseEntity<List<ImovelModel>> findAll() {
        return ResponseEntity.ok(imovelService.listarTodas());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<ImovelModel>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(imovelService.buscarPorId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ImovelModel> update(@PathVariable Long id, @RequestBody ImovelModel imovel) {
        return ResponseEntity.ok(imovelService.update(id, imovel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        imovelService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}