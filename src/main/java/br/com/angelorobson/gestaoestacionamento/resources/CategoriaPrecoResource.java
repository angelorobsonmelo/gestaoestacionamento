package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.CategoriaPreco;
import br.com.angelorobson.gestaoestacionamento.domain.CategoriaPreco;
import br.com.angelorobson.gestaoestacionamento.repository.CategoriaPrecoRepository;
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
@RequestMapping(value = "/categoriaPrecos")
public class CategoriaPrecoResource {

    @Autowired
    CategoriaPrecoRepository categoriaPrecoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaPreco>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaPrecoRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody CategoriaPreco categoriaPreco) {
        categoriaPreco = categoriaPrecoRepository.save(categoriaPreco);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(categoriaPreco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        CategoriaPreco categoriaPreco = categoriaPrecoRepository.findOne(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(categoriaPreco);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody CategoriaPreco categoriaPreco, @PathVariable("id") Long id){
        categoriaPreco.setId(id);
        categoriaPrecoRepository.save(categoriaPreco);

        return ResponseEntity.noContent().build();
    }
}
