package com.example.foodtruckapi.service;

import com.example.foodtruckapi.model.Lunch;
import com.example.foodtruckapi.repository.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class LunchServiceImpl implements  LunchService{

    private LunchRepository repository;

    @Autowired
    public LunchServiceImpl(LunchRepository repositoryLunch){
        this.repository = repositoryLunch;
    }

    @Override
    public Lunch findById(Long id){
        Optional<Lunch> lunchObject = repository.findById(id);
        return lunchObject.orElseThrow(() -> new Exception("Lunch Not Found"));
    }

    @Override
    public List<Lunch> getAll(){
        return repository.findAll();
    }

    @Override
    public List<Lunch> save(Lunch lunch){
        Lunch lunchObject = new Lunch(lunch.getName(), lunch.getIngredients());
        return repository.saveAll(asList(lunchObject));
    }

    @Override
    public void update(Long id, Lunch lunch){
        Lunch lunchObject = this.findById(id);
        lunchObject.setName(lunch.getName());
        lunchObject.setIngredients(lunch.getIngredients());
        repository.saveAll(asList(lunchObject));
    }

    @Override
    public void delete(Long id){
        this.findById(id);
        repository.deleteById(id);
    }
}
