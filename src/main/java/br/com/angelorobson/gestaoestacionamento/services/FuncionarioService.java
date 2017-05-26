package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.Funcionario;
import br.com.angelorobson.gestaoestacionamento.domain.Funcionario;
import br.com.angelorobson.gestaoestacionamento.repository.FuncionarioRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listar(){
      return funcionarioRepository.findAll();
    }

    @Transactional
    public Funcionario salvar(Funcionario funcionario){
        funcionario.setId(null);

        return  funcionarioRepository.saveAndFlush(funcionario);
    }

    public Funcionario buscar(Long id){
        Funcionario proprietario = funcionarioRepository.findOne(id);

        if(proprietario == null){
            throw new Excecao();
        }

        return proprietario;
    }

    public void atualizar(Funcionario funcionario){
        verificarExistencia(funcionario);
        funcionarioRepository.save(funcionario);
    }

    private void verificarExistencia(Funcionario funcionario) {
        buscar(funcionario.getId());
    }

}
