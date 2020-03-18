package dev.lucas.foodtruck.controllers;

import dev.lucas.foodtruck.dto.OrderDto;
import dev.lucas.foodtruck.models.Order;
import dev.lucas.foodtruck.services_implementation.OrderServiceImplementation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderServiceImplementation orderServiceImplementation;

    @GetMapping
    @ApiOperation("Search for all orders at database")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Order> getAllOrders() {
        logger.info("Starting order search");
        return orderServiceImplementation.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Search for specific order at database")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@ApiParam(name = "id", type = "long") @PathVariable Long id) {
        logger.info("Starting the search");
        return orderServiceImplementation.getById(id);
    }

    @PostMapping
    @ApiOperation("Add an order at database")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> postOrder(@ApiParam(name = "order", value = "order") @RequestBody OrderDto orderDto) {
        logger.info("Starting order creation");
        Order order = orderServiceImplementation.save(orderDto);
        logger.info("Created" + order.toString());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Updates an existing orders")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrder(@ApiParam(name = "id", value = "long") @PathVariable Long id,
                                 @ApiParam(name = "order", value = "order") @RequestBody OrderDto orderDto) {
        logger.info("Starting the order update");
        orderServiceImplementation.update(id, orderDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes a order")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@ApiParam(name = "id", value = "long") @PathVariable Long id) {
        logger.info("Starting the order deletion");
        orderServiceImplementation.delete(id);
    }
}