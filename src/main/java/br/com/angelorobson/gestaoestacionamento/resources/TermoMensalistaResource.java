package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.TermoMensalista;
import br.com.angelorobson.gestaoestacionamento.domain.TermoMensalista;
import br.com.angelorobson.gestaoestacionamento.services.TermoMensalistaService;
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
@RequestMapping(value = "/termoMensalistas")
public class TermoMensalistaResource {

    @Autowired
    TermoMensalistaService termoMensalista;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TermoMensalista>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(termoMensalista.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody TermoMensalista termoMensalista) {
        termoMensalista = this.termoMensalista.salvar(termoMensalista);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(termoMensalista.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        TermoMensalista termoMensalista = this.termoMensalista.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(termoMensalista);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody TermoMensalista termoMensalista, @PathVariable("id") Long id){
        termoMensalista.setId(id);
        this.termoMensalista.atualizar(termoMensalista);

        return ResponseEntity.noContent().build();
    }
}
