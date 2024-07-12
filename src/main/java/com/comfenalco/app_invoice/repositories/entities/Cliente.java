package com.comfenalco.app_invoice.repositories.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // con @Entity se indica que la clase cliente sera una tabla de una base de datos.
@Table(name="clientes")
@Data  // Genera codigo de los get and setter en una sola linea.
@AllArgsConstructor  // Genera codigo para ahorrar lineas del constructor
@NoArgsConstructor
public class Cliente {
    //************************************************************************************
    @Id  // Aca se indica que la siguiente linea es el Id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // se indica que la base de datos genera la llave primaria automaticamente
    private Long id;                  /*Se deben encapsular los atributos de la clase en private*/
    //*************************************************************************************
    @Column(nullable=false, name = "nombres")  // con esta anotacion indicamos que este atributo se debe llenar y se camnia el nombre de la columna  en la base de datos.
    private String nombre;
    //************************************************************************************
    @Column(nullable=false, name = "apellidos")
    private String apellido;
     //************************************************************************************
    @Column(nullable=false, unique=true)
    private String email;
     //************************************************************************************
    @Column(nullable=false) // con esta anotación indicamos que este atributo debe ser unico en la base de datos.
    private String direccion;
     //************************************************************************************
    @Column(nullable=false)
    private String celular;
     //************************************************************************************
    @Column(nullable=false)
    private Date   fechaNacimiento;
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Region region;


    @JsonIgnoreProperties(value={"cliente", "hibernateLazyInitializer", "handler"},allowSetters = true) // Se implenta esta linea con la finalidad de que no ocurra un ciclo donde se aniden objetos cliente en objetos factura y asi sucesivamente.
    @OneToMany(mappedBy ="cliente", fetch = FetchType.LAZY,cascade = CascadeType.ALL) // con mappedBy indicamos que es bidireccional
    private List<Factura> facturas;

}
