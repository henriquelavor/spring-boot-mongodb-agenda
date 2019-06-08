package com.henriquelavor.agendamongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henriquelavor.agendamongodb.domain.User;
import com.henriquelavor.agendamongodb.dto.UserDTO;
import com.henriquelavor.agendamongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	
	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
}
