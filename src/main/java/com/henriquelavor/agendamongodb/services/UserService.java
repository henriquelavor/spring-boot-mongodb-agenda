package com.henriquelavor.agendamongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquelavor.agendamongodb.domain.User;
import com.henriquelavor.agendamongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	//Autowired é o mecanismo de injecao de dependencia automatico do spring
	
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
