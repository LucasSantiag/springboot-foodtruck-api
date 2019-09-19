package com.foodtruck.demo.services_implementation;

import com.foodtruck.demo.exceptions.EntityNotFoundException;
import com.foodtruck.demo.models.Lunch;
import com.foodtruck.demo.repositories.LunchRepository;
import com.foodtruck.demo.services.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LunchServiceImplementation implements LunchService {

    private LunchRepository repository;

    @Autowired
    public LunchServiceImplementation(LunchRepository repositoryLunch) {
        this.repository = repositoryLunch;
    }

    @Override
    public Lunch findById(Long id) {
        Optional<Lunch> lunchObject = repository.findById(id);
        return lunchObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Lunch> getAll() {
        return repository.findAll();
    }

    @Override
    public Lunch save(Lunch lunch) {
        return repository.save(lunch);
    }

    @Override
    public void update(Long id, Lunch lunch) {
        this.findById(id);
        lunch.setId(id);
        repository.save(lunch);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
