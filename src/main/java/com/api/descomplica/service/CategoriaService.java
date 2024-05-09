package com.api.descomplica.service;

import com.api.descomplica.entidades.Categoria;
import com.api.descomplica.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria categoriaAtualizada(Long id, Categoria categoriaAtualizada) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            if (categoriaAtualizada.getNome_categoria() != null) {
                categoria.setNome_categoria(categoriaAtualizada.getNome_categoria());
            }
            return categoriaRepository.save(categoria);
        } else {
            return null;
        }
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
