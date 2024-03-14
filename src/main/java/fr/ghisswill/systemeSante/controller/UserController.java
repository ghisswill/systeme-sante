package fr.ghisswill.systemeSante.controller;

import fr.ghisswill.systemeSante.model.User;
import fr.ghisswill.systemeSante.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity.HeadersBuilder<?> delete(UUID id) {
        return ResponseEntity.noContent();
    }
}
