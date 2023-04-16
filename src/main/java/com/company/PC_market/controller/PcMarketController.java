package com.company.PC_market.controller;

import com.company.PC_market.entity.PcMarket;
import com.company.PC_market.payload.PcMarketDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.service.PcMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class PcMarketController {
    @Autowired
    PcMarketService pcMarketService;

    @GetMapping
    public ResponseEntity<List<PcMarket>> getAll(@RequestParam int page, @RequestParam int size) {
        List<PcMarket> pcMarket = pcMarketService.getAll(page, size);
        return ResponseEntity.ok(pcMarket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PcMarket> getOne(@PathVariable Integer id) {
        PcMarket pcMarket = pcMarketService.getOne(id);
        return ResponseEntity.status(pcMarket != null ? 200 : 404).body(pcMarket);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody PcMarketDto pcMarketDto) {
        Response response = pcMarketService.create(pcMarketDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable Integer id, @RequestBody PcMarketDto pcMarketDto) {
        Response response = pcMarketService.edit(id, pcMarketDto);
        return ResponseEntity.status(response.isStatus() ? 203 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        Response response = pcMarketService.delete(id);
        return ResponseEntity.status(response.isStatus() ? 204 : 409).body(response);
    }
}
