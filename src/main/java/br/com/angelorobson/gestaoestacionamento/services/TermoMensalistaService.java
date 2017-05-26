package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.TermoMensalista;
import br.com.angelorobson.gestaoestacionamento.domain.TermoMensalista;
import br.com.angelorobson.gestaoestacionamento.repository.TermoMensalistaRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class TermoMensalistaService {

    @Autowired
    TermoMensalistaRepository termoMensalistaRepository;

    public List<TermoMensalista> listar(){
      return termoMensalistaRepository.findAll();
    }

    @Transactional
    public TermoMensalista salvar(TermoMensalista termoMensalista){
        termoMensalista.setId(null);

        return  termoMensalistaRepository.saveAndFlush(termoMensalista);
    }

    public TermoMensalista buscar(Long id){
        TermoMensalista termoMensalista = termoMensalistaRepository.findOne(id);

        if(termoMensalista == null){
            throw new Excecao();
        }

        return termoMensalista;
    }

    public void atualizar(TermoMensalista termoMensalista){
        verificarExistencia(termoMensalista);
        termoMensalistaRepository.save(termoMensalista);
    }

    private void verificarExistencia(TermoMensalista termoMensalista) {
        buscar(termoMensalista.getId());
    }

}
