package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.Mensalista;
import br.com.angelorobson.gestaoestacionamento.domain.Mensalista;
import br.com.angelorobson.gestaoestacionamento.repository.MensalistaRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class MensalistaService {

    @Autowired
    MensalistaRepository mensalistaRepository;

    public List<Mensalista> listar(){
      return mensalistaRepository.findAll();
    }

    @Transactional
    public Mensalista salvar(Mensalista mensalista){
        mensalista.setId(null);

        return  mensalistaRepository.saveAndFlush(mensalista);
    }

    public Mensalista buscar(Long id){
        Mensalista mensalista = mensalistaRepository.findOne(id);

        if(mensalista == null){
            throw new Excecao();
        }

        return mensalista;
    }

    public void atualizar(Mensalista mensalista){
        verificarExistencia(mensalista);
        mensalistaRepository.save(mensalista);
    }

    private void verificarExistencia(Mensalista mensalista) {
        buscar(mensalista.getId());
    }

}
