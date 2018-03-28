package com.example.calculSodexo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.calculSodexo.controller.AbstractController;
import com.example.calculSodexo.controller.AnalyzeTicketController;
import com.example.calculSodexo.enums.AppControllerChoice;

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

			this.setChoice();
			
			if (AppControllerChoice.NewTicket.getValue().equals(choice)) {
				analyzeTicketController.go();
			}
		}
		while(!(AppControllerChoice.Quit.getValue().equals(this.choice)));
		
		end();
	}
}
