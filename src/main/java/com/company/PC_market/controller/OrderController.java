package com.company.PC_market.controller;

import com.company.PC_market.entity.Order;
import com.company.PC_market.payload.OrderDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','OPERATOR')")
    @GetMapping
    public ResponseEntity<List<Order>> getAll(@RequestParam int page, @RequestParam int size) {
        List<Order> OrderList = orderService.getAll(page, size);
        return ResponseEntity.ok(OrderList);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','OPERATOR')")
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOne(@PathVariable Integer id) {
        Order order = orderService.getOne(id);
        return ResponseEntity.status(order != null ? 200 : 404).body(order);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','OPERATOR')")
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody OrderDto orderDto) {
        Response response = orderService.create(orderDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable Integer id, @RequestBody OrderDto orderDto) {
        Response response = orderService.edit(id, orderDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        Response response = orderService.delete(id);
        return ResponseEntity.status(response.isStatus() ? 204 : 409).body(response);
    }

}
