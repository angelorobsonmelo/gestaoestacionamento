package br.com.angelorobson.gestaoestacionamento.services;

import br.com.angelorobson.gestaoestacionamento.domain.Proprietario;
import br.com.angelorobson.gestaoestacionamento.domain.Proprietario;
import br.com.angelorobson.gestaoestacionamento.domain.TelefoneUsuario;
import br.com.angelorobson.gestaoestacionamento.repository.TelefoneUsuarioRepository;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import br.com.angelorobson.gestaoestacionamento.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Angelo on 11/05/2017.
 */
@Service
public class ProprietarioService {

    @Autowired
    ProprietarioRepository proprietarioRepository;

    public List<Proprietario> listar(){
      return proprietarioRepository.findAll();
    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario){
        proprietario.setId(null);

        return  proprietarioRepository.saveAndFlush(proprietario);
    }

    public Proprietario buscar(Long id){
        Proprietario proprietario = proprietarioRepository.findOne(id);

        if(proprietario == null){
            throw new Excecao();
        }

        return proprietario;
    }

    public void atualizar(Proprietario proprietario){
        verificarExistencia(proprietario);
        proprietarioRepository.save(proprietario);
    }

    private void verificarExistencia(Proprietario proprietario) {
        buscar(proprietario.getId());
    }

}
