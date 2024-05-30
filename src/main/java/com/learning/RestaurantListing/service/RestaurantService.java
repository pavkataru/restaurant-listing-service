package com.learning.RestaurantListing.service;

import com.learning.RestaurantListing.dto.RestaurantDto;
import com.learning.RestaurantListing.entity.Restaurant;
import com.learning.RestaurantListing.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {


    @Autowired
    RestaurantRepository restaurantRepo;

    public List<Restaurant> findAllRestaurants() {

        List<Restaurant> restaurants = restaurantRepo.findAll();
        return restaurants;
       
   

    }

	public Restaurant addRestaurantInDB(Restaurant restaurant) {
		// TODO Auto-generated method stub
		Restaurant savedRestaurant = restaurantRepo.save(restaurant);
		return savedRestaurant;
	}

	public ResponseEntity<Restaurant> findRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		if(restaurant.isPresent()) {
			return new ResponseEntity<>(restaurant.get(),HttpStatus.OK);
		}else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	
	}
}
