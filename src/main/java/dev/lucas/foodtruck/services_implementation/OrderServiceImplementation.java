package dev.lucas.foodtruck.services_implementation;

import dev.lucas.foodtruck.dto.OrderDto;
import dev.lucas.foodtruck.exceptions.EntityNotFoundException;
import dev.lucas.foodtruck.models.Ingredient;
import dev.lucas.foodtruck.models.Order;
import dev.lucas.foodtruck.repositories.OrderRepository;
import dev.lucas.foodtruck.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImplementation implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImplementation.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IngredientServiceImplementation ingredientServiceImplementation;

    @Override
    public Order getById(Long id) {
        logger.info("Validating id: " + id);
        Optional<Order> orderObject = orderRepository.findById(id);
        return orderObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Order> getAll() {
        logger.info("Getting all orders");
        return orderRepository.findAll();
    }

    @Override
    public Order save(OrderDto orderDto) {
        logger.info("Saving order");
        List<Ingredient> ingredientList = orderDto.getIngredientsIdList().stream().map(ingredientId -> ingredientServiceImplementation.getById(ingredientId)).collect(Collectors.toList());
        double price = ingredientList.stream().mapToDouble(Ingredient::getPrice).sum();
        Order order = new Order().setComments(orderDto.getComments()).setIngredientList(ingredientList).setPrice(price);
        return orderRepository.save(order);
    }

    @Override
    public void update(Long id, OrderDto orderDto) {
        logger.info("Validating order id: " + id);
        Order orderById = this.getById(id);
        List<Ingredient> ingredientList = orderDto.getIngredientsIdList().stream().map(ingredientId -> ingredientServiceImplementation.getById(ingredientId)).collect(Collectors.toList());
        double price = ingredientList.stream().mapToDouble(Ingredient::getPrice).sum();
        orderById.setComments(orderDto.getComments()).setIngredientList(ingredientList).setPrice(price);
        logger.info("Updating order");
        orderRepository.save(orderById);
    }

    @Override
    public void delete(Long id) {
        logger.info("Validating order");
        this.getById(id);
        logger.info("Deleting order");
        orderRepository.deleteById(id);
    }
}
