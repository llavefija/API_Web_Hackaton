package com.example.API_Web_Hackaton.repositories;

import com.example.API_Web_Hackaton.models.UsuariModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariRepositori extends CrudRepository<UsuariModel, Long> {
}
