package com.example.API_Web_Hackaton.repositories;

import com.example.API_Web_Hackaton.models.ActivitatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitatRepositori extends JpaRepository<ActivitatModel, Long> {
}
