package com.utn.videosApiRest.services;

import com.utn.videosApiRest.entities.Persona;
import com.utn.videosApiRest.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

@Service
public class PersonaService implements BaseService<Persona> {
    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    } // Tambien puedo colocar un @Autowired  a personaRepository, en vez de hacer esto.

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
            List<Persona> entities = personaRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            entity = personaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(entity);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(personaRepository.existsById(id)) {
                personaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
