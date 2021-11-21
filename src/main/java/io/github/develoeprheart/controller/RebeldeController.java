package io.github.develoeprheart.controller;


import io.github.develoeprheart.repository.inventario.Inventario;
import io.github.develoeprheart.repository.localizacao.Localizacao;
import io.github.develoeprheart.repository.rebelde.Rebelde;
import io.github.develoeprheart.verbos.patch.request.PatchRebeldeRequest;
import io.github.develoeprheart.verbos.post.requestes.InventoryRequest;
import io.github.develoeprheart.verbos.post.requestes.LocalizacaoRequest;
import io.github.develoeprheart.verbos.post.requestes.RebeldeRequest;
import io.github.develoeprheart.verbos.post.responses.RebeldeResponse;
import io.github.develoeprheart.service.RebeldeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.UUID;

@RestController
@RequestMapping(value = "v1/rebelde")
public class RebeldeController {

    @Autowired
    private RebeldeService rebeldeService;

    @PostMapping("/")
    public ResponseEntity<RebeldeResponse> save(@RequestBody RebeldeRequest rebeldeRequest){
        try {
            Rebelde entidade = new Rebelde();
            BeanUtils.copyProperties(rebeldeRequest, entidade);
            entidade.setInventario(new Inventario(rebeldeRequest.getInventario()));
            entidade.setLocalizacao(new Localizacao(rebeldeRequest.getLocalizacao()));
            Rebelde rebeldinho = rebeldeService.save(entidade);
            RebeldeResponse response = new RebeldeResponse();
            BeanUtils.copyProperties(rebeldinho,  response);
            response.setLocalizacao(new LocalizacaoRequest(entidade.getLocalizacao()));
            response.setInventario(new InventoryRequest(entidade.getInventario()));

            return  ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RebeldeResponse());
        }

    }

    @PatchMapping("v1/rebelde/{id}")
    public EntityResponse<?> edit(@PathVariable UUID id, @RequestBody PatchRebeldeRequest rebeldeRequest){
        return null;
    }
}