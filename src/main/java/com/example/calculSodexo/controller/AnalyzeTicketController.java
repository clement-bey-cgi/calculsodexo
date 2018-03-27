package com.example.calculSodexo.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.calculSodexo.enums.Choice;
import com.example.calculSodexo.model.Article;
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
	
	/**Point de départ du controller, Il correspond au sous menu.*/
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
