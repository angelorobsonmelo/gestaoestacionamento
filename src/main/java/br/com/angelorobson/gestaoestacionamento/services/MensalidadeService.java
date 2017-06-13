package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.Mensalidade;
import br.com.angelorobson.gestaoestacionamento.domain.Mensalidade;
import br.com.angelorobson.gestaoestacionamento.repository.MensalidadeRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class MensalidadeService {

    @Autowired
    MensalidadeRepository mensalidadeRepository;

    public List<Mensalidade> listar(){
      return mensalidadeRepository.findAll();
    }

    @Transactional
    public Mensalidade salvar(Mensalidade mensalidade){
        mensalidade.setId(null);



        return  mensalidadeRepository.saveAndFlush(mensalidade);
    }

    public Mensalidade buscar(Long id){
        Mensalidade mensalidade = mensalidadeRepository.findOne(id);

        if(mensalidade == null){
            throw new Excecao();
        }

        return mensalidade;
    }

    public void atualizar(Mensalidade mensalidade){
        verificarExistencia(mensalidade);
        mensalidadeRepository.save(mensalidade);
    }

    private void verificarExistencia(Mensalidade mensalidade) {
        buscar(mensalidade.getId());
    }

}
