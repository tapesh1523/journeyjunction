package com.journeyjunction.journey_junction.repositories;

import com.journeyjunction.journey_junction.entities.AttractionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface AttractionTypeRepository extends JpaRepository<AttractionType, Long> {
    AttractionType findByName(String name);
}
