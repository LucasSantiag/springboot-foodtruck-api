package com.lucas.foodtruck.servicies_implementation;

import com.example.foodtruckapi.exception.EntityNotFoundException;
import com.example.foodtruckapi.model.Lunch;
import com.example.foodtruckapi.repository.LunchRepository;
import com.example.foodtruckapi.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class LunchServiceImpl implements LunchService {

    private LunchRepository repository;

    @Autowired
    public LunchServiceImpl(LunchRepository repositoryLunch){
        this.repository = repositoryLunch;
    }

    @Override
    public Lunch findById(Long id){
        Optional<Lunch> lunchObject = repository.findById(id);
        return lunchObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Lunch> getAll(){
        return repository.findAll();
    }

    @Override
    public List<Lunch> save(Lunch lunch){
        return repository.saveAll(asList(lunch));
    }

    @Override
    public List<Lunch> update(Long id, Lunch lunch){
        return repository.saveAll(asList(lunch));
    }

    @Override
    public void delete(Long id){
        this.findById(id);
        repository.deleteById(id);
    }
}
