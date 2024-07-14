 package com.comfenalco.app_invoice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.comfenalco.app_invoice.repositories.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE ?1") // AQUI SE REALIZA UNA CONSULTA PERSONALIZADA.
    public List<Producto> findByNombre(String term);

    public List<Producto> findByNombreContainingIgnoreCase(String term);

    public List<Producto> findByNombreStartingWithIgnoreCase(String term);

    public List<Producto> findByPrecioBetween(Double precioStart, Double precioEnd);

}
