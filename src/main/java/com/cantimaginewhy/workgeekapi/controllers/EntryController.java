package com.cantimaginewhy.workgeekapi.controllers;

import java.util.List;

import com.cantimaginewhy.workgeekapi.repositories.EntryRepository;
import com.cantimaginewhy.workgeekapi.exceptions.EntryNotFoundException;
import com.cantimaginewhy.workgeekapi.models.WordEntry;

// import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntryController {
  private final EntryRepository repository;

  public EntryController(EntryRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/entries")
  public List<WordEntry> all() {
    return repository.findAll();
  }

  @PostMapping("/entries")
  public WordEntry addOne(@RequestBody WordEntry newEntry) {
    return repository.save(newEntry);
  }

  // single item
  @GetMapping("/entries/{id}")
  public WordEntry one(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new EntryNotFoundException(id));
  }

  @DeleteMapping("/entries/{id}")
  public void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
