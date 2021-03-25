package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional

public class CompteService {
    @Autowired
    private CompteRepository repo;
     
    public List<Compte> listAll() {
        return repo.findAll();
    }
     
    public void save(Compte compte) {
        repo.save(compte);
    }
     
    public Compte get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }

	public List<Compte> findByUserId(String user_id) {
		return repo.findByUserId(user_id);
	}

	public Compte findByNumCompte(String num_compte) {
		return repo.findByNumCompte(num_compte);
	}
	
	public String generateCompteNumber () {
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
