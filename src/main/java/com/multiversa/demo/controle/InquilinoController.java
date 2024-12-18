package com.multiversa.demo.controle;


import com.multiversa.demo.servico.InquilinoService;
import com.multiversa.demo.modelo.InquilinoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/inquilino")
public class InquilinoController {

    private final InquilinoService inquilinoService;


    public InquilinoController(InquilinoService inquilinoService) {
        this.inquilinoService = inquilinoService;
    }


    @PostMapping("/create")
    public ResponseEntity<InquilinoModel> create(@RequestBody InquilinoModel inquilino) {
        return ResponseEntity.ok(inquilinoService.salvar(inquilino));
    }


    @GetMapping
    public ResponseEntity<List<InquilinoModel>> findAll() {
        return ResponseEntity.ok(inquilinoService.listarTodos());
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<InquilinoModel>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(inquilinoService.buscarPorId(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<InquilinoModel> update(@PathVariable Long id, @RequestBody InquilinoModel inquilino) {
        return ResponseEntity.ok(inquilinoService.update(id, inquilino));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        inquilinoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}