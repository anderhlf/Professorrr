package com.multiversa.demo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;


@Entity
@Table(name="Inquilino")
@Data

public class InquilinoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "inquilinos")
    private Set<ImovelModel> imoveis;

}