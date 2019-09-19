package com.foodtruck.demo.services_implementation;

import com.foodtruck.demo.dto.LunchDto;
import com.foodtruck.demo.exceptions.EntityNotFoundException;
import com.foodtruck.demo.models.Lunch;
import com.foodtruck.demo.repositories.LunchRepository;
import com.foodtruck.demo.services.LunchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LunchServiceImplementation implements LunchService {

    private static final Logger logger = LoggerFactory.getLogger(LunchServiceImplementation.class);

    private LunchRepository repository;

    @Autowired
    public LunchServiceImplementation(LunchRepository repositoryLunch) {
        this.repository = repositoryLunch;
    }

    @Override
    public Lunch findById(Long id) {
        logger.info("Searching ID");
        Optional<Lunch> lunchObject = repository.findById(id);
        return lunchObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Lunch> getAll() {
        logger.info("Searching");
        return repository.findAll();
    }

    @Override
    public Lunch save(Lunch lunch) {
        logger.info("Creating");
        return repository.save(lunch);
    }

    @Override
    public void update(Long id, LunchDto lunch) {
        Lunch byId = this.findById(id);
        byId.setName(lunch.getName());
        logger.info("Updating");
        repository.save(byId);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        logger.info("Deleting");
        repository.deleteById(id);
    }
}
