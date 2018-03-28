package com.example.calculSodexo.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.calculSodexo.enums.AnalyzeTicketChoice;
import com.example.calculSodexo.model.Article;
import com.example.calculSodexo.model.Solution;
import com.example.calculSodexo.model.Ticket;
import com.example.calculSodexo.repository.SolutionRepository;
import com.example.calculSodexo.service.ArticleService;
import com.example.calculSodexo.service.TicketService;

import lombok.Getter;

@Component 
@Getter
public class AnalyzeTicketController extends AbstractController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ArticleService articleService;
	
	// TODO VIRER APRES TEST
	@Autowired
	private SolutionRepository solutionRepository;
	
	private Double montantTotalTicket;
	
	private Double montantArticle;
	
	private String nomArticle;
	
	/**Point de départ du controller, Il correspond au sous menu "Analyser un ticket".*/
	public void go() {
		begin();
		
		// Creation Ticket
		this.setMontantTotalTicket();
		Ticket t = new Ticket();
		t.setPrix(this.getMontantTotalTicket());
		Ticket savedTicket = ticketService.save(t);
		
		// Ajout des articles au ticket
		print("Ajout d'un article au ticket... Entrez Q pour quitter !");
		this.setChoice();
		while (!(AnalyzeTicketChoice.Quit.getValue().equals(this.getChoice()))) {
			this.addArticleToTicket(savedTicket);
			print("Ajout d'un article au ticket... Entrez Q pour quitter !");
			this.setChoice();
		}
		
		// TICKET COMPLET, ALGORITHME DE RESOLUTION
//		Set<Article> unchosenArticles = savedTicket.getArticles();
//		Set<Article> chosenArticles = new HashSet<>();
//		Set<Solution> solutions = ticketService.prepareSolution(chosenArticles, unchosenArticles, savedTicket.getPrix());
		
		// TEST
		Solution solution = new Solution();
		solution.setTicket(savedTicket);
		Set<Article> articles = new HashSet<>();
		articles.add(articleService.get(8));
		articles.add(articleService.get(9));
		solution.setArticles(articles);
		
		solutionRepository.save(solution);
		
		solution.setArticles(null);
		
		solutionRepository.save(solution);
		// FIN TEST
		
		end();
	}


	public void setChoice() {
		this.choice = this.scan.nextLine();
	}
	
	public void addArticleToTicket(Ticket t) {
		Article article = new Article();
		
		this.setMontantArticle();
		this.setNomArticle();
		
		article.setPrix(this.getMontantArticle());
		article.setNom(this.getNomArticle());
		article.setTicket(t);
		
		articleService.save(article);
	}
	
	public void setMontantTotalTicket() {
		print("Montant total du ticket ?");
		Double montant = Double.valueOf(scan.nextLine());
		this.montantTotalTicket = montant;
	}
	
	public void setMontantArticle() {
		print("Prix de l'article ?");
		Double montant = Double.valueOf(scan.nextLine());
		this.montantArticle = montant;
	}
	
	public void setNomArticle() {
		print("Nom de l'article ?");
		String nom = scan.nextLine();
		this.nomArticle = nom;
	}
}
