package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Controller
public class AppController {
	 @Autowired
	 private ClientService clientService;
	 @Autowired
	 private CompteService compteService;
	 @Autowired
	 private OperationService operationService;
	 @Autowired
	 private TypeCompteService typeCompteService;
	 @Autowired
	 private TypeOperationService typeOperationService;
	 
	 @RequestMapping("/")
	 public String viewHomePage(Model model) {	      
	     return "index";
	 }
	 	
	 @RequestMapping("/initialisation")
	 public String initialisation(Model model) {
		 typeOperationService.initialisation();
		 typeCompteService.initialisation();
		 return "initilisation";
	 }
	 
	 @RequestMapping("/menuCompte")
	 public String viewCompteMenuPage(Model model) {	      
	     return "menu_compte";
	 }
	 
	 @RequestMapping("/rechercheClient")
	 public String viewRecherchePage(Model model) {	      
	     return "recherche_client";
	 }
	 
	 @RequestMapping("/choixClient")
	 public String viewChoixClientPage(Model model) {
	     List<Client> listClients = clientService.listAll();
	     model.addAttribute("listClients", listClients);	      
	     return "choix_client";
	 }
	 
	 @RequestMapping("/listClient")
	 public String viewListClientPage(Model model) {
	     List<Client> listClients = clientService.listAll();
	     model.addAttribute("listClients", listClients);	      
	     return "list_client";
	 }
	 
	 @RequestMapping("/new")
	 public String showNewProductPage(Model model) {
	     Client client = new Client();
	     model.addAttribute("client", client);	      
	     return "new_client";
	 }
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public String saveProduct(@ModelAttribute("client") Client client) {
		 client.setCode(clientService.generateClientNumber());
		 clientService.save(client);	      
	     return "redirect:/";
	 }
	 
	 @RequestMapping(value = "/retraitVerification", method = RequestMethod.POST)
	 public String retraitVerification(@ModelAttribute("operation") Operation operation, @RequestParam("num_compte") String num_compte) {
		 Compte compte = new Compte();
		 compte = compteService.findByNumCompte(num_compte);
		 if(operationService.verifRetrait(operation, compte)) {
		     long millis=System.currentTimeMillis();  
		     java.sql.Date date=new java.sql.Date(millis);
		     operation.setDate_operation(date);
		     operation.setNum_compte(num_compte);
		     operation.setType_operation("retrait");
		     operationService.save(operation);
		     Double nouveauSolde = (compte.getSolde() - operation.getMontant());
		     compte.setSolde(nouveauSolde);
		     compteService.save(compte);
			return "validation_retrait"; 
		 }else {
			 return "erreur_retrait";
		 }
	 }

	 @RequestMapping(value = "/versementVerification", method = RequestMethod.POST)
	 public String versementVerification(@ModelAttribute("operation") Operation operation, @RequestParam("num_compte") String num_compte) {
		 Compte compte = new Compte();
		 compte = compteService.findByNumCompte(num_compte);
		 long millis=System.currentTimeMillis();  
		 java.sql.Date date=new java.sql.Date(millis);
		 operation.setDate_operation(date);
		 operation.setNum_compte(num_compte);
		 operation.setType_operation("versement");
		 operationService.save(operation);
		 Double nouveauSolde = (compte.getSolde() + operation.getMontant());
		 compte.setSolde(nouveauSolde);
		 compteService.save(compte);
		 return "validation_versement"; 
	 }
	 
	 @RequestMapping(value = "/listCompte", method = RequestMethod.POST)
	 public String showListComptePage(@RequestParam("user_id") String user_id, Model model) {		 		 
	     List<Compte> listComptes = compteService.findByUserId(user_id);
	     model.addAttribute("listComptes", listComptes);   
	     return "list_compte";
	 }
	 
	 @RequestMapping(value = "/lancementRechercheClient", method = RequestMethod.POST)
	 public String showRechercheClient(@RequestParam("keyWord") String keyWord, Model model) {		 		 
	     List<Client> listClients = clientService.findByKeyWord(keyWord);
	     model.addAttribute("listClients", listClients);   
	     return "list_client";
	 }
	 
	 @RequestMapping(value = "/listOperation/{num_compte}", method = RequestMethod.GET)
	 public String showListOperationPage(@PathVariable(value = "num_compte") String num_compte, Model model) {
		 List<Operation> listOperations = operationService.findByNumCompte(num_compte);
		 model.addAttribute("listOperations", listOperations);
	     return "list_operation";
	 }
	 
	 @RequestMapping(value="/retrait/{num_compte}", method = RequestMethod.GET)
	 public String showRetraitPage(@PathVariable("num_compte") String num_compte, Model model) {		 
		 Compte compte = new Compte();
		 compte = compteService.findByNumCompte(num_compte);		 
		 Operation operation = new Operation();
		 model.addAttribute("operation", operation);
		 model.addAttribute("compte", compte);
		 return "retrait_form";
	 }
	 
	 @RequestMapping(value="/versement/{num_compte}", method = RequestMethod.GET)
	 public String showVersementPage(@PathVariable("num_compte") String num_compte, Model model) {		 
		 Compte compte = new Compte();
		 compte = compteService.findByNumCompte(num_compte);		 
		 Operation operation = new Operation();
		 model.addAttribute("operation", operation);
		 model.addAttribute("compte", compte);
		 return "versement_form";
	 }
	 
	 @RequestMapping("/newCompte")
	 public String showNewComptePage(Model model) {
	     List<Client> listClients = clientService.listAll();
	     model.addAttribute("listClients", listClients);
	     
	     List<TypeCompte> listTypeCompte = typeCompteService.listAll();
	     model.addAttribute("listTypeCompte", listTypeCompte);
	     
	     Compte compte = new Compte();
	     model.addAttribute("compte", compte);
	     return "new_compte";
	 }
	 
	 @RequestMapping(value = "/saveCompte", method = RequestMethod.POST)
	 public String saveCompte(@ModelAttribute("compte") Compte compte) {		 
	     long millis=System.currentTimeMillis();  
	     java.sql.Date date=new java.sql.Date(millis);	     
	     compte.setNum_compte(compteService.generateCompteNumber());
		 compte.setDate_creation(date);		 
		 compteService.save(compte);	      
	     return "redirect:/";
	 }	 
}
