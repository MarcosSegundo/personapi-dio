package com.dio.personapi.service;

import com.dio.personapi.dto.post.PersonPostDTO;
import com.dio.personapi.dto.put.PersonPutDTO;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.mapper.PersonMapper;
import com.dio.personapi.model.Person;
import com.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public Person save(PersonPostDTO personPostDTO) {
        return personRepository.save(personMapper.toModel(personPostDTO));
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) throws PersonNotFoundException {
        return verifyIfExists(id);
    }

    public void update(PersonPutDTO personPutDTO) throws PersonNotFoundException {
        Person savedPerson = verifyIfExists(personPutDTO.getId());
        Person updatedPerson = personMapper.toModel(personPutDTO);
        updatedPerson.setId(savedPerson.getId());
        personRepository.save(updatedPerson);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
