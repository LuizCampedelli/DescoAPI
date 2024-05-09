package com.api.descomplica.service;

import com.api.descomplica.entidades.Produto;
import com.api.descomplica.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void atualizarDescricaoProduto(Long id, String novaDescricao) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null) {
            produto.setDescricao(novaDescricao);
            produtoRepository.save(produto);
        }
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}