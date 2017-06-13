package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.PrecoCategoriaVeiculoPeriodo;
import br.com.angelorobson.gestaoestacionamento.domain.PrecoCategoriaVeiculoPeriodo;
import br.com.angelorobson.gestaoestacionamento.repository.PrecoCategoriaVeiculoPeriodoRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class PrecoCategoriaVeiculoPeriodoService {

    @Autowired
    PrecoCategoriaVeiculoPeriodoRepository precoCategoriaVeiculoPeriodoRepository;

    public List<PrecoCategoriaVeiculoPeriodo> listar(){
      return precoCategoriaVeiculoPeriodoRepository.findAll();
    }

    @Transactional
    public PrecoCategoriaVeiculoPeriodo salvar(PrecoCategoriaVeiculoPeriodo precoCategoriaVeiculoPeriodo){
        precoCategoriaVeiculoPeriodo.setId(null);



        return  precoCategoriaVeiculoPeriodoRepository.saveAndFlush(precoCategoriaVeiculoPeriodo);
    }

    public PrecoCategoriaVeiculoPeriodo buscar(Long id){
        PrecoCategoriaVeiculoPeriodo precoCategoriaVeiculoPeriodo = precoCategoriaVeiculoPeriodoRepository.findOne(id);

        if(precoCategoriaVeiculoPeriodo == null){
            throw new Excecao();
        }

        return precoCategoriaVeiculoPeriodo;
    }

    public void atualizar(PrecoCategoriaVeiculoPeriodo categoriaVeiculoPeriodo){
        verificarExistencia(categoriaVeiculoPeriodo);
        precoCategoriaVeiculoPeriodoRepository.save(categoriaVeiculoPeriodo);
    }

    private void verificarExistencia(PrecoCategoriaVeiculoPeriodo entradaSaidaVeiculo) {
        buscar(entradaSaidaVeiculo.getId());
    }

}
