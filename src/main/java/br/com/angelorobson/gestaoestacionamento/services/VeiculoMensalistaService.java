package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.VeiculoMensalista;
import br.com.angelorobson.gestaoestacionamento.domain.VeiculoMensalista;
import br.com.angelorobson.gestaoestacionamento.repository.VeiculoMensalistaRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class VeiculoMensalistaService {

    @Autowired
    VeiculoMensalistaRepository veiculoMensalistaRepository;

    public List<VeiculoMensalista> listar(){
      return veiculoMensalistaRepository.findAll();
    }

    @Transactional
    public VeiculoMensalista salvar(VeiculoMensalista veiculoMensalista){
        veiculoMensalista.setId(null);

        return  veiculoMensalistaRepository.saveAndFlush(veiculoMensalista);
    }

    public VeiculoMensalista buscar(Long id){
        VeiculoMensalista veiculoMensalista = veiculoMensalistaRepository.findOne(id);

        if(veiculoMensalista == null){
            throw new Excecao();
        }

        return veiculoMensalista;
    }

    public void atualizar(VeiculoMensalista veiculoMensalista){
        verificarExistencia(veiculoMensalista);
        veiculoMensalistaRepository.save(veiculoMensalista);
    }

    private void verificarExistencia(VeiculoMensalista veiculoMensalista) {
        buscar(veiculoMensalista.getId());
    }

}
