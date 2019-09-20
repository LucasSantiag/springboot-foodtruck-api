package com.foodtruck.demo.services;

import com.foodtruck.demo.dto.BaseFoodDto;
import com.foodtruck.demo.models.BaseFood;

import java.util.List;

public interface BaseFoodService {

    BaseFood findById(Long id);

    List<BaseFood> getAll();

    BaseFood save(BaseFood baseFood);

    void update(Long id, BaseFoodDto baseFoodDto);

    void delete(Long id);
}
