package com.foodtruck.demo.services_implementation;

import com.foodtruck.demo.exceptions.EntityNotFoundException;
import com.foodtruck.demo.models.Lunch;
import com.foodtruck.demo.repositories.LunchRepository;
import com.foodtruck.demo.services.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class LunchServiceImplementation implements LunchService {

    private LunchRepository repository;

    @Autowired
    public LunchServiceImplementation(LunchRepository repositoryLunch){
        this.repository = repositoryLunch;
    }

    @Override
    public Lunch getById(Long id){
        Optional<Lunch> lunchObject = repository.findById(id);
        return lunchObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Iterable<Lunch> getAll(){
        return repository.findAll();
    }

    @Override
    public Iterable<Lunch> save(Lunch lunch){ return repository.saveAll(asList(lunch)); }

    @Override
    public Iterable<Lunch> update(Long id, Lunch lunch){ return repository.saveAll(asList(lunch)); }

    @Override
    public void delete(Long id){
        this.getById(id);
        repository.deleteById(id);
    }
}
