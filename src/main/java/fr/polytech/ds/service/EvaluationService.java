package fr.polytech.ds.service;

import org.springframework.stereotype.Service;

import fr.polytech.ds.entity.EvaluationEntity;
import fr.polytech.ds.entity.RestaurantEntity;
import fr.polytech.ds.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;

    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluation(int idRestaurant, String nomEvaluateur, String commentaire, int nbEtoiles) {
        RestaurantEntity restaurantEntity = restaurantService.getRestaurantById(idRestaurant);
        EvaluationEntity evaluationEntity = EvaluationEntity.builder().nomEvaluateur(nomEvaluateur).commentaire(commentaire).nbEtoiles(nbEtoiles).restaurant(restaurantEntity).build();
        
        return evaluationRepository.save(evaluationEntity);
    }

    public void removeEvaluation(int idEvaluation) {
        evaluationRepository.deleteById(idEvaluation);
    }
}
