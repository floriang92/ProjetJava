package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Client.findByKeyWord", query = "Select c FROM Client c Where nom LIKE CONCAT('%',?1,'%')")
public class Client {
	private Integer id;
	private String code;
	private String nom;
	
	
	protected Client() {
    }
	 
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
        return id;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
