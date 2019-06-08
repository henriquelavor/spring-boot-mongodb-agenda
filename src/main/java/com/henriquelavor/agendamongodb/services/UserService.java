package com.henriquelavor.agendamongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquelavor.agendamongodb.domain.User;
import com.henriquelavor.agendamongodb.dto.UserDTO;
import com.henriquelavor.agendamongodb.repository.UserRepository;
import com.henriquelavor.agendamongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	//Autowired é o mecanismo de injecao de dependencia automatico do spring
	
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
