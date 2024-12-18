package com.multiversa.demo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name="Proprietario")
@Data
public class ProprietarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;


    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private Set<ImovelModel> imoveis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ImovelModel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(Set<ImovelModel> imoveis) {
        this.imoveis = imoveis;
    }
}