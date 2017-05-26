package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.Mensalista;
import br.com.angelorobson.gestaoestacionamento.domain.Mensalista;
import br.com.angelorobson.gestaoestacionamento.services.MensalistaService;
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
@RequestMapping(value = "/mensalistas")
public class MensalistaResource {

    @Autowired
    MensalistaService mensalistaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Mensalista>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(mensalistaService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Mensalista mensalista) {
        mensalista = mensalistaService.salvar(mensalista);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(mensalista.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Mensalista mensalista = mensalistaService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(mensalista);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Mensalista mensalista, @PathVariable("id") Long id){
        mensalista.setId(id);
        mensalistaService.atualizar(mensalista);

        return ResponseEntity.noContent().build();
    }
}
