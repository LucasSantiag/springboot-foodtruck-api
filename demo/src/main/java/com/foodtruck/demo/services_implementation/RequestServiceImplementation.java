package com.foodtruck.demo.services_implementation;

import com.foodtruck.demo.models.Request;
import com.foodtruck.demo.repositories.RequestRepository;
import com.foodtruck.demo.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RequestServiceImplementation implements RequestService {

    private Logger logger = LoggerFactory.getLogger(RequestServiceImplementation.class);

    private RequestRepository repository;

    @Autowired
    public RequestServiceImplementation(RequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public Request findById(Long id) {
        return null;
    }

    @Override
    public List<Request> getAll() {
        return null;
    }

    @Override
    public Request save(Request request) {
        return null;
    }

    @Override
    public void update(Long id, Request request) {

    }

    @Override
    public void delete(Long id) {

    }
}
