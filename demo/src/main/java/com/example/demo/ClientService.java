package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional

public class ClientService {
    @Autowired
    private ClientRepository repo;
     
    public List<Client> listAll() {
        return repo.findAll();
    }
     
    public void save(Client client) {
        repo.save(client);
    }
     
    public Client get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
	public List<Client> findByKeyWord(String keyWord) {
		return repo.findByKeyWord(keyWord);
	}
	
	public String generateClientNumber () {
		Integer n = 10;
        String str = "0123456789"; 
        StringBuilder s = new StringBuilder(n); 
        for (int i = 0; i < n; i++) { 
        	int index = (int)(str.length() * Math.random()); 
        	s.append(str.charAt(index)); 
        } 
        return s.toString(); 
	}
}
