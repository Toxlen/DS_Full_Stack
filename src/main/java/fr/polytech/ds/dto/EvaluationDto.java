package fr.polytech.ds.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.polytech.ds.entity.EvaluationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {
    
    @JsonProperty("id")
    private int id;

    @JsonProperty("nomEvaluateur")
    @NotBlank
    @Size(max = 90)
    private String nomEvaluateur;

    @JsonProperty("commentaire")
    @NotBlank
    @Size(max = 255)
    private String commentaire;

    @JsonProperty("nbEtoiles")
    private int nbEtoiles;


    public static EvaluationDto fromEntity(EvaluationEntity evaluationEntity) {
        return EvaluationDto.builder()
            .id(evaluationEntity.getId())
            .nomEvaluateur(evaluationEntity.getNomEvaluateur())
            .commentaire(evaluationEntity.getCommentaire())
            .nbEtoiles(evaluationEntity.getNbEtoiles())
            .build();
    }
}
