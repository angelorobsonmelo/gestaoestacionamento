package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.Empresa;
import br.com.angelorobson.gestaoestacionamento.repository.EmpresaRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> listar(){
      return empresaRepository.findAll();
    }

    @Transactional
    public Empresa salvar(Empresa empresa){
        empresa.setId(null);

        return  empresaRepository.saveAndFlush(empresa);
    }

    public Empresa buscar(Long id){
        Empresa empresa = empresaRepository.findOne(id);

        if(empresa == null){
            throw new Excecao();
        }

        return empresa;
    }

    public void atualizar(Empresa proprietario){
        verificarExistencia(proprietario);
        empresaRepository.save(proprietario);
    }

    private void verificarExistencia(Empresa proprietario) {
        buscar(proprietario.getId());
    }

}
