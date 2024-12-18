package com.multiversa.demo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name="Imovel")
@Data
public class ImovelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String endereco;

    @Column(nullable = false, unique = true, length = 100)
    private Double valor_Aluguel;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private ProprietarioModel proprietario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getValor_Aluguel() {
        return valor_Aluguel;
    }

    public void setValor_Aluguel(Double valor_Aluguel) {
        this.valor_Aluguel = valor_Aluguel;
    }


}