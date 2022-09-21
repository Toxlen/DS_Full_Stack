package fr.polytech.ds.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.polytech.ds.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    @NotBlank
    @Size(max = 90)
    private final String nom;

    @JsonProperty("adresse")
    @NotBlank
    @Size(max = 255)
    private final String adresse;
    
    private List<EvaluationDto> evaluations;

    public static RestaurantDto fromEntity(RestaurantEntity restaurantEntity) {
        return RestaurantDto.builder()
            .id(restaurantEntity.getId())
            .nom(restaurantEntity.getNom())
            .adresse(restaurantEntity.getAdresse())
            .evaluations(restaurantEntity.getEvaluations().stream().map(EvaluationDto::fromEntity).collect(Collectors.toList()))
            .build();
    }
}
