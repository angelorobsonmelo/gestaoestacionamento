package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.PerfilUsuario;
import br.com.angelorobson.gestaoestacionamento.repository.PerfilUsuarioRespository;
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
@RequestMapping(value = "/perfilUsuarios")
public class PerfilUsuarioResource {

    @Autowired
    PerfilUsuarioRespository perfilUsuarioRespository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PerfilUsuario>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(perfilUsuarioRespository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody PerfilUsuario perfilUsuario) {
        perfilUsuario = perfilUsuarioRespository.save(perfilUsuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(perfilUsuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        PerfilUsuario proprietario = perfilUsuarioRespository.findOne(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(proprietario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody PerfilUsuario perfilUsuario, @PathVariable("id") Long id){
        perfilUsuario.setId(id);
        perfilUsuarioRespository.save(perfilUsuario);

        return ResponseEntity.noContent().build();
    }
}
