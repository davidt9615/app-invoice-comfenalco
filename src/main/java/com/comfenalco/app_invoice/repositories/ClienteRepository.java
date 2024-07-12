package com.comfenalco.app_invoice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.comfenalco.app_invoice.repositories.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
        // se crea el CRUD del cliente implementando CrudRepository

}
