package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class TypeOperationService {
    @Autowired
    private TypeOperationRepository repo;     
    
    public void save(TypeOperation typeOperation) {
        repo.save(typeOperation);
    }
    
    public void initialisation() {
    	TypeOperation type1 = new TypeOperation();
    	TypeOperation type2 = new TypeOperation();    	    	
    	type1.setNom("versement");
    	type2.setNom("retrait");
    	save(type1);
    	save(type2);
    }
}
