package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.Funcionario;
import br.com.angelorobson.gestaoestacionamento.domain.Funcionario;
import br.com.angelorobson.gestaoestacionamento.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Angelo on 11/05/2017.
 */
@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    FuncionarioService funcionarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Funcionario>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionario = funcionarioService.salvar(funcionario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Funcionario funcionario = funcionarioService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(funcionario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Funcionario funcionario, @PathVariable("id") Long id){
        funcionario.setId(id);
        funcionarioService.atualizar(funcionario);

        return ResponseEntity.noContent().build();
    }
}
