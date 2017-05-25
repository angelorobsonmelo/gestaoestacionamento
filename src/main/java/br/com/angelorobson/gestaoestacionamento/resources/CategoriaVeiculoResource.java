package br.com.angelorobson.gestaoestacionamento.resources;

import br.com.angelorobson.gestaoestacionamento.domain.CategoriaVeiculo;
import br.com.angelorobson.gestaoestacionamento.domain.CategoriaVeiculo;
import br.com.angelorobson.gestaoestacionamento.repository.CategoriaVeiculoRepository;
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
@RequestMapping(value = "/categoriaVeiculos")
public class CategoriaVeiculoResource {

    @Autowired
    CategoriaVeiculoRepository categoriaVeiculoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaVeiculo>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaVeiculoRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody CategoriaVeiculo categoriaVeiculo) {
        categoriaVeiculo = categoriaVeiculoRepository.save(categoriaVeiculo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}").buildAndExpand(categoriaVeiculo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        CategoriaVeiculo proprietario = categoriaVeiculoRepository.findOne(id);

        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(proprietario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody CategoriaVeiculo categoriaVeiculo, @PathVariable("id") Long id){
        categoriaVeiculo.setId(id);
        categoriaVeiculoRepository.save(categoriaVeiculo);

        return ResponseEntity.noContent().build();
    }
}
