package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeCompte {
	private Integer id;
	private String label;
	private Double taux;
	private Double decouvert;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
        return id;
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public Double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}
	
}
