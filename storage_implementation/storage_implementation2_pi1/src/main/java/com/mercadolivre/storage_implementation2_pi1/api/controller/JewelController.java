package com.mercadolivre.storage_implementation2_pi1.api.controller;

import com.mercadolivre.storage_implementation2_pi1.api.assembler.JewelAssembler;
import com.mercadolivre.storage_implementation2_pi1.api.model.JewelRequest;
import com.mercadolivre.storage_implementation2_pi1.api.model.JewelResponse;
import com.mercadolivre.storage_implementation2_pi1.domain.service.IJewelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping()
public class JewelController {

    private final IJewelService service;
    private final JewelAssembler mapper;

    @PostMapping("joia/inserir")
    public ResponseEntity<?> create (@RequestBody JewelRequest jewelRequest) {
        JewelResponse responseObject = mapper.toResponseObject(service.save(mapper.toDomainObject(jewelRequest)));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", responseObject.getId())
                .build();
    }

    @GetMapping("joias")
    public ResponseEntity<List<JewelResponse>> findAll() {
        List<JewelResponse> list = service.findAll()
                .stream()
                .map(jewel -> mapper.toResponseObject(jewel))
                .collect(Collectors.toList());

        return ResponseEntity
                .ok()
                .body(list);
    }

    @DeleteMapping("joia/excluir")
    public ResponseEntity<?> delete(@RequestParam String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("joia/atualizar")
    ResponseEntity<?> update(@RequestBody JewelRequest jewelRequest, @RequestParam String id) {
        jewelRequest.setId(id);
        service.save(mapper.toDomainObject(jewelRequest));
        return ResponseEntity.ok().build();
    }

}
