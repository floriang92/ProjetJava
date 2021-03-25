package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {
	public List<Compte> findByUserId(String user_id);
	public Compte findByNumCompte(String num_compte);
}
