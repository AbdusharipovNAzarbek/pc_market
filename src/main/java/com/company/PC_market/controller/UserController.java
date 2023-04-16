package com.company.PC_market.controller;

import com.company.PC_market.entity.User;
import com.company.PC_market.payload.UserDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.service.UserService;
import com.company.PC_market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(@RequestParam int page, @RequestParam int size) {
        List<User> actionList = userService.getAll(page, size);
        return ResponseEntity.ok(actionList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable Integer id) {
        User action = userService.getOne(id);
        return ResponseEntity.status(action != null ? 200 : 404).body(action);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody UserDto actionDto) {
        Response response = userService.create(actionDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable Integer id, @RequestBody UserDto actionDto) {
        Response response = userService.edit(id, actionDto);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        Response response = userService.delete(id);
        return ResponseEntity.status(response.isStatus() ? 204 : 409).body(response);
    }

}
