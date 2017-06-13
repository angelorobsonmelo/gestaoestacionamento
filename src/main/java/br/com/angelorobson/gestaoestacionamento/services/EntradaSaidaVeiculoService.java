package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.EntradaSaidaVeiculo;
import br.com.angelorobson.gestaoestacionamento.repository.EntradaSaidaVeiculoRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class EntradaSaidaVeiculoService {

    @Autowired
    EntradaSaidaVeiculoRepository entradaSaidaVeiculoRepository;

    public List<EntradaSaidaVeiculo> listar(){
      return entradaSaidaVeiculoRepository.findAll();
    }

    @Transactional
    public EntradaSaidaVeiculo salvar(EntradaSaidaVeiculo entradaSaidaVeiculo){
        entradaSaidaVeiculo.setId(null);



        return  entradaSaidaVeiculoRepository.saveAndFlush(entradaSaidaVeiculo);
    }

    public EntradaSaidaVeiculo buscar(Long id){
        EntradaSaidaVeiculo entradaSaidaVeiculo = entradaSaidaVeiculoRepository.findOne(id);

        if(entradaSaidaVeiculo == null){
            throw new Excecao();
        }

        return entradaSaidaVeiculo;
    }

    public void atualizar(EntradaSaidaVeiculo entradaSaidaVeiculo){
        verificarExistencia(entradaSaidaVeiculo);
        entradaSaidaVeiculoRepository.save(entradaSaidaVeiculo);
    }

    private void verificarExistencia(EntradaSaidaVeiculo entradaSaidaVeiculo) {
        buscar(entradaSaidaVeiculo.getId());
    }

}
