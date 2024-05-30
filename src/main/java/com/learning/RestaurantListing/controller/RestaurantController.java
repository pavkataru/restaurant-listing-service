package com.learning.RestaurantListing.controller;

import com.learning.RestaurantListing.dto.RestaurantDto;
import com.learning.RestaurantListing.entity.Restaurant;
import com.learning.RestaurantListing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<Restaurant>> fetchAllRestaurants()
    {

        List<Restaurant> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);

    }
    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> saveRestaurants(@RequestBody Restaurant restaurant)
    {

        Restaurant restaurantAdded = restaurantService.addRestaurantInDB(restaurant);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);

    }
    @GetMapping("/fetchRestaurantById/{id}")
    public ResponseEntity<Restaurant> fetchRestaurant(@PathVariable Integer id){
    	
    	return restaurantService.findRestaurantById(id);
    	
    
    	
    }
    

}
