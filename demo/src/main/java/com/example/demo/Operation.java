package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Operation.findByNumCompte", query = "Select o FROM Operation o Where num_compte = ?1")
public class Operation {
	private Integer id;
	private Date date_operation;
	private Double montant;
	private String type_operation;
	private String num_compte;	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
        return id;
    }

	public Date getDate_operation() {
		return date_operation;
	}

	public void setDate_operation(Date date_operation) {
		this.date_operation = date_operation;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNum_compte() {
		return num_compte;
	}

	public void setNum_compte(String num_compte) {
		this.num_compte = num_compte;
	}

	public String getType_operation() {
		return type_operation;
	}

	public void setType_operation(String type_operation) {
		this.type_operation = type_operation;
	}
	
}
