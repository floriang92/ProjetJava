package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;



@Entity
@NamedQuery(name="Compte.findByUserId", query = "Select c FROM Compte c Where user_id = ?1")
@NamedQuery(name="Compte.findByNumCompte", query = "Select c FROM Compte c Where num_compte = ?1")
public class Compte {
	private Integer id;
	private Date date_creation;
	private String num_compte;
	private Double solde;
	private String user_id;
	private Integer type_compte_id;
	
	protected Compte() {
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
        return id;
    }

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getNum_compte() {
		return num_compte;
	}

	public void setNum_compte(String num_compte) {
		this.num_compte = num_compte;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType_compte_id() {
		return type_compte_id;
	}

	public void setType_compte_id(Integer type_compte_id) {
		this.type_compte_id = type_compte_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
