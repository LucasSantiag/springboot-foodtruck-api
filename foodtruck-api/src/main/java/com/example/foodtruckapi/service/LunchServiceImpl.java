package com.example.foodtruckapi.service;

import com.example.foodtruckapi.model.Lunch;
import com.example.foodtruckapi.repository.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return lunchObject.orElseThrow(() -> new Exception("Not Found"));
    }

    @Override
    public List<Lunch> getAll(){
        return repository.findAll();
    }


}
