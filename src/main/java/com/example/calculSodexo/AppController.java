package com.example.calculSodexo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.calculSodexo.controller.AbstractController;
import com.example.calculSodexo.controller.AnalyzeTicketController;
import com.example.calculSodexo.enums.Choice;
import com.example.calculSodexo.model.Article;
import com.example.calculSodexo.model.Ticket;
import com.example.calculSodexo.repository.ArticleRepository;
import com.example.calculSodexo.service.ArticleService;
import com.example.calculSodexo.service.TicketService;

@Component
public class AppController extends AbstractController implements CommandLineRunner {
	
	@Autowired
	private AnalyzeTicketController analyzeTicketController;

	@Override
	public void run(String... args) throws Exception {
		begin();
		
		do {	
			print("1- Analyser un nouveau ticket");
			print("2- Liste des articles payables Sodexo");
			print("Pressez Q pour quitter");

			this.choice = this.scan.nextLine();
			
			if (Choice.NewTicket.getValue().equals(choice)) {
				analyzeTicketController.go();
			}
		}
		while(!(Choice.Quit.getValue().equals(this.choice)));
		
		end();
	}
}
