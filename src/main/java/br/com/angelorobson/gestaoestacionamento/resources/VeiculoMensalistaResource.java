package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.VeiculoMensalista;
import br.com.angelorobson.gestaoestacionamento.domain.VeiculoMensalista;
import br.com.angelorobson.gestaoestacionamento.services.VeiculoMensalistaService;
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
@RequestMapping(value = "/veiculoMensalistas")
public class VeiculoMensalistaResource {

    @Autowired
    VeiculoMensalistaService veiculoMensalistaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VeiculoMensalista>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoMensalistaService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody VeiculoMensalista veiculoMensalista) {
        veiculoMensalista = veiculoMensalistaService.salvar(veiculoMensalista);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(veiculoMensalista.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        VeiculoMensalista veiculoMensalista = veiculoMensalistaService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(veiculoMensalista);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody VeiculoMensalista veiculoMensalista, @PathVariable("id") Long id){
        veiculoMensalista.setId(id);
        veiculoMensalistaService.atualizar(veiculoMensalista);

        return ResponseEntity.noContent().build();
    }
}
