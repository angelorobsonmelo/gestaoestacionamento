package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.Proprietario;
import br.com.angelorobson.gestaoestacionamento.services.ProprietarioService;
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
@RequestMapping(value = "/proprietarios")
public class ProprietarioResource {

    @Autowired
    ProprietarioService proprietarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Proprietario>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(proprietarioService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Proprietario proprietario) {
        proprietario = proprietarioService.salvar(proprietario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(proprietario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Proprietario proprietario = proprietarioService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(proprietario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Proprietario proprietario, @PathVariable("id") Long id){
        proprietario.setId(id);
        proprietarioService.atualizar(proprietario);

        return ResponseEntity.noContent().build();
    }
}
