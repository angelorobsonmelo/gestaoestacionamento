package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.Mensalidade;
import br.com.angelorobson.gestaoestacionamento.services.MensalidadeService;
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
@RequestMapping(value = "/mensalidades")
public class MensalidadeResource {

    @Autowired
    MensalidadeService mensalidadeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Mensalidade>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(mensalidadeService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Mensalidade mensalidade) {
        mensalidade = mensalidadeService.salvar(mensalidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(mensalidade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Mensalidade mensalidade = mensalidadeService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(mensalidade);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Mensalidade mensalidade, @PathVariable("id") Long id){
        mensalidade.setId(id);
        mensalidadeService.atualizar(mensalidade);

        return ResponseEntity.noContent().build();
    }
}
