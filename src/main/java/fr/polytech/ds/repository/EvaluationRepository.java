package fr.polytech.ds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.polytech.ds.entity.EvaluationEntity;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer> {
    
}
