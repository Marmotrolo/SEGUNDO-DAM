package com.example.tiendainformaticaspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tiendainformaticaspring.modelos.Cliente;
import com.example.tiendainformaticaspring.repositorios.ClienteRepository;

import exceptions.ProductNotFoundException;


@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id)
			.orElseThrow(() -> new ProductNotFoundException("Cliente no encontrado con ID: " + id));
	}

	@Override
	public Cliente save(Cliente cliente) {
		// Verificar que no existe ya un cliente con ese email
		if (cliente.getId() == null && clienteRepository.existsByEmail(cliente.getEmail())) {
			throw new IllegalArgumentException("Ya existe un cliente con el email: " + cliente.getEmail());
		}
		return clienteRepository.save(cliente);
	}

	@Override
	public void deleteById(Long id) {
		if (!clienteRepository.existsById(id)) {
			throw new ProductNotFoundException("No se puede eliminar. Cliente no encontrado con ID: " + id);
		}
		clienteRepository.deleteById(id);
	}

	@Override
	public Cliente findByEmail(String email) {
		return clienteRepository.findByEmail(email)
			.orElseThrow(() -> new ProductNotFoundException("Cliente no encontrado con email: " + email));
	}

	@Override
	public List<Cliente> findByNombreContaining(String nombre) {
		return clienteRepository.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public Cliente actualizarTelefono(Long id, String nuevoTelefono) {
		Cliente cliente = findById(id);
		cliente.setTelefono(nuevoTelefono);
		return clienteRepository.save(cliente);
	}
}
