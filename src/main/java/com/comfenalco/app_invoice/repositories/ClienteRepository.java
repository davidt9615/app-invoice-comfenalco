package com.comfenalco.app_invoice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.comfenalco.app_invoice.repositories.entities.Cliente;
import com.comfenalco.app_invoice.repositories.entities.Region;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
        // se crea el CRUD del cliente implementando CrudRepository
        @Query("from Region") // Se escribe el nomnbre de la clase es una sintxis similar a SQL pero no lo es
        public List<Region> findAllRegiones();

}
