package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional

public class OperationService {
    @Autowired
    private OperationRepository repo;
    @Autowired
    private TypeCompteService typeCompteService;
     
    public void save(Operation operation) {
        repo.save(operation);
    }
     
    public Operation get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }

	public List<Operation> findByNumCompte(String num_compte) {
		return repo.findByNumCompte(num_compte);
	}
	
	public boolean verifRetrait(Operation operation, Compte compte) {
		TypeCompte typeCompte = new TypeCompte();
		typeCompte = typeCompteService.get( compte.getType_compte_id());
		
		double seuil = compte.getSolde() + typeCompte.getDecouvert();
		if(operation.getMontant() > seuil) {
			return false;
		}else {
			return true;
		}
	}
}
