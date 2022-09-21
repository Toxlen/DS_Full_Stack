package fr.polytech.ds.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.ds.dto.RestaurantDto;
import fr.polytech.ds.service.RestaurantService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController()
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public @ResponseBody Collection<RestaurantDto> getRestaurant() {
        log.info("GET restaurants");
        
        return restaurantService.getRestaurants().stream().map(RestaurantDto::fromEntity).collect(Collectors.toList());        
    }

    @GetMapping("/restaurants/{id}")
    public @ResponseBody RestaurantDto getRestaurant(@PathVariable int id)
    {
        log.info("GET restaurant " + id);
        return RestaurantDto.fromEntity(restaurantService.getRestaurantById(id));
    }

    @PostMapping("/restaurants")
    public @ResponseBody RestaurantDto postRestaurant(@Valid @RequestBody RestaurantDto restaurantDto){
        log.info("POST restaurant : " + restaurantDto.toString());
        return RestaurantDto.fromEntity(restaurantService.addRestaurant(restaurantDto.getNom(), restaurantDto.getAdresse()));
    }

    @PutMapping("/restaurants/{id}")
    public @ResponseBody RestaurantDto putRestaurant(@PathVariable int id, @Valid @RequestBody RestaurantDto restaurantDto){
        log.info("PUT restaurant : " + restaurantDto.toString());
        return RestaurantDto.fromEntity(restaurantService.modifRestaurant(id, restaurantDto.getNom(), restaurantDto.getAdresse()));
    }
}
