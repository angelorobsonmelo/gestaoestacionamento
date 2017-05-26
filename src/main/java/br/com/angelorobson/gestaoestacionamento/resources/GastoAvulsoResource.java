package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.GastoAvulso;
import br.com.angelorobson.gestaoestacionamento.domain.GastoAvulso;
import br.com.angelorobson.gestaoestacionamento.services.GastoAvulsoService;
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
@RequestMapping(value = "/gastoAvulsos")
public class GastoAvulsoResource {

    @Autowired
    GastoAvulsoService gastoAvulsoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<GastoAvulso>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(gastoAvulsoService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody GastoAvulso gastoAvulso) {
        gastoAvulso = gastoAvulsoService.salvar(gastoAvulso);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(gastoAvulso.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        GastoAvulso gastoAvulso = gastoAvulsoService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(gastoAvulso);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody GastoAvulso gastoAvulso, @PathVariable("id") Long id){
        gastoAvulso.setId(id);
        gastoAvulsoService.atualizar(gastoAvulso);

        return ResponseEntity.noContent().build();
    }
}
