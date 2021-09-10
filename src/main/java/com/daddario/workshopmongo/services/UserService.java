package com.daddario.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daddario.workshopmongo.domain.User;
import com.daddario.workshopmongo.dto.UserDTO;
import com.daddario.workshopmongo.repository.UserRepository;
import com.daddario.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired	//O próprio spring instância o objeto pra mim
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {

		
		User user = repo.findById(id).orElse(null);
		if (user==null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;		
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getId()).orElse(null);
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}
	
}
