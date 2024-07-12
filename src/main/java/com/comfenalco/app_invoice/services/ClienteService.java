package com.comfenalco.app_invoice.services;

import java.util.List;

import com.comfenalco.app_invoice.repositories.entities.Cliente;
// En esta interfaz se definen los metodos que se deben utilizar para Cliente.
public interface ClienteService {

    List<Cliente> findAll(); //Retorna una lista con todos los clientes.

    Cliente findById(Long id); // Encuentra un cliente por medio de su ID.

    Cliente save(Cliente cliente);

    Cliente update(Cliente cliente, Long id);  // recibe el objeto cliente y el id del cliente a modificar.

    void delete(Long id);
}
