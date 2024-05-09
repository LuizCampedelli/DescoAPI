package com.api.descomplica.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id_produto;

    @Column(name = "nome_produto")
    private String nome_produto;

    @Column(name = "descricao_produto")
    private String descricao;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;

}
