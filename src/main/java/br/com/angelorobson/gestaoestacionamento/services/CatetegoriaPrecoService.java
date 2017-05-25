package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.CategoriaPreco;
import br.com.angelorobson.gestaoestacionamento.domain.CategoriaPreco;
import br.com.angelorobson.gestaoestacionamento.repository.CategoriaPrecoRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class CatetegoriaPrecoService {

    @Autowired
    CategoriaPrecoRepository categoriaPrecoRepository;

    public List<CategoriaPreco> listar(){
      return categoriaPrecoRepository.findAll();
    }

    @Transactional
    public CategoriaPreco salvar(CategoriaPreco categoriaPreco){
        categoriaPreco.setId(null);

        return  categoriaPrecoRepository.saveAndFlush(categoriaPreco);
    }

    public CategoriaPreco buscar(Long id){
        CategoriaPreco categoriaPreco = categoriaPrecoRepository.findOne(id);

        if(categoriaPreco == null){
            throw new Excecao();
        }

        return categoriaPreco;
    }

    public void atualizar(CategoriaPreco proprietario){
        verificarExistencia(proprietario);
        categoriaPrecoRepository.save(proprietario);
    }

    private void verificarExistencia(CategoriaPreco proprietario) {
        buscar(proprietario.getId());
    }

}
