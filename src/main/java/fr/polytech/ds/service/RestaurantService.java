package fr.polytech.ds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.polytech.ds.entity.RestaurantEntity;
import fr.polytech.ds.exception.NoRestaurantFoundException;
import fr.polytech.ds.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<RestaurantEntity> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public RestaurantEntity addRestaurant(String nom, String adresse) {
        return restaurantRepository.save(RestaurantEntity.builder().nom(nom).adresse(adresse).build());
    }

    public RestaurantEntity getRestaurantById(int id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new NoRestaurantFoundException("Pas de restaurant avec l'id : " + id));
    }

    public RestaurantEntity modifRestaurant(int id, String nom, String adresse) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(id).orElseThrow(() -> new NoRestaurantFoundException("Pas de restaurant avec l'id : " + id));
        restaurantEntity.setAdresse(adresse);
        restaurantEntity.setNom(nom);

        return restaurantEntity;
    }
    
}
