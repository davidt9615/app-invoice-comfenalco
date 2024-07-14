package com.comfenalco.app_invoice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comfenalco.app_invoice.repositories.ClienteRepository;
import com.comfenalco.app_invoice.repositories.entities.Cliente;
import com.comfenalco.app_invoice.repositories.entities.Region;
import com.comfenalco.app_invoice.services.ClienteService;
import com.comfenalco.app_invoice.utils.exceptions.ClienteNotFoundException;

import lombok.AllArgsConstructor;

//Se crea la clase llamada ClienteServiceImpl la cual debe implementar todos los metodos declarados en ClienteService.
// En esta carpeta de impl se creara la logica del negocio.
@AllArgsConstructor  //realizamos inyección de dependencias.
@Service
public class ClienteServiceImpl implements ClienteService{

    //************************************************************************************************************ */
    private ClienteRepository clienteRepository; // se define la variable de tipo cliente repository

    // estamos inyectando la interfaz CrudRepository.
    //************************************************************************************************************ */


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll(); 
    }
 
    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente update(Cliente cliente, Long id) {
        
        // En esta parte del codigo se pregunta si el ID indicado existe en la base de datos si no indica un mensaje de error.
        Optional<Cliente> clienteOptional=clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente clienteCurrent=clienteOptional.get();
            clienteCurrent.setNombre(cliente.getNombre());
            clienteCurrent.setApellido(cliente.getApellido());
            clienteCurrent.setEmail(cliente.getEmail());
            clienteCurrent.setDireccion(cliente.getDireccion());
            clienteCurrent.setFechaNacimiento(cliente.getFechaNacimiento());
            clienteRepository.save(clienteCurrent); // si el cliente ya tiene una ID se realiza update, cuando el cliente no tiene ID es un insert.
            return clienteCurrent;
        }else{
            throw new ClienteNotFoundException("Cliente con id: "+id+" no existe");
        }
        
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return clienteRepository.findAllRegiones();
    }

}
