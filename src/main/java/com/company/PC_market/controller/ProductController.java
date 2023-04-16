package com.company.PC_market.controller;

import com.company.PC_market.entity.Product;
import com.company.PC_market.payload.ProductDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @GetMapping
    public ResponseEntity<List<Product>> getAll(@RequestParam int page, @RequestParam int size) {
        List<Product> product = productService.getAll(page, size);
        return ResponseEntity.ok(product);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable Integer id) {
        Product product = productService.getOne(id);
        return ResponseEntity.status(product != null ? 200 : 404).body(product);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody ProductDto productDto) {
        Response response = productService.create(productDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Response response = productService.edit(id, productDto);
        return ResponseEntity.status(response.isStatus() ? 203 : 409).body(response);
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        Response response = productService.delete(id);
        return ResponseEntity.status(response.isStatus() ? 204 : 409).body(response);
    }
}
