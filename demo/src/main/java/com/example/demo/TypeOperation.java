package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeOperation {
	private Integer id;
	private String nom;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
        return id;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}