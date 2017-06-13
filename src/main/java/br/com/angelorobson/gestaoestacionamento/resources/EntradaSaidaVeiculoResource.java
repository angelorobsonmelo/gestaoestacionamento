package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.EntradaSaidaVeiculo;
import br.com.angelorobson.gestaoestacionamento.services.EntradaSaidaVeiculoService;
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
@RequestMapping(value = "/entradaSaidaVeiculos")
public class EntradaSaidaVeiculoResource {

    @Autowired
    EntradaSaidaVeiculoService entradaSaidaVeiculoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EntradaSaidaVeiculo>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(entradaSaidaVeiculoService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody EntradaSaidaVeiculo entradaSaidaVeiculo) {
        entradaSaidaVeiculo = entradaSaidaVeiculoService.salvar(entradaSaidaVeiculo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(entradaSaidaVeiculo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        EntradaSaidaVeiculo entradaSaidaVeiculo = entradaSaidaVeiculoService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(entradaSaidaVeiculo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody EntradaSaidaVeiculo entradaSaidaVeiculo, @PathVariable("id") Long id){
        entradaSaidaVeiculo.setId(id);
        entradaSaidaVeiculoService.atualizar(entradaSaidaVeiculo);

        return ResponseEntity.noContent().build();
    }
}
