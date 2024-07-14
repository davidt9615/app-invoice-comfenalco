package com.comfenalco.app_invoice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.comfenalco.app_invoice.repositories.entities.Factura;
import com.comfenalco.app_invoice.repositories.entities.Producto;
import com.comfenalco.app_invoice.services.FacturasServices;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/facturas")
@AllArgsConstructor
public class FacturaController {
    private FacturasServices facturaService;

    @GetMapping("/")
    public List<Factura> findAll(){
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Long id) {
        return facturaService.findById(id);
    }
    
    @PostMapping("/")
    public Factura guardarFactura(@RequestBody Factura factura){
        return facturaService.save(factura);
    }

    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable Long id){
        facturaService.delete(id);
    }

    @GetMapping("/filtra-productos/{term}")
    public List<Producto> filtraProductos(@PathVariable String term) {
        return facturaService.findProductoByNombre(term);
    }
    

}
