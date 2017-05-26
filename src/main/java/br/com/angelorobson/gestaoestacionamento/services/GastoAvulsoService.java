package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.GastoAvulso;
import br.com.angelorobson.gestaoestacionamento.domain.GastoAvulso;
import br.com.angelorobson.gestaoestacionamento.repository.GastoAvulsoRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class GastoAvulsoService {

    @Autowired
    GastoAvulsoRepository gastoAvulsoRepository;

    public List<GastoAvulso> listar(){
      return gastoAvulsoRepository.findAll();
    }

    @Transactional
    public GastoAvulso salvar(GastoAvulso gastoAvulso){
        gastoAvulso.setId(null);

        return  gastoAvulsoRepository.saveAndFlush(gastoAvulso);
    }

    public GastoAvulso buscar(Long id){
        GastoAvulso gastoAvulso = gastoAvulsoRepository.findOne(id);

        if(gastoAvulso == null){
            throw new Excecao();
        }

        return gastoAvulso;
    }

    public void atualizar(GastoAvulso gastoAvulso){
        verificarExistencia(gastoAvulso);
        gastoAvulsoRepository.save(gastoAvulso);
    }

    private void verificarExistencia(GastoAvulso gastoAvulso) {
        buscar(gastoAvulso.getId());
    }

}
