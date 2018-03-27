package com.example.calculSodexo.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.calculSodexo.enums.Choice;
import com.example.calculSodexo.model.Article;
import com.example.calculSodexo.model.Solution;
import com.example.calculSodexo.model.Ticket;
import com.example.calculSodexo.service.ArticleService;
import com.example.calculSodexo.service.TicketService;

import lombok.Getter;
import lombok.Setter;

@Component 
@Getter
public class AnalyzeTicketController extends AbstractController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ArticleService articleService;
	
	private Double montantTotal;
	
	private Double montantArticle;
	
	private String nomArticle;
	
	/**Point de départ du controller, Il correspond au sous menu "Analyser un ticket".*/
	public void go() {
		begin();
		
		this.setMontantTotal();
		
		Ticket t = new Ticket();
		t.setPrix(this.getMontantTotal());
		
		Ticket savedTicket = ticketService.save(t);
		
		print("Ajout d'un article au ticket... Entrez Q pour quitter !");
		this.setChoice();
		while (!(Choice.Quit.getValue().equals(this.getChoice()))) {
			this.addArticleToTicket(savedTicket);
			print("Ajout d'un article au ticket... Entrez Q pour quitter !");
			this.setChoice();
		}
		
		// Le ticket est complet, algorithme de résolution
		Set<Article> unchosenArticles = savedTicket.getArticles();
		Set<Article> chosenArticles = new HashSet<>();
		Set<Solution> solutions = prepareSolution(chosenArticles, unchosenArticles, savedTicket.getPrix());
		
		end();
	}
	
	public Set<Solution> prepareSolution(Set<Article> chosenArticles, Set<Article> unchosenArticles, Double montant) {
		// TODO A VIRER DANS TICKET SERVICE + FINIR ALGO
		
		// implémenter un objet solution possible qui prend le montant payable en carte +tous les articles du ticket + solution possible 

		// un ticket aura une liste de solution possible

		// fonction récursive pour trouver la solution
		
		// if solutions == null... Pas de solution + suppression du ticket

	    Iterator<Article> unchosenIterator = unchosenArticles.iterator();
	    Article article;
	    while ( unchosenIterator.hasNext()) {
	         article = unchosenIterator.next();
	         if (montant - article.getPrix() > 0) {
	            chosenArticles.add(article);
	            unchosenArticles.remove(article);
	            montant -= article.getPrix();
	            return prepareSolution(chosenArticles, unchosenArticles, montant);
	         }
	         /*else if (montant - article.getPrix() < 0) {
	             continue;
	         }
	         else {
	            return 
	        }*/
	    }
        return new HashSet<Solution>();
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
	
	public void setMontantTotal() {
		print("Montant total du ticket ?");
		Double montant = Double.valueOf(scan.nextLine());
		this.montantTotal = montant;
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
