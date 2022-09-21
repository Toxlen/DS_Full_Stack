package fr.polytech.ds.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.ds.dto.EvaluationDto;
import fr.polytech.ds.service.EvaluationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController()
@RequiredArgsConstructor
@Slf4j
public class EvaluationController {
    private final EvaluationService evaluationService;

    @PostMapping("/restaurants/{idRestaurant}/evaluations")
    public @ResponseBody EvaluationDto postEvaluations(@PathVariable int idRestaurant, @Valid @RequestBody EvaluationDto evaluationDto) {
        log.info("POST evaluation " + evaluationDto.toString() + "on restaurant " + idRestaurant);
        return EvaluationDto.fromEntity(evaluationService.addEvaluation(idRestaurant, evaluationDto.getNomEvaluateur(), evaluationDto.getCommentaire(), evaluationDto.getNbEtoiles()));
    }

    @DeleteMapping("/evaluations/{idEvaluation}")
    public @ResponseBody void delEvalutions(@PathVariable int idEvaluation) {
        log.info("DEL evaluation " + idEvaluation);
        evaluationService.removeEvaluation(idEvaluation);
    }
    
}
