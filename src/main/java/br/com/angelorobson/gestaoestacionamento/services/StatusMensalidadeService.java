package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.StatusMensalidade;
import br.com.angelorobson.gestaoestacionamento.domain.StatusMensalidade;
import br.com.angelorobson.gestaoestacionamento.repository.StatusMensalidadeRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class StatusMensalidadeService {

    @Autowired
    StatusMensalidadeRepository statusMensalidadeRepository;

    public List<StatusMensalidade> listar(){
      return statusMensalidadeRepository.findAll();
    }

    @Transactional
    public StatusMensalidade salvar(StatusMensalidade statusMensalidade){
        statusMensalidade.setId(null);



        return  statusMensalidadeRepository.saveAndFlush(statusMensalidade);
    }

    public StatusMensalidade buscar(Long id){
        StatusMensalidade statusMensalidade = statusMensalidadeRepository.findOne(id);

        if(statusMensalidade == null){
            throw new Excecao();
        }

        return statusMensalidade;
    }

    public void atualizar(StatusMensalidade statusMensalidade){
        verificarExistencia(statusMensalidade);
        statusMensalidadeRepository.save(statusMensalidade);
    }

    private void verificarExistencia(StatusMensalidade statusMensalidade) {
        buscar(statusMensalidade.getId());
    }

}
