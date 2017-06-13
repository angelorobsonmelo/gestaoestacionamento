package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.Periodo;
import br.com.angelorobson.gestaoestacionamento.repository.PeriodoRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class PeriodoService {

    @Autowired
    PeriodoRepository periodoRepository;

    public List<Periodo> listar(){
      return periodoRepository.findAll();
    }

    @Transactional
    public Periodo salvar(Periodo periodo){
        periodo.setId(null);

        return  periodoRepository.saveAndFlush(periodo);
    }

    public Periodo buscar(Long id){
        Periodo periodo = periodoRepository.findOne(id);

        if(periodo == null){
            throw new Excecao();
        }

        return periodo;
    }

    public void atualizar(Periodo periodo){
        verificarExistencia(periodo);
        periodoRepository.save(periodo);
    }

    private void verificarExistencia(Periodo periodo) {
        buscar(periodo.getId());
    }

}
