package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.StatusMensalidade;
import br.com.angelorobson.gestaoestacionamento.domain.StatusMensalidade;
import br.com.angelorobson.gestaoestacionamento.services.StatusMensalidadeService;
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
@RequestMapping(value = "/statusMensalidades")
public class StatusMensalidadeResource {

    @Autowired
    StatusMensalidadeService statusMensalidadeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StatusMensalidade>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(statusMensalidadeService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody StatusMensalidade statusMensalidade) {
        statusMensalidade = statusMensalidadeService.salvar(statusMensalidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(statusMensalidade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        StatusMensalidade statusMensalidade = statusMensalidadeService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(statusMensalidade);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody StatusMensalidade statusMensalidade, @PathVariable("id") Long id){
        statusMensalidade.setId(id);
        statusMensalidadeService.atualizar(statusMensalidade);

        return ResponseEntity.noContent().build();
    }
}
