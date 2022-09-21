package fr.polytech.ds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evaluation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nomEvaluateur")
    private String nomEvaluateur;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "nbEtoiles")
    private int nbEtoiles;
    
    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private RestaurantEntity restaurant;
    
}
