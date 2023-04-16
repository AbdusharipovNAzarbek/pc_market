package com.company.PC_market.controller;

import com.company.PC_market.entity.Action;
import com.company.PC_market.payload.ActionDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/action")
public class ActionController {

    @Autowired
    ActionService actionService;

    @GetMapping
    public ResponseEntity<List<Action>> getAll(@RequestParam int page, @RequestParam int size) {
        List<Action> actionList = actionService.getAll(page, size);
        return ResponseEntity.ok(actionList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getOne(@PathVariable Integer id) {
        Action action = actionService.getOne(id);
        return ResponseEntity.status(action != null ? 200 : 404).body(action);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody ActionDto actionDto) {
        Response response = actionService.create(actionDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable Integer id, @RequestBody ActionDto actionDto) {
        Response response = actionService.edit(id, actionDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        Response response = actionService.delete(id);
        return ResponseEntity.status(response.isStatus() ? 204 : 409).body(response);
    }

}
