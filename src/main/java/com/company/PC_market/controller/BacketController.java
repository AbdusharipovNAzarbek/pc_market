package com.company.PC_market.controller;

import com.company.PC_market.entity.Backet;
import com.company.PC_market.payload.BacketDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.service.BacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backet")
public class BacketController {
    @Autowired
    BacketService backetService;

    @GetMapping
    public ResponseEntity<List<Backet>> getAll(@RequestParam int page, @RequestParam int size) {
        List<Backet> backetList = backetService.getAll(page, size);
        return ResponseEntity.ok(backetList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Backet> getOne(@PathVariable Integer id) {
        Backet backet = backetService.getOne(id);
        return ResponseEntity.status(backet != null ? 200 : 404).body(backet);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody BacketDto backetDto) {
        Response response = backetService.create(backetDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable Integer id, @RequestBody BacketDto backetDto) {
        Response response = backetService.edit(id, backetDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        Response response = backetService.delete(id);
        return ResponseEntity.status(response.isStatus() ? 204 : 409).body(response);
    }

}
