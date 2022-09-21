package fr.polytech.ds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom")
    private String nom;
    
    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> evaluations;
}
