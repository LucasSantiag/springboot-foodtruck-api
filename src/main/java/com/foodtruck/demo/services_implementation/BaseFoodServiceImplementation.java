package com.foodtruck.demo.services_implementation;

import com.foodtruck.demo.dto.BaseFoodDto;
import com.foodtruck.demo.exceptions.EntityNotFoundException;
import com.foodtruck.demo.models.BaseFood;
import com.foodtruck.demo.repositories.BaseFoodRepository;
import com.foodtruck.demo.services.BaseFoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseFoodServiceImplementation implements BaseFoodService {

    private static final Logger logger = LoggerFactory.getLogger(BaseFoodServiceImplementation.class);

    private BaseFoodRepository repository;

    @Autowired
    public BaseFoodServiceImplementation(BaseFoodRepository repositoryLunch) {
        this.repository = repositoryLunch;
    }

    @Override
    public BaseFood findById(Long id) {
        logger.info("Searching ID");
        Optional<BaseFood> baseFoodObject = repository.findById(id);
        return baseFoodObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<BaseFood> getAll() {
        logger.info("Searching");
        return repository.findAll();
    }

    @Override
    public BaseFood save(BaseFood baseFood) {
        logger.info("Creating");
        return repository.save(baseFood);
    }

    @Override
    public void update(Long id, BaseFoodDto baseFood) {
        BaseFood byId = this.findById(id);
        byId.setName(baseFood.getName());
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
