package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.PrecoCategoriaVeiculoPeriodo;
import br.com.angelorobson.gestaoestacionamento.domain.PrecoCategoriaVeiculoPeriodo;
import br.com.angelorobson.gestaoestacionamento.services.PrecoCategoriaVeiculoPeriodoService;
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
@RequestMapping(value = "/precoCategoriaVeiculoPeriodos")
public class PrecoCategoriaVeiculoPeriodoResource {

  @Autowired
  PrecoCategoriaVeiculoPeriodoService precoCategoriaVeiculoPeriodoService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<PrecoCategoriaVeiculoPeriodo>> listar() {
    return ResponseEntity.status(HttpStatus.OK).body(precoCategoriaVeiculoPeriodoService.listar());
  }

  @CrossOrigin
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> salvar(@Valid @RequestBody PrecoCategoriaVeiculoPeriodo precoCategoriaVeiculoPeriodo) {
    precoCategoriaVeiculoPeriodo = precoCategoriaVeiculoPeriodoService.salvar(precoCategoriaVeiculoPeriodo);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
      path("/{id}").buildAndExpand(precoCategoriaVeiculoPeriodo.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> buscar(@PathVariable("id") Long id){
    PrecoCategoriaVeiculoPeriodo precoCategoriaVeiculoPeriodo = precoCategoriaVeiculoPeriodoService.buscar(id);

    CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

    return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(precoCategoriaVeiculoPeriodo);
  }

  @CrossOrigin
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> atualizar(@RequestBody PrecoCategoriaVeiculoPeriodo precoCategoriaVeiculoPeriodo, @PathVariable("id") Long id){
    precoCategoriaVeiculoPeriodo.setId(id);
    precoCategoriaVeiculoPeriodoService.atualizar(precoCategoriaVeiculoPeriodo);

    return ResponseEntity.noContent().build();
  }
}
