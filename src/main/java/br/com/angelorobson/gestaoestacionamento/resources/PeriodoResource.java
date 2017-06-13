package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.Periodo;
import br.com.angelorobson.gestaoestacionamento.services.PeriodoService;
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
@RequestMapping(value = "/periodos")
public class PeriodoResource {

    @Autowired
    PeriodoService periodoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Periodo>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(periodoService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Periodo periodo) {
        periodo = periodoService.salvar(periodo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(periodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Periodo periodo = periodoService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(periodo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Periodo periodo, @PathVariable("id") Long id){
        periodo.setId(id);
        periodoService.atualizar(periodo);

        return ResponseEntity.noContent().build();
    }
}
