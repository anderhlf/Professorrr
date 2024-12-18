package com.multiversa.demo.controle;

import com.multiversa.demo.modelo.ProprietarioModel;
import com.multiversa.demo.servico.ProprietarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;

    }

    @PostMapping("/create")
    public ResponseEntity<ProprietarioModel> create(@RequestBody ProprietarioModel proprietario) {
        return ResponseEntity.ok(proprietarioService.salvar(proprietario));
    }

    @GetMapping
    public ResponseEntity<List<ProprietarioModel>> findAll() {
        return ResponseEntity.ok(proprietarioService.listarTodos());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<ProprietarioModel>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(proprietarioService.buscarPorId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProprietarioModel> update(@PathVariable Long id, @RequestBody ProprietarioModel professor) {
        return ResponseEntity.ok(proprietarioService.atualizar(id, professor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        proprietarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}