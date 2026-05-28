package ies.alcores.controllers;

import ies.alcores.persistence.model.Character;
import ies.alcores.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<Character>> getAll() {
        return ResponseEntity.ok(this.characterService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Character> getOne(@PathVariable("id") final String id) {
        return this.characterService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Character> create(@RequestBody final Character c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.characterService.create(c));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        return characterService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> update(@PathVariable final String id, @RequestBody final Character character) {
        Optional<Character> updated = this.characterService.update(id, character);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}