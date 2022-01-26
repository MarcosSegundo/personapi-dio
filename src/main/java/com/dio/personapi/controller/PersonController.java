package com.dio.personapi.controller;

import com.dio.personapi.dto.post.PersonPostDTO;
import com.dio.personapi.dto.put.PersonPutDTO;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.model.Person;
import com.dio.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody @Valid PersonPostDTO personPostDTO) {
        return new ResponseEntity<>(personService.save(personPostDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Person>> listAll() {
        return ResponseEntity.ok(personService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) throws PersonNotFoundException {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Void> updateById(@RequestBody @Valid PersonPutDTO personPutDTO) throws PersonNotFoundException {
        personService.update(personPutDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
