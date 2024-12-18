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


    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
    private Set<InquilinoModel> imoveis;

}