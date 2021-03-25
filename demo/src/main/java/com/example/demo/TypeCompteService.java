package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional

public class TypeCompteService {
    @Autowired
    private TypeCompteRepository repo;     
     
    public List<TypeCompte> listAll() {
        return repo.findAll();
    }
    
    public TypeCompte get(Integer id) {
        return repo.findById(id).get();
    }
    
    public void save(TypeCompte TypeCompte) {
        repo.save(TypeCompte);
    }
    
    public void initialisation() {
    	TypeCompte compte1 = new TypeCompte();
    	TypeCompte compte2 = new TypeCompte();
    	compte1.setDecouvert(1000.0);
    	compte1.setLabel("courant");
    	compte1.setTaux(0.0);
    	compte2.setDecouvert(0.0);
    	compte2.setLabel("epargne");
    	compte2.setTaux(1.5);
    	save(compte1);
    	save(compte2);
    }
}