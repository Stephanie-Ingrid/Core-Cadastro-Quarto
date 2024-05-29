package com.clickquartos.corecadastroquarto.repository;

import com.clickquartos.corecadastroquarto.documento.Quarto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends MongoRepository<Quarto, String> {
}
