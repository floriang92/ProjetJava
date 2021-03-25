package com.example.demo;

public class OperationVerification {
	public boolean verifRetrait(Operation operation, Compte compte) {
		System.out.println("dans operationVerification");
		if(operation.getMontant() > compte.getSolde()) {
			return false;
		}else {
			return true;
		}
	}
}
